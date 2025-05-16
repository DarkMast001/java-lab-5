package org.example.task_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> forbiddenWords = Arrays.asList("секс", "наркотики", "C++");

        LogFilter filter = new LogFilter(forbiddenWords);

        List<String> logs = new ArrayList<>(Arrays.asList(
                "Пользователь вошёл в систему",
                "Обсуждение наркотиков в чате обсуждения",
                "Изучаем возможности Java 17",
                "Программирование на C++ может быть опасным для психики",
                "Время выполнения запроса: 100 мс"
        ));

        List<String> safeLogs = filter.filterLogs(logs);

        System.out.println("Фильтрованный список записей:");
        for (String log : safeLogs) {
            System.out.println("- " + log);
        }
    }
}
