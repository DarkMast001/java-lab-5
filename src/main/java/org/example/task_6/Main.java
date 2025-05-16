package org.example.task_6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/task_6/data.txt";
        try (BufferedReader in = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден: " + ex.getMessage());
        } catch (InvalidPathException ex) {
            System.out.println("Неверный путь файла: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Ошибка ввода-вывода: " + ex.getMessage());
        }
    }
}
