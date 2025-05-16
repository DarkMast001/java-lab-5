package org.example.task_5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void processFiles(String inputPath, String outputPath) {
        Scanner in = null;
        PrintWriter out = null;
        boolean success = false;

        try {
            in = new Scanner(Paths.get(inputPath));
            out = new PrintWriter(outputPath);

            while (in.hasNext()) {
                String word = in.next();
                out.println(word.toLowerCase());
            }

            success = true;

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Неизвестная ошибка: " + e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                System.err.println("Ошибка при закрытии PrintWriter: " + e.getMessage());
            }

            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                System.err.println("Ошибка при закрытии Scanner: " + e.getMessage());
            }

            if (success) {
                System.out.println("Данные успешно обработаны и записаны в файл.");
            } else {
                System.out.println("Обработка завершена с ошибкой.");
            }
        }
    }

    public static void main(String[] args) {
        String inputPath = "src/main/java/org/example/task_5/input.txt";
        String outputPath = "src/main/java/org/example/task_5/output.txt";

        processFiles(inputPath, outputPath);
    }
}
