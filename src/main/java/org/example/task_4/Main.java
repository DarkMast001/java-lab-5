package org.example.task_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Result readValues(String filename) {
        File file = new File(filename);
        ArrayList<Double> result = new ArrayList<>();

        if (!file.exists() || !file.canRead()) {
            return new Result(1, "Файл не найден или недоступен для чтения: " + filename);
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                try {
                    double value = Double.parseDouble(line);
                    result.add(value);
                } catch (NumberFormatException e) {
                    return new Result(2, "Ошибка при парсинге числа в строке: " + line);
                }
            }
        } catch (Exception e) {
            return new Result(1, "Ошибка при чтении файла: " + e.getMessage());
        }

        return new Result(result);
    }

    public static Result sumOfValues(String filename) {
        Result result = readValues(filename);

        if (!result.success) {
            return result;
        }

        double sum = 0.0;
        for (Double value : result.values) {
            sum += value;
        }

        ArrayList<Double> sumList = new ArrayList<>();
        sumList.add(sum);
        return new Result(sumList);
    }

    public static void main(String[] args) {
        String filePath = "./src/main/java/org/example/task_4/data.txt";
        Result result = sumOfValues(filePath);

        if (result.success) {
            System.out.println(result.values.get(0));
        } else {
            switch (result.errorCode) {
                case 1:
                    System.err.println("Ошибка доступа к файлу: " + result.errorMessage);
                    break;
                case 2:
                    System.err.println("Ошибка формата данных: " + result.errorMessage);
                    break;
                default:
                    System.err.println("Неизвестная ошибка: " + result.errorMessage);
            }
        }
    }
}
