package Hw3_21002139.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        List<Shape> list = generateRandomListOfShape();
        for (Shape x : list) {
            System.out.println(x.toString());
        }
    }

    private static List<Shape> generateRandomListOfShape() {
        Random random = new Random();
        List<Shape> list = new ArrayList<>();
        int n = random.nextInt(0, 100);
        int encodeOfShape = 0;
        double radius, width, height;
        for (int i = 0; i < n; i++) {
            encodeOfShape = random.nextInt(0, 3);
            Shape newShape = new Circle(0);
            if (encodeOfShape == 0) {
                radius = random.nextDouble(0.0, 1000.0);
                newShape = new Circle(radius);
            } else if (encodeOfShape == 1) {
                radius = random.nextDouble(0.0, 1000.0);
                newShape = new Sphere(radius);
            } else {
                width = random.nextDouble(0.0, 1000.0);
                height = random.nextDouble(0.0, 1000.0);
                newShape = new Rectangle(width, height);
            }
            list.add(newShape);
        }
        return list;   
    }
}
