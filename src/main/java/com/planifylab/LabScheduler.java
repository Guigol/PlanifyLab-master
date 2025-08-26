package com.planifylab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabScheduler {

    private static int toMinutes(String hhmm) {
        String[] parts = hhmm.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private static String toHHMM(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }

    private static int priorityValue(String p) {
        switch (p) {
            case "STAT": return 1;
            case "URGENT": return 2;
            default: return 3; // ROUTINE
        }
    }

    public static Map<String, Object> planifyLab(List<Sample> samples,
                                                 List<Technician> technicians,
                                                 List<Equipment> equipment) {

        // Disponibilités initiales
        Map<String, Integer> techAvailability = new HashMap<>();
        for (Technician t : technicians) {
            techAvailability.put(t.id, toMinutes(t.startTime));
        }
        Map<String, Integer> equipAvailability = new HashMap<>();
        for (Equipment e : equipment) {
            equipAvailability.put(e.id, 0);
        }

        // Étape 1 : trier les échantillons
        samples.sort((a, b) -> {
            int pa = priorityValue(a.priority);
            int pb = priorityValue(b.priority);
            if (pa != pb) return pa - pb;
            return toMinutes(a.arrivalTime) - toMinutes(b.arrivalTime);
        });

        List<ScheduleEntry> schedule = new ArrayList<>();
        int conflicts = 0;
        int firstStart = Integer.MAX_VALUE;
        int lastEnd = 0;

        // Étape 2 & 3 : assignation
        for (Sample s : samples) {
            int arrival = toMinutes(s.arrivalTime);

            Technician chosenTech = null;
            for (Technician t : technicians) {
                if (t.speciality.equals(s.type) || t.speciality.equals("GENERAL")) {
                    chosenTech = t;
                    break;
                }
            }
            if (chosenTech == null) { conflicts++; continue; }

            Equipment chosenEquip = null;
            for (Equipment e : equipment) {
                if (e.type.equals(s.type) && e.available) {
                    chosenEquip = e;
                    break;
                }
            }
            if (chosenEquip == null) { conflicts++; continue; }

            int start = Math.max(
                    Math.max(arrival, techAvailability.get(chosenTech.id)),
                    Math.max(equipAvailability.get(chosenEquip.id), toMinutes(chosenTech.startTime))
            );
            int end = start + s.analysisTime;

            if (end > toMinutes(chosenTech.endTime)) {
                conflicts++;
                continue;
            }

            techAvailability.put(chosenTech.id, end);
            equipAvailability.put(chosenEquip.id, end);

            schedule.add(new ScheduleEntry(
                    s.id, chosenTech.id, chosenEquip.id,
                    toHHMM(start), toHHMM(end), s.priority
            ));

            firstStart = Math.min(firstStart, start);
            lastEnd = Math.max(lastEnd, end);
        }

        // Étape 4 : métriques
        int totalTime = (lastEnd > firstStart) ? lastEnd - firstStart : 0;
        int busyTime = 0;
        for (ScheduleEntry se : schedule) {
            busyTime += toMinutes(se.endTime) - toMinutes(se.startTime);
        }
        double efficiency = (totalTime > 0)
                ? (busyTime * 100.0) / (totalTime * (technicians.size() + equipment.size()))
                : 0.0;

        Metrics metrics = new Metrics(totalTime, efficiency, conflicts);

        Map<String, Object> result = new HashMap<>();
        result.put("schedule", schedule);
        result.put("metrics", metrics);
        return result;
    }
}

