package com.interview.concurrency;

import java.util.HashMap;
import java.util.Map;

public class UserCache {
    private final Map<Integer, String> cache = new HashMap<>();

    public synchronized void addUser(int id, String name) {
        cache.put(id, name);
    }

    public synchronized String getUser(int id) {
        return cache.get(id);
    }

    // Потоконебезопасный метод!
    public synchronized void updateUserRace(int id, String newName) {
        String current = cache.get(id);  // (1) Чтение
        // Искусственная пауза для демонстрации гонки
        try { Thread.sleep(10); } catch (InterruptedException ignored) {}
        if (current != null) {
            cache.put(id, newName);      // (2) Запись
        }
    }



    public static void main(String[] args) throws InterruptedException {
        UserCache cache = new UserCache();
        cache.addUser(1, "Alice");

        Thread t1 = new Thread(() -> cache.updateUserRace(1, "John"));
        Thread t2 = new Thread(() -> cache.addUser(1, "Charlie"));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Результат: " + cache.getUser(1));
        // Всегда будет "Charlie", а не "John"!
    }

}
