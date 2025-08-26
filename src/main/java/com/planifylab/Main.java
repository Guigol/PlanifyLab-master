package com.planifylab;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        try {
            InputData input = JsonLoader.load("src/main/resources/data.json");
            Map<String, Object> result = LabScheduler.planifyLab(
                    input.samples, input.technicians, input.equipment
            );

            // Option 2 : données en dur
            /*
            List<Sample> samples = Arrays.asList(
                    new Sample("S1", "BLOOD", "STAT", 30, "09:00", "P1"),
                    new Sample("S2", "BLOOD", "ROUTINE", 45, "08:30", "P2")
            );

            List<Technician> technicians = Arrays.asList(
                    new Technician("T1", "Alice", "BLOOD", "08:00", "17:00")
            );

            List<Equipment> equipment = Arrays.asList(
                    new Equipment("E1", "Analyseur Sang", "BLOOD", true)
            );

            result = LabScheduler.planifyLab(samples, technicians, equipment);
            */

            // Affichage du planning
            System.out.println("Schedule:");
            List<ScheduleEntry> schedule = (List<ScheduleEntry>) result.get("schedule");
            for (ScheduleEntry entry : schedule) {
                System.out.println(entry);
            }

            // Affichage des métriques
            System.out.println("\nMetrics:");
            System.out.println(result.get("metrics"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
