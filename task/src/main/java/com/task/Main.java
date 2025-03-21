package com.task;

import com.task.sberriski.Queue;

import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        // Создаем очередь с максимальным размером 5
        Queue queue = new Queue(5);

        // Добавляем элементы в очередь
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.remove();

        // Печатаем текущее количество элементов в очереди
        System.out.println("Текущий размер очереди: " + queue.size());

        // Пытаемся добавить еще один элемент
        queue.add(60); // Очередь полна!

        // Просматриваем первый элемент в очереди
        System.out.println("Первый элемент в очереди: " + queue.peek());

        // Удаляем элементы из очереди
        System.out.println("Удаленный элемент: " + queue.remove());
        System.out.println("Удаленный элемент: " + queue.remove());

        // Печатаем текущее количество элементов в очереди после удаления
        System.out.println("Текущий размер очереди после удаления: " + queue.size());

        // Добавляем еще один элемент
        queue.add(60);
        System.out.println("Добавлен элемент: 60");

        // Печатаем оставшиеся элементы в очереди
        while (!queue.isEmpty()) {
            System.out.println("Удаленный элемент: " + queue.remove());
        }

        // Пытаемся удалить элемент из пустой очереди
        queue.remove(); // Очередь пуста!

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
    }
}