package org.example.task_10;

public class Main {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число должно быть > 0");
        }

        if (n == 0 || n == 1) {
            System.out.println(n + " = 1");
            printCurrentStackTrace();
            return 1;
        }

        long result = n * factorial(n - 1);

        System.out.println(n + " = " + result);
        printCurrentStackTrace();

        return result;
    }

    private static void printCurrentStackTrace() {
        Exception e = new Exception("Трассировка стека:");
        e.printStackTrace();
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Вычисляем факториал(" + number + ")");
        long result = factorial(number);
        System.out.println("Результат: " + result);
    }
}
