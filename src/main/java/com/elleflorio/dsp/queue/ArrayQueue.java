package com.elleflorio.dsp.queue;

import com.elleflorio.dsp.exception.QueueErrorOverflow;
import com.elleflorio.dsp.exception.QueueErrorUnderflow;

import java.lang.reflect.Array;

public class ArrayQueue<T> implements Queue<T> {

    private int head = 0;
    private int tail = 0;
    private final int size;
    private T[] values;

    public ArrayQueue(Class<T> clazz, int size) {

        this.size = size;
        this.values = (T[]) Array.newInstance(clazz, size);
    }

    public void enqueue(T value) {
        if (isQueueFull()) {
            throw new QueueErrorOverflow("ArrayQueue is full");
        }

        values[tail % size] = value;
        tail = (tail + 1) % Integer.MAX_VALUE;
    }

    public boolean isQueueFull() {
        if (size == 1) {
            return head == tail - 1;
        }
        return (head % size == tail % size) && (head != tail);
    }

    public T dequeue() {
        if (isQueueEmpty()) {
            throw new QueueErrorUnderflow("ArrayQueue is empty");
        }

        T value = values[head % size];
        head = (head + 1) % Integer.MAX_VALUE;

        return value;
    }

    public boolean isQueueEmpty() {
        return head == tail;
    }
}
