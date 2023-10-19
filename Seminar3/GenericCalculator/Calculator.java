package Seminar3.GenericCalculator;

public class Calculator {

    public static  <T extends Number, E extends Number> double sum(T a, E b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static  <T extends Number, E extends Number> double subtract(T a, E b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static  <T extends Number, E extends Number> double multiply(T a, E b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static  <T extends Number, E extends Number> double divide(T a, E b) {
        return a.doubleValue() / b.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(2, 3.65f));
        System.out.println(Calculator.divide(10.0d, 5.0f));
        System.out.println(Calculator.subtract(7, 1.5f));
        System.out.println(Calculator.multiply(3.d, 2.0d));
    }
}
