package com.example.manager;

public class ParkingLot {
    private String name;
    private boolean isApproved;

    public ParkingLot(String name) {
        this.name = name;
        this.isApproved = false; // 默认未审核
    }

    public String getName() {
        return name;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void approve() {
        isApproved = true;
    }
}
