package io.github.joseguzmann.dsaimplementation;

/**
 * @author Jose Guzman
 */

public class Queue<T> {
    T[] array;
    private int max;
    private int front;
    private int rear;

    public Queue(int n) {
        array = (T[]) new Object[n];
        max = n;
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % max == front;
    }

    public void enqueue(T t) {
        if(isFull()) {
            return;
        } else if(isEmpty()) {
            front = 0;
            rear = 0;
            array[rear] = t;
        } else {
            rear = (rear + 1) % max;
            array[rear] = t;
        }
    }

    public void dequeue() {
        if(isEmpty()) {
            return;
        } else if(rear == front) {
            array[front] = null;
            rear = -1;
            front = -1;
        } else {
            array[front] = null;
            front = (front + 1) % max;
        }
    }

    public T see() {
        if(!isEmpty()) {
            return array[front];
        }
        return null;
    }
}

/*QUEUE PARA LA CLASE OBJECT
public class Queue {
    private Object[] array;
    private int max;
    private int front;
    private int rear;

    public Queue(int n) {
        array = new Object[n];
        max = n;
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % max == front;
    }

    public void enqueue(Object o) {
        if(isFull()) {
            return;
        } else if(isEmpty()) {
            front = 0;
            rear = 0;
            array[rear] = o;
        } else {
            rear = (rear + 1) % max;
            array[rear] = o;
        }
    }

    public void dequeue() {
        if(isEmpty()) {
            return;
        } else if(rear == front) {
            array[front] = null;
            rear = -1;
            front = -1;
        } else {
            array[front] = null;
            front = (front + 1) % max;
        }
    }

    public Object see() {
        if(!isEmpty()) {
            return array[front];
        }
        return null;
    }
}

*/
