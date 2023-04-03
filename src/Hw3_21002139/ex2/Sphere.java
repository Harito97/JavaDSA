package Hw3_21002139.ex2;

//Tạo đối tượng Sphere thừa kế Shape
public class Sphere extends Shape {
    private double radius = 0;

    public Sphere(double radius) {
        // Hàm khởi tạo
        this.radius = radius;
        name = "Sphere";
    }

    @Override
    protected double getVolume() {
        // Hoàn thành thân hàm
        return 4/3 * Math.PI * radius * radius * radius;
    }
    @Override
    protected double getArea() {
        // Hoàn thành thân hàm
        return 4 * Math.PI * radius * radius;
    }
    @Override
    protected double getPerimeter() {
        return 0;
    }
    @Override
    public String toString() {
        return this.name + " has area = " + this.getArea() + ", and volume = " + this.getVolume();
    }
}
