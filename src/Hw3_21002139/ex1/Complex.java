package Hw3_21002139.ex1;

import java.util.Random;
import java.util.Scanner;

public class Complex {
    private float real; //phần thực
    private float image; //phần ảo

    public Complex(float r, float i) {
        // Hàm khởi tạo
        real = r;
        image = i;
    }
    public Complex add(Complex c) {
        // Cộng số phức hiện tại với số phức c
        float newReal = real + c.real;
        float newImage = image + c.image;
        return new Complex(newReal, newImage);
    }
    public Complex minus(Complex c) {
        // Trừ số phức hiện tại cho số phức c
        float newReal = real - c.real;
        float newImage = image - c.image;
        return new Complex(newReal, newImage);
    }
    public Complex time(Complex c) {
        // Nhân số phức hiện tại với số phức c
        float newReal = real * c.real - image * c.image;
        float newImage = real * c.image + image * c.real;
        return new Complex(newReal, newImage);
    }
    public float realpart() {
        return real;
    }
    public float imagepart() {
        return image;
    }
    @Override
    public String toString() {
        if (image == 0) {
            return "[" + real + "]";
        }
        if (real == 0) {
            if (image > 0) {
                return "[" + image + "i]";
            }
            return "[ - " + Math.abs(image) + "i]";
        }
        if (image > 0) {
            return "[" + real + " + " + image + "i]";
        }
        // In ra số phức
        return "[" + real + " - " + Math.abs(image) + "i]";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // System.out.print("Input n is the number of number complex: ");
        // int n = sc.nextInt();
        // Complex[] complexArray = new Complex[n];
        // System.out.print("Nhap lan luot phan real truoc, phan image sau cua tung so phuc trong n so phuc: ");
        // for (int i = 0; i < n; i++) {
        //     complexArray[i] = new Complex(sc.nextFloat(), sc.nextFloat());
        // }

        Complex[] complexArray = randomComplexNumber();
        int n = complexArray.length;
        System.out.println("Array Complex Number generated has " + n + " elements.");

        System.out.print("Input the index v that you want to show the complex number at that position: ");
        int v = sc.nextInt();
        printComplexAtXIndex(v, complexArray);
        sc.close();
        
        System.out.print("Sum of " + n + " complex number you inputted is: ");
        Complex sum = new Complex(0, 0);
        for (int i = 0; i < n; i++) {
            sum = sum.add(complexArray[i]);
        }
        System.out.println(sum.toString());
    }

    private static void printComplexAtXIndex(int x, Complex[] complexArray) {
        if (complexArray == null || x < 0 || x > complexArray.length - 1) {
            System.out.println("Out of index");
            return;
        }
        System.out.println(complexArray[x].toString());
    }

    // Another application of complex number
    // Create a random array of complex number
    private static Complex[] randomComplexNumber() {
        Random random = new Random();
        int n = random.nextInt(6, 10);
        Complex[] array = new Complex[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Complex(random.nextFloat(-1000, 1000), random.nextFloat(-1000, 1000));
        }
        return array;    
    }
}