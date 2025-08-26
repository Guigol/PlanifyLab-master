package com.planifylab;

public class Equipment {
    public String id;
    public String name;
    public String type;      // BLOOD, URINE, TISSUE
    public boolean available;

    public Equipment(String id, String name, String type, boolean available) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.available = available;
    }
}
