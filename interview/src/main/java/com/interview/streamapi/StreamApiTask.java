package com.interview.streamapi;

import static java.util.stream.Collectors.groupingBy;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication(scanBasePackageClasses = {
        StreamApiTask.class})
@EnableJpaRepositories(basePackages = "com.interview")
@EntityScan(value = "com.interview")
@EnableWebMvc
public class StreamApiTask {

    @Data
    @AllArgsConstructor
    public static class Book {
        private String name;
        private List<String> authors;
        private Double price;
    }

    // 1. Получить список дорогих книг стоимостью более 500.00
    // 1. Получить список дорогих книг стоимостью более 500.00 где хотябы один автор написал еще одну книгу стоимостью более 500.00

    // 2. Получить список всех уникальных авторов в дорогих книгах
    // 2. Получить список всех уникальных авторов в дорогих книгах которые написали не менее 2 дорогих книг
    // 3. Рассчитать общую стоимость всех дорогих книг

    public static void main(String[] args) {
        SpringApplication.run(StreamApiTask.class, args);
        List<Book> books = Arrays.asList(
                new Book("Book1", List.of("Author1", "Author2"), 800.00),
                new Book("Book2", List.of("Author1", "Author2"), 600.00),
                new Book("Book3", List.of("Author3"), 200.00)
        );

        // 1. Отфильтровать книги стоимостью более 50.0
        List<Book> expensiveBooks = books.stream()
                .filter(book -> book.price > 500.00)
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
                .filter(book -> book.getPrice() > 500.00)
                .mapToDouble(Book::getPrice)
                .sum();

        double totalCost2 = books.stream()
                .filter(book -> book.getPrice() > 500.00)
                .mapToDouble(Book::getPrice)
                .reduce((a,b) -> a + b)
                .orElse(Integer.MIN_VALUE);

        double totalCost4 = books.stream()
                .filter(book -> book.getPrice() > 500.00)
                .mapToDouble(Book::getPrice)
                .reduce(0,(a,b) -> {return a + b;});
//                .reduce((a,b) -> {return a + b;}).orElse(Integer.MIN_VALUE);


        double totalCost3 = books.stream()
                .filter(book -> book.getPrice() > 500.00)
                .map(Book::getPrice)
                .collect(Collectors.summingDouble(Double::doubleValue));



        double sum = expensiveBooks.stream()
                .map(Book::getPrice)
                .reduce(Double::sum).orElse(null);
        System.out.println("sum" + sum);

        System.out.println("\nTotal Cost of Books: $" + totalCost );

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

        boolean result = streamList.anyMatch(e -> e.equals("three"));
        System.out.println(result);


        Map<String, String> map = new TreeMap<>();


//        System.out.println(expensiveBooks.stream().map(e -> e.getName()).collect(Collectors.joining(",")));

    }

    public static void main2(String[] args) {
        SpringApplication.run(StreamApiTask.class, args);
        List<Book> books = Arrays.asList(
                new Book("Book1", List.of("Author1", "Author2"), 800.00),
                new Book("Book2", List.of("Author3", "Author4"), 600.00),
                new Book("Book3", List.of("Author3"), 200.00),
                new Book("Book4", List.of("Author2", "Author5"), 700.00),
                new Book("Book5", List.of("Author4"), 300.00)
        );


        List<Book> expensiveBooks = books.stream()
                .filter(book -> book.getPrice() > 500.00 &&
                        books.stream()
                                .filter(otherBook -> !otherBook.equals(book) && otherBook.getPrice() > 500.00)
                                .flatMap(otherBook -> otherBook.getAuthors().stream())
                                .anyMatch(author -> book.getAuthors().contains(author))
                )

                .toList();


//        System.out.println("expens" + collect2);

        System.out.println("Expensive Books:");
        expensiveBooks.forEach(System.out::println);

        // 2. Get a list of all unique authors who have written at least two books with a price greater than 500.00
        List<String> uniqueAuthors = books.stream()
                .filter(book -> book.getPrice() > 500.00)
                .flatMap(book -> book.getAuthors().stream())
                .collect(groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Map<String, Long> collect = books.stream()
                .filter(book -> book.getPrice() > 500.00)
                .flatMap(book -> book.getAuthors().stream())
                .collect(groupingBy(String::valueOf, Collectors.counting()));
        System.out.println("eeeeeeeee" + collect);

        Map<String, Long> collect1 = books.stream()
                .filter(book -> book.getPrice() > 500.00)
                .flatMap(book -> book.getAuthors().stream())
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("aaaaaa" + collect1);

        System.out.println("\nUnique authors:");
        uniqueAuthors.forEach(System.out::println);

        // 3. Calculate the total cost of all expensive books, and also include a 10% discount for books that have at least three authors
        double totalCost = books.stream()
                .filter(book -> book.getPrice() > 500.00)
                .mapToDouble(book -> book.getAuthors().size() >= 3 ? book.getPrice() * 0.9 : book.getPrice())
                .sum();

        System.out.println("\nTotal cost: " + totalCost);


    }}
