package Hw1_21002139_PhamNgocHai.ex3;

import java.util.Scanner;

public class ComplexNumber {
    private double img;
    private double real;
    
    public ComplexNumber() {
    }

    public ComplexNumber(double img, double real) {
        this.img = img;
        this.real = real;
    }

    public void inputComplexNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input img number of complex number: ");
        this.img = sc.nextDouble();
        System.out.print("Input real number of complex number: ");
        this.real = sc.nextDouble();
        sc.close();
    }

    public double getImg() {
        return img;
    }

    public void setImg(double img) {
        this.img = img;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void print() {
        if (img >= 0 && real >= 0) {
            System.out.printf("%4f%s%4f", this.img, "i + ", this.real);
        } else if (img < 0 && real >= 0) {
            System.out.printf("%s%4f%s%4f", "- ", Math.abs(this.img), "i + ", this.real);
        } else if (img >= 0 && real < 0) {
            System.out.printf("%4f%s%4f", this.img, "i - ", Math.abs(this.real));
        } else {
            System.out.printf("%s%4f%s%4f", "- ", Math.abs(this.img), "i - ", Math.abs(this.real));
        }
        System.out.println();
    }

    public ComplexNumber add(ComplexNumber another) {
        return new ComplexNumber(this.img + another.img, this.real + another.real);
    }

    public ComplexNumber multi(ComplexNumber another) {
        double imgResult = this.real * another.img + another.real * this.img;
        double realResult = this.real * another.real - this.img * another.img;

        return new ComplexNumber(imgResult, realResult);
    }

    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(9.7, 7.9);
        ComplexNumber b = new ComplexNumber();
        b.inputComplexNumber();
        System.out.println("a and b are: ");
        a.print();
        System.out.println();
        b.print();

        // Test add method
        // Add 2 complex number
        ComplexNumber addResult = a.add(b);
        System.out.println("\nResult of add 2 complex number a and b");
        addResult.print();
        // Add many complex number
        System.out.println("\nResult of add many complex number a + b + (a + b)");
        a.add(b).add(addResult).print();

        // Test multi method
        // Multi 2 complex number
        ComplexNumber multiResult = a.multi(b);
        System.out.println("\nResult of multi 2 complex number a and b");
        multiResult.print();
        // Multi many complex number
        System.out.println("\nResult of multi many complex number a * b * (a * b)");
        a.multi(b).multi(multiResult).print();
    }
}