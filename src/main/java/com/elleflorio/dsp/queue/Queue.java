package com.elleflorio.dsp.queue;

public interface Queue<T> {

    void enqueue(T value);

    boolean isQueueFull();

    T dequeue();

    boolean isQueueEmpty();
}
