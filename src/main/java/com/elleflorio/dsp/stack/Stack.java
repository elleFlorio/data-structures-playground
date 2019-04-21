package com.elleflorio.dsp.stack;

public interface Stack<T> {

    void push(T value);

    boolean isStackFull();

    T pop();

    boolean isStackEmpty();
}
