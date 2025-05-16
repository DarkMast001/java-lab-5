package org.example.task_13;

import java.util.*;

public class LogFilter {
    private final Set<String> forbiddenWords;

    public LogFilter(Collection<String> forbiddenWords) {
        this.forbiddenWords = new HashSet<>(forbiddenWords);
    }

    public List<String> filterLogs(List<String> logs) {
        List<String> filtered = new ArrayList<>();

        for (String log : logs) {
            if (!containsForbiddenWord(log)) {
                filtered.add(log);
            }
        }

        return filtered;
    }

    private boolean containsForbiddenWord(String line) {
        String lowerLine = line.toLowerCase();

        for (String word : forbiddenWords) {
            if (lowerLine.contains(word.toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}
