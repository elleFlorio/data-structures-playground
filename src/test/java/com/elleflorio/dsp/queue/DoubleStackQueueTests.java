package com.elleflorio.dsp.queue;

import com.elleflorio.dsp.exception.QueueErrorOverflow;
import com.elleflorio.dsp.exception.QueueErrorUnderflow;
import com.elleflorio.dsp.queue.DoubleStackQueue;
import com.elleflorio.dsp.queue.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoubleStackQueueTests {

    @Test
    void enqueueDequeueTest() throws QueueErrorUnderflow, QueueErrorOverflow {
        Queue<Integer> queue = new DoubleStackQueue<>(Integer.class, 3);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        int first = queue.dequeue();
        int second = queue.dequeue();
        int third = queue.dequeue();

        assertEquals(1, first);
        assertEquals(2, second);
        assertEquals(3, third);

        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        int fourth = queue.dequeue();
        int fifth = queue.dequeue();
        int sixth = queue.dequeue();

        assertEquals(4, fourth);
        assertEquals(5, fifth);
        assertEquals(6, sixth);
    }

    @Test
    void errorUnderflowTest() {
        Queue<Integer> queue = new DoubleStackQueue<>(Integer.class, 3);
        assertThrows(QueueErrorUnderflow.class, queue::dequeue);
    }

    @Test
    void errorOverflowTest() throws QueueErrorOverflow {
        Queue<Integer> queue = new DoubleStackQueue<>(Integer.class, 1);
        queue.enqueue(1);
        assertThrows(QueueErrorOverflow.class, () -> queue.enqueue(2));
    }

    @Test
    void infiniteQueueTest() throws QueueErrorUnderflow, QueueErrorOverflow {
        Queue<Integer> queue = new DoubleStackQueue<>(Integer.class, 1);
        for(int i = 0; i < Integer.MAX_VALUE; i++ ) {
            queue.enqueue(i);
            queue.dequeue();
        }
        queue.enqueue(1);
        assertEquals(1, queue.dequeue());
        queue.enqueue(2);
        assertEquals(2, queue.dequeue());
        queue.enqueue(3);
        assertEquals(3, queue.dequeue());
    }
}
