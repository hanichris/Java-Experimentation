package com.examples.bicycle;

public class ACMEBicycle implements Bicycle {
    
    int cadence;
    int speed;
    int gear = 1;

    public ACMEBicycle(int startCadence, int startGear, int startSpeed) {
        cadence = startCadence;
        gear = startGear;
        speed = startSpeed;
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
}
