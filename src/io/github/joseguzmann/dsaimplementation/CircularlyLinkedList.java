package io.github.joseguzmann.dsaimplementation;

/**
 * @author Jose Guzman
 */

public class CircularlyLinkedList<T> {
    private class Node<T> {
        private T element;
        private Node<T> next;
        // Constructor del nodo
        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> tail;
    private int size;

    public CircularlyLinkedList() {
        size = 0;
    }

    public Node<T> getHead() {
        return tail.getNext();
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst() {
        if(isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();
    }

    public T getLast() {
        if(isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(T element) {
        Node<T> newNode = new Node(element, null);
        if(isEmpty()) {
            tail = newNode;
            tail.setNext(tail);
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    public void addLast(T element) {
        addFirst(element);
        tail = tail.getNext();
    }

    public void removeFirst() {
        if(isEmpty()) {
            return;
        } else if(tail == tail.getNext()) {
            tail = null;
        } else {
            tail.setNext(tail.getNext().getNext());
        }
        size--;
    }

    @Override
    public String toString() {
        String string = "";
        if(tail != null) {
            Node nodoActual = tail;
            do {
                nodoActual = nodoActual.getNext();
                string += nodoActual.getElement() + " ";
            } while(nodoActual != tail);
        }
        return string;
    }
}

/*
Class CircularlyLinkedList<E>
	Class Node
		E Element
		Nodo next
		constructor(T element, Node next)
		getElement()
		getNext()
		setNext()
	Node tail
	int size
	constructor()
	*getHead()
	*getTail()
	getSize()
	isEmpty()
	getFirst()
	getLast()
	addFirst()
	addLast()
	removeFirst()
	*toString()
*/
