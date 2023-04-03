package Hw1_21002139.ex4;

public class Sphere {
    private double radius = 0;                      // ban kinh
    private double[] coordinates = new double[3];   // toa do 3D (x,y,z)

    public Sphere(double radius, double[] coordinates) {
        this.radius = radius;
        this.coordinates = coordinates;
    }
    public Sphere(double radius, double x, double y, double z) {
        this.radius = radius;
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = z;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double[] getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
    public void setX(double x) {
        coordinates[0] = x;
    }
    public double getX() {
        return coordinates[0];
    }
    public void setY(double x) {
        coordinates[1] = x;
    }
    public double getY() {
        return coordinates[1];
    }
    public void setZ(double x) {
        coordinates[2] = x;
    }
    public double getZ() {
        return coordinates[2];
    }
    
    // Interface
    // Calculate Square
    public double square() {
        return 4 * Math.PI * radius * radius;
    }

    // Calculate Volume
    public double volume() {
        return 4/3 * Math.PI * radius * radius * radius;
    }

    // Identify 2 Sphere is intersect or is not intersect
    // If 2 Sphere is intersect then are they contain each other
    public void relationship(Sphere anotherSphere) {
        if (isIntersect(anotherSphere)) {
            System.out.println("2 Sphere are intersect");
            if (isContain(anotherSphere)) {
                System.out.println("And this sphere contain the other");
            } else if (isContained(anotherSphere)) {
                System.out.println("And this sphere is contained by the other");
            } else {
                System.out.println("And no sphere contain the other");
            }
        } else {
            System.out.println("2 Sphere are not intersect");
        }
    }

    // Distance of 2 Sphere (from its center)
    public double distance(Sphere anotherSphere) {
        double result = (this.getX() - anotherSphere.getX()) * (this.getX() - anotherSphere.getX()) +
                        (this.getY() - anotherSphere.getY()) * (this.getY() - anotherSphere.getY()) +
                        (this.getZ() - anotherSphere.getZ()) * (this.getZ() - anotherSphere.getZ());
        return Math.sqrt(result);
    }

    // Is 2 Sphere intersect
    public boolean isIntersect(Sphere anotherSphere) {
        return distance(anotherSphere) <= this.getRadius() + anotherSphere.getRadius();
    }

    // Is this Sphere contain the other Sphere
    public boolean isContain(Sphere anotherSphere) {
        return this.getRadius() >= distance(anotherSphere) + anotherSphere.getRadius();
    }

    // Is this Sphere be contained by the other Sphere
    public boolean isContained(Sphere anotherSphere) {
        return this.getRadius() + distance(anotherSphere) <= anotherSphere.getRadius();
    }

    public static void main(String[] args) {
        Sphere firstSphere = new Sphere(9, 0, 0, 0);
        System.out.println("Square of firstSphere: " + firstSphere.square());
        System.out.println("Volume of firstSphere: " + firstSphere.volume());

        double[] randomCoordinate = new double[] {10 * Math.random(), 10 * Math.random(), 10 * Math.random()};
        Sphere secondSphere = new Sphere(1, randomCoordinate);

        firstSphere.relationship(secondSphere);
    }
}