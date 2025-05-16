package org.example.task_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HtmlLogFormatter {
    public void formatToHtml(List<String> logs, String outputFilePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
            writeHtmlHeader(writer);
            writeLogs(writer, logs);
            writeHtmlFooter(writer);
            System.out.println("HTML-файл успешно создан: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    private void writeHtmlHeader(PrintWriter writer) {
        writer.println("<!DOCTYPE html>");
        writer.println("<html lang=\"ru\">");
        writer.println("<head>");
        writer.println("    <meta charset=\"UTF-8\">");
        writer.println("    <title>Протокол работы</title>");
        writer.println("    <style>");
        writer.println("        body { font-family: Arial, sans-serif; background: #f9f9f9; padding: 20px; }");
        writer.println("        h1 { color: #333; }");
        writer.println("        .log-entry { border-bottom: 1px solid #ddd; padding: 10px 0; }");
        writer.println("        pre { margin: 0; background: #fff; padding: 5px; }");
        writer.println("    </style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("    <h1>Протокольные записи</h1>");
    }

    private void writeLogs(PrintWriter writer, List<String> logs) {
        for (String log : logs) {
            writer.println("    <div class=\"log-entry\">");
            writer.println("        <pre>" + log + "</pre>");
            writer.println("    </div>");
        }
    }

    private void writeHtmlFooter(PrintWriter writer) {
        writer.println("</body>");
        writer.println("</html>");
    }
}
