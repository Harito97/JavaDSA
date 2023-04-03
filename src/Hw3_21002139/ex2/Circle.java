package Hw3_21002139.ex2;

//Tạo đối tượng Circle thừa kế Shape
public class Circle extends Shape {
    private double radius = 0;
    public Circle(double radius) {
        // Hàm khởi tạo
        this.radius = radius;
        name = "Circle";
    }

    @Override
    protected double getVolume() {
        return 0;
    }
    @Override
    protected double getArea() {
        // Hoàn thành thân hàm
        return Math.PI * radius * radius;
    }
    @Override
    protected double getPerimeter() {
        // Hoàn thành thân hàm
        return 2 * Math.PI * radius;
    }
    @Override
    public String toString() {
        return this.name + " has perimeter = " + this.getPerimeter() + ", and area = " + this.getArea();
    }
}
