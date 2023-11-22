package com.examples.objects;

public enum Planet {
    /* Each enum constant is declared with values for mass and radius
     * These values are passed to the constructor when the constant is
     * created. Java requires the constants to be defined first prior to any
     * fields or methods.
     * Also, when there are field or methods, the list of enums must end in
     * a semicolon.
     */
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private final double mass;
    private final double raidus;

    /* The constructor for an enum type must be package-private
     * or private access. It automatically creates the constants that
     * are defined at the beginning of the enum body. You can't invoke
     * the enum constructor yourself
     */
    Planet(double mass, double raidus) {
        this.mass = mass;
        this.raidus = raidus;
    }

    private double mass() { return mass; };
    private double raidus() { return raidus; };

    public static final double G = 6.67300E-11;

    double surfaceGravity() {
        return G * mass / (raidus * raidus);
    }

    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }

        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / EARTH.surfaceGravity();

        for (Planet p : Planet.values()) {
            System.out.printf("Your weight on %s is %f\n",
                                p, p.surfaceWeight(mass));
        }

        System.out.println("Earth's mass: " + EARTH.mass());
        System.out.println("Earth's radius: " + EARTH.raidus());
    }
}
