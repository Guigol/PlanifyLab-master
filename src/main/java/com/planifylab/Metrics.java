
package com.planifylab;

public class Metrics {
    int totalTime;
    double efficiency;
    int conflicts;

    public Metrics(int totalTime, double efficiency, int conflicts) {
        this.totalTime = totalTime;
        this.efficiency = efficiency;
        this.conflicts = conflicts;
    }

    @Override
    public String toString() {
        return String.format("Total: %d min, Efficiency: %.2f%%, Conflicts: %d",
                totalTime, efficiency, conflicts);
    }
}
