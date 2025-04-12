package com.task.algoritms;

import java.util.HashMap;
import java.util.Map;

public class TopStudents {
    public String findTopStudents(String studentData, String courseInfo) {
        // Создаем карту для хранения оценок по предметам
        Map<String, Map<String, Integer>> subjectGrades = new HashMap<>();

        // Обрабатываем данные о студентах
        String[] entries = studentData.split(";");
        for (String entry : entries) {
            // Разделяем запись на студента, предмет и оценку
            String[] parts = entry.split(",");
            if (parts.length < 3) {
                continue; // Пропускаем некорректные записи
            }

            String student = parts[0];
            String subject = parts[1];
            int grade = Integer.parseInt(parts[2]);

            // Добавляем оценку в карту
            subjectGrades.putIfAbsent(subject, new HashMap<>());
            Map<String, Integer> grades = subjectGrades.get(subject);
            grades.put(student, Math.max(grades.getOrDefault(student, 0), grade));
        }

        // Формируем результат
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Map<String, Integer>> entry : subjectGrades.entrySet()) {
            String subject = entry.getKey();
            Map<String, Integer> grades = entry.getValue();

            // Находим максимальную оценку и студента, который её получил
            String topStudent = null;
            int maxGrade = -1;
            for (Map.Entry<String, Integer> gradeEntry : grades.entrySet()) {
                if (gradeEntry.getValue() > maxGrade) {
                    maxGrade = gradeEntry.getValue();
                    topStudent = gradeEntry.getKey();
                }
            }

            // Добавляем результат в строку
            if (topStudent != null) {
                result.append(topStudent).append(",").append(maxGrade).append("\n");
            }
        }

        return result.length() > 0 ? result.toString().trim() : "Никто"; // Убираем лишние пробелы и переносы
    }

    public String generateReport(String input) {
        // Разделяем входные данные по точке с запятой
        String[] entries = input.split(";");
        // Создаем карту для хранения данных по кварталам
        Map<String, Map<String, Integer>> quarterlySales = new HashMap<>();

        for (String entry : entries) {
            // Разделяем дату и товар
            String[] parts = entry.split(":");
            if (parts.length != 2) {
                continue; // Пропускаем некорректные записи
            }

            String date = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            // Получаем квартал из даты
            String quarter = getQuarter(date);
            if (quarter == null) {
                continue; // Пропускаем некорректные даты
            }

            // Добавляем данные в карту
            quarterlySales.putIfAbsent(quarter, new HashMap<>());
            Map<String, Integer> products = quarterlySales.get(quarter);
            products.put(product, products.getOrDefault(product, 0) + quantity);
        }

        // Формируем результат
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Map<String, Integer>> entry : quarterlySales.entrySet()) {
            String quarter = entry.getKey();
            Map<String, Integer> products = entry.getValue();

            result.append(quarter).append(": ");
            for (Map.Entry<String, Integer> productEntry : products.entrySet()) {
                result.append(productEntry.getKey()).append(": ").append(productEntry.getValue()).append(" ");
            }
            result.append("\n");
        }

        return result.toString().trim(); // Убираем лишние пробелы и переносы
    }

    private String getQuarter(String date) {
        // Пример формата даты: 2023-01-01
        String[] parts = date.split("-");
        if (parts.length != 3) {
            return null; // Некорректный формат даты
        }

        int month = Integer.parseInt(parts[1]);
        if (month >= 1 && month <= 3) {
            return "Q1";
        } else if (month >= 4 && month <= 6) {
            return "Q2";
        } else if (month >= 7 && month <= 9) {
            return "Q3";
        } else if (month >= 10 && month <= 12) {
            return "Q4";
        } else {
            return null; // Некорректный месяц
        }
    }

    public String countDigits(String digits) {
        // Создаем карту для хранения количества каждой цифры
        Map<Character, Integer> digitCount = new HashMap<>();

        // Считаем количество каждой цифры
        for (char digit : digits.toCharArray()) {
            if (Character.isDigit(digit)) {
                digitCount.put(digit, digitCount.getOrDefault(digit, 0) + 1);
            }
        }

        // Формируем результат
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : digitCount.entrySet()) {
            if (result.length() > 0) {
                result.append(", ");
            }
            // Увеличиваем количество на 1
            result.append(entry.getKey()).append(":").append(entry.getValue() + 1);
        }

        // Возвращаем результат в виде строки
        return result.toString();
    }
}
