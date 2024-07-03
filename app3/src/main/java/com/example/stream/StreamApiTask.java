package com.example.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamApiTask {

    @Data
    @AllArgsConstructor
    public static class Book {
        private String name;
        private List<String> authors;
        private Double price;
    }

    // 1. Получить список дорогих книг стоимостью более 500.0
    // 2. Получить список всех уникальных авторов в дорогих книгах
    // 3. Рассчитать общую стоимость всех дорогих книг

    public static void main(String[] args) {
        SpringApplication.run(StreamApiTask.class, args);
        List<Book> books = Arrays.asList(
                new Book("Book1", List.of("Author1", "Author2"), 800.0),
                new Book("Book2", List.of("Author1", "Author2"), 600.0),
                new Book("Book3", List.of("Author3"), 200.0)
        );

        // 1. Отфильтровать книги стоимостью более 50.0
        List<Book> expensiveBooks = books.stream()
                .filter(book -> book.price > 500.0)
                .collect(Collectors.toList());

        System.out.println("Expensive Books:");
        expensiveBooks.forEach(System.out::println);

        // 2. Получить список всех уникальных авторов в книгах более 50
        List<String> uniqueAuthors = books.stream()

                .filter(book -> book.getPrice() > 500.0)
                .flatMap(book -> book.getAuthors().stream())
//                .map(Book::getAuthors)
//                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nUnique authors:");
        uniqueAuthors.forEach(System.out::println);

        // 3. Рассчитать общую стоимость всех дорогих книг
        double totalCost = books.stream()
                .filter(book -> book.getPrice() > 500.0)
                .map(Book::getPrice)
                .mapToDouble(i -> i)
                .sum();
        double totalCost1 = books.stream()
                .filter(book -> book.getPrice() > 500.0)
                .mapToDouble(Book::getPrice)
                .reduce((a,b) -> a + b)
                .orElse(Integer.MIN_VALUE);
        double totalCost2 = books.stream()
                .filter(book -> book.getPrice() > 500.0)
                .map(Book::getPrice)
                .collect(Collectors.summingDouble(Double::doubleValue));

        Optional<Double> reduce = books.stream().map(book -> book.getPrice()).reduce((a, b) -> a + b);

        double sum = expensiveBooks.stream()
                .map(Book::getPrice)
                .reduce(Double::sum).orElse(null);
        System.out.println("sum" + sum);

        System.out.println("\nTotal Cost of Books: $" + reduce );

        Stream.of("E", "C", "A").peek(System.out::println)
                .sorted()
                .forEach(System.out::println);

        Stream<String> distinct = Stream.of("A", "C", "E", "W").distinct();

        distinct.anyMatch(e -> {
            System.out.println(e);
            return e.startsWith("E");
        });

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        Stream<String> streamList = list.stream();
        list.add("three");

        boolean result = streamList.anyMatch(e -> {
            return e.equals("three");
        });

        System.out.println(result);


    }
}
