package com.examples.inheritance;

public class MountainBike extends Bicycle {
    private String suspension;

    public MountainBike(
        int startCadence,
        int startGear,
        int startSpeed,
        String suspensionType
    ) {
        super(startCadence, startGear, startSpeed);
        this.setSuspension(suspensionType);
    }

    public String getSuspension() {
       return this.suspension;
    }

    public void setSuspension(String suspensionType) {
        this.suspension = suspensionType;
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("The MountainBike has a " +
        this.getSuspension() + " suspension.");
    }
}
