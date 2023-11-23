package com.examples.inheritance;

public class Bicycle {

    int cadence;
    int speed;
    int gear = 1;

    public Bicycle(int startCadence, int startGear, int startSpeed) {
        cadence = startCadence;
        gear = startGear;
        speed = startSpeed;
    }

    public Bicycle() {
        cadence = 10;
        gear = 1;
        speed = 0;
    }

    public void changeCadence (int newValue) {
        cadence += newValue;
    }

    public void changeGear (int newValue) {
        gear += newValue;
    }

    public void speedUp (int increment) {
        speed += increment;
    }

    public void applyBrakes (int decrement) {
        speed -= decrement;
    }

    public void printStatus () {
        System.out.println("cadence: " + cadence + " speed: " + speed + 
        " gear: " + gear);
    }

    public void printDescription() {
        System.out.println("\nBike is in gear " + this.gear +
            " with a cadence of " + this.cadence +
            " and travelling at the speed of " + this.speed + ".");
    }
}
