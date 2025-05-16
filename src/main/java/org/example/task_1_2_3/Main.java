package org.example.task_1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Double> readValues(String filePath) throws FileNotFoundException, NumberFormatException {
        File file = new File(filePath);
        ArrayList<Double> result = new ArrayList<>();

        if (!file.exists()) {
            throw new FileNotFoundException("Файл не найден или недоступен для чтения: " + filePath);
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                try {
                    double value = Double.parseDouble(line);
                    result.add(value);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Ошибка при парсинге числа в строке: " + line);
                }
            }
        }
        return result;
    }

    public static double sumOfValues(String filePath) throws FileNotFoundException, NumberFormatException {
        ArrayList<Double> values = readValues(filePath);

        double sum = 0.0;
        for (Double value : values) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        String filePath = "./src/main/java/org/example/task_1_2_3/data.txt";
        try {
            double total = sumOfValues(filePath);
            System.out.println("Сумма значений в файле: " + total);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Некорректный формат числа: " + e.getMessage());
        }
    }
}
