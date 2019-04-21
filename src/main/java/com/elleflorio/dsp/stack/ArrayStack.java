package com.elleflorio.dsp.stack;

import com.elleflorio.dsp.exception.StackErrorOverflow;
import com.elleflorio.dsp.exception.StackErrorUnderflow;

import java.lang.reflect.Array;

public class ArrayStack<T> implements Stack<T> {

    private int top = 0;
    private T[] values;

    public ArrayStack(Class<T> clazz, int size) {
        this.values = (T[])Array.newInstance(clazz, size);
    }

    public void push(T value) {
        if (isStackFull()) {
            throw new StackErrorOverflow("Error: ArrayStack is full");
        }

        values[top] = value;
        top++;
    }

    public boolean isStackFull() {
        return top == values.length;
    }

    public T pop() {
        if (isStackEmpty()) {
            throw new StackErrorUnderflow("Error: ArrayStack is empty");
        }

        top--;
        return values[top];
    }

    public boolean isStackEmpty() {
        return top == 0;
    }
}

