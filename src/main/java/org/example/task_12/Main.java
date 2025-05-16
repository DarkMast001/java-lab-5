package org.example.task_12;

import java.util.Random;

public class Main {
    public static int min(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым или null");
        }

        int minValue = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < minValue) {
                minValue = values[i];
            }
        }

        assert checkMin(minValue, values) : "Ошибка проверки: найденное минимальное значение неверно";

        return minValue;
    }

    private static boolean checkMin(int minValue, int[] values) {
        for (int value : values) {
            if (value < minValue) {
                return false;
            }
        }
        return true;
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100_000);
        }
        return arr;
    }

    public static void main(String[] args) {
        int size = 1_000_000;
        int iterations = 100;
        int[] array = generateRandomArray(size);

        long totalTime = 0;

        for (int i = 0; i < iterations; i++) {
            long start = System.nanoTime();
            int result = min(array);
            long end = System.nanoTime();

            totalTime += (end - start);
        }

        double avgTimeMs = (double) totalTime / iterations / 1_000_000;
        System.out.printf("Среднее время выполнения: %.3f мс%n", avgTimeMs);
    }

    // java -ea Main.java : Среднее время выполнения: 0,476 мс
    // java -da Main.java : Среднее время выполнения: 0,268 мс
    // java Main.java (строчка с assert закомментирована) : Среднее время выполнения: 0,249 мс
}
