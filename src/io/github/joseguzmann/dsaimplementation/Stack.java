package io.github.joseguzmann.dsaimplementation;

/**
 * @author Jose Guzman
 */

public class Stack<T> {
    private T[] array;
    private int top;
    private int max;

    public Stack(int n) {
        array = (T[]) new Object[n];
        max = n;
        top = -1;
    }

    public boolean isFull() {
        return top == max - 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(T t) {
        if(!isFull()) {
            top++;
            array[top] = t;
        }
    }

    public void pop() {
        if(!isEmpty()) {
            array[top] = null;
            top--;
        }
    }

    public T see() {
        if(!isEmpty()) {
            return array[top];
        }
        return null;
    }
}

/*
STACK PARA CLASE OBJECT
    private Object[] array;
    private int top;
    private int max;

    public Stack(int n) {
        array = new Object[n];
        max = n;
        top = -1;
    }

    public boolean isFull() {
        return top == max - 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(Object o) {
        if(!isFull()) {
            top++;
            array[top] = o;
        }
        return;
    }

    public void pop(Object o) {
        if(!isEmpty()) {
            array[top] = null;
            top--;
        }
    }

    public Object see() {
        if(!isEmpty()) {
            return array[top];
        }
        return null;
    }
*/

