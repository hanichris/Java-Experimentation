package com.examples.circle;

public class Circle {
    private int x;
    private int y;

    public Circle(int centerX, int centerY) {
        x = centerX;
        y = centerY;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int newValue) {
        this.x = newValue;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int newValue) {
        this.y = newValue;
    }

    public void printCenter() {
        System.out.printf("Center (x, y): (%d, %d)\n", this.x, this.y);
    }
}
