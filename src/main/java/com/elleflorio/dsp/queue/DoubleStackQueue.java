package com.elleflorio.dsp.queue;

import com.elleflorio.dsp.stack.ArrayStack;
import com.elleflorio.dsp.stack.Stack;
import com.elleflorio.dsp.exception.QueueErrorOverflow;
import com.elleflorio.dsp.exception.QueueErrorUnderflow;

public class DoubleStackQueue<T> implements Queue<T> {

    private Stack<T> firstStack;
    private Stack<T> secondStack;

    public DoubleStackQueue(Class<T> clazz, int size) {
        this.firstStack = new ArrayStack<>(clazz, size);
        this.secondStack = new ArrayStack<>(clazz, size);
    }

    public void enqueue(T value) {
        if (isQueueFull()) {
            throw new QueueErrorOverflow("ArrayQueue is full");
        }

        firstStack.push(value);
    }

    public boolean isQueueFull() {
        return firstStack.isStackFull();
    }

    public T dequeue() {
        if (isQueueEmpty()) {
            throw new QueueErrorUnderflow("ArrayQueue is empty");
        }

        if (secondStack.isStackEmpty()) {
            while (!firstStack.isStackEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }

        return secondStack.pop();
    }

    public boolean isQueueEmpty() {
        return firstStack.isStackEmpty() && secondStack.isStackEmpty();
    }

}
