package org.example.task_15;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
                "Пользователь вошёл в систему",
                "Изучаем возможности Java 17",
                "Программирование на C++ может быть опасным для психики",
                "Время выполнения запроса: 100 мс"
        );

        // Путь к выходному HTML-файлу
        String outputFilePath = "protocol.html";

        // Создаём форматировщик и вызываем метод
        HtmlLogFormatter formatter = new HtmlLogFormatter();
        formatter.formatToHtml(logs, outputFilePath);

        System.out.println("Форматирование завершено.");
    }
}
