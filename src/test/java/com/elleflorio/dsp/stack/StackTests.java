package com.elleflorio.dsp.stack;

import com.elleflorio.dsp.exception.StackErrorOverflow;
import com.elleflorio.dsp.exception.StackErrorUnderflow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTests {

    @Test
    void pushPopTest() throws StackErrorOverflow, StackErrorUnderflow {
        Stack<Integer> stack = new ArrayStack<>(Integer.class, 10);
        stack.push(1);
        int value = stack.pop();
        assertEquals(1, value);
    }

    @Test
    void underflowErrorTest() {
        Stack<Integer> stack = new ArrayStack<>(Integer.class,10);
        assertThrows(StackErrorUnderflow.class, stack::pop);
    }

    @Test
    void overflowErrorTest() throws StackErrorOverflow {
        Stack<Integer> stack = new ArrayStack<>(Integer.class,1);
        stack.push(1);
        assertThrows(StackErrorOverflow.class, () -> stack.push(2));
    }
}
