package com.examples.bicycle;

interface Bicycle {
    void changeCadence (int newValue);

    void changeGear (int newValue);

    void speedUp (int increment);

    void applyBrakes (int decrement);
}
