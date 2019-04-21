package com.elleflorio.dsp.stack;

import com.elleflorio.dsp.queue.Queue;
import com.elleflorio.dsp.exception.StackErrorOverflow;
import com.elleflorio.dsp.exception.StackErrorUnderflow;
import com.elleflorio.dsp.queue.ArrayQueue;

public class DoubleQueueStack<T> implements Stack<T> {

    private Queue<T> firstQueue;
    private Queue<T> secondQueue;

    public DoubleQueueStack(Class<T> clazz, int size) {
        this.firstQueue = new ArrayQueue<>(clazz, size);
        this.secondQueue = new ArrayQueue<>(clazz, size);
    }

    public void push(T value) throws StackErrorOverflow {
        if (isStackFull()) {
            throw new StackErrorOverflow("ArrayStack is full");
        }

        firstQueue.enqueue(value);
    }

    public boolean isStackFull() {
        return firstQueue.isQueueFull();
    }

    public T pop() throws StackErrorUnderflow {
        if (isStackEmpty()) {
            throw new StackErrorUnderflow("ArrayStack is empty");
        }

        if (secondQueue.isQueueEmpty()) {
            while (!firstQueue.isQueueEmpty()) {
                T value = firstQueue.dequeue();
                secondQueue.enqueue(value);
            }
        }

        return secondQueue.dequeue();
    }

    public boolean isStackEmpty() {
        return firstQueue.isQueueEmpty() && secondQueue.isQueueEmpty();
    }
}
