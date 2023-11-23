package com.examples.inheritance;

public class RoadBike extends Bicycle {
    private int tireWidth;

    public RoadBike(
        int startCadence,
        int startGear,
        int startSpeed,
        int newTireWidth
    ) {
        super(startCadence, startGear, startSpeed);
        this.setTireWidth(newTireWidth);
    }

    public int getTireWidth() {
        return this.tireWidth;
    }

    public void setTireWidth(int newTireWidth) {
        this.tireWidth = newTireWidth;
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("The RoadBike has " + this.getTireWidth() +
        " MM tires.");
    }
}
