package com.task.sberriski;

public class Queue {
    private int maxSize; // максимальный размер очереди
    private int[] queueArray; // массив для хранения элементов очереди
    private int front; // индекс первого элемента
    private int rear; // индекс последнего элемента
    private int nItems; // текущее количество элементов в очереди

    // Конструктор
    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    // Добавление элемента в очередь
    public void add(int value) {
        if (isFull()) {
            System.out.println("Очередь полна!");
            return;
        }
        // Зацикливание rear
        if (rear == maxSize - 1) {
            rear = -1; // сбрасываем rear на начало
        }
        queueArray[++rear] = value; // добавляем элемент
        nItems++; // увеличиваем количество элементов
    }

    // Удаление элемента из очереди
    public int remove() {
        if (isEmpty()) {
            System.out.println("Очередь пуста!");
            return -1; // или выбросить исключение
        }
        int temp = queueArray[front++]; // сохраняем элемент
        if (front == maxSize) {
            front = 0; // зацикливаем front
        }
        nItems--; // уменьшаем количество элементов
        return temp; // возвращаем удаленный элемент
    }

    // Проверка, пуста ли очередь
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // Проверка, полна ли очередь
    public boolean isFull() {
        return (nItems == maxSize);
    }

    // Получение количества элементов в очереди
    public int size() {
        return nItems;
    }

    // Просмотр первого элемента в очереди
    public int peek() {
        if (isEmpty()) {
            System.out.println("Очередь пуста!");
            return -1; // или выбросить исключение
        }
        return queueArray[front];
    }
}
