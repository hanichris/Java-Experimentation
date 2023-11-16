package com.examples.bicycle;

public class MountainBike extends ACMEBicycle {
    int seatHeight;

    public MountainBike(int startHeight, int startCadence, int startGear, int startSpeed) {
        super(startCadence, startGear, startSpeed);
        seatHeight = startHeight;
    }

    public void setHeight(int newValue) {
        seatHeight += newValue;
    }
}
