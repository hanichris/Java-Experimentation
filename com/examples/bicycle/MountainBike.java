package com.examples.bicycle;

public class MountainBike extends ACMEBicycle {
    private int seatHeight;

    public MountainBike(int startHeight, int startCadence, int startGear, int startSpeed) {
        super(startCadence, startGear, startSpeed);
        seatHeight = startHeight;
    }

    public int getSeatHeight(){
        return seatHeight;
    }

    public void setSeatHeight(int newValue) {
        seatHeight = newValue;
    }
}
