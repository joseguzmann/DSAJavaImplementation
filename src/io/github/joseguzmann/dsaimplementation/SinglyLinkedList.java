package io.github.joseguzmann.dsaimplementation;

/**
 * @author Jose Guzman
 */

public class SinglyLinkedList <T> implements Cloneable {
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

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor de la lista enlazada
    public SinglyLinkedList() {
        size = 0;
    }

    public Node<T> getHead() {
        return head;
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
        return head.getElement();
    }

    public T getLast() {
        if(isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(T element) {
        head = new Node(element, head);
        if(isEmpty()) {
            head.setNext(null);
            tail = head;
        }
        size++;
    }

    public void addLast(T element) {
        Node<T> nuevo = new Node(element, null);
        if(isEmpty()) {
            head = nuevo;
        } else {
            tail.setNext(nuevo);
        }
        tail = nuevo;
        size++;
    }

    public void removeFirst() {
        if(isEmpty()) {
            return;
        } else if(head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
        }
        size--;
    }

    @Override
    public String toString() {
        Node<T> current = head;
        String string = "";
        while(current != null) {
            string += current.getElement() + "  ";
            current = current.getNext();
        }
        return string;
    }

    public SinglyLinkedList<T> clone() throws CloneNotSupportedException {
        SinglyLinkedList<T> newList = (SinglyLinkedList<T>) super.clone();
        if(size > 0) {
            Node<T> newHead = new Node(head.getElement(), null);
            Node<T> newTail = new Node(tail.getElement(), null);
            newList.head = newHead;
            newList.tail = newTail;
            Node<T> currentNew = newList.head;
            Node<T> currentOld = head.getNext();
            do{
                currentNew.setNext(new Node<T>(currentOld.getElement(), null));
                currentNew = currentNew.getNext();
                currentOld = currentOld.getNext();
            } while(currentOld != tail);
            currentNew.setNext(newList.tail);
        }
        return newList;
    }
}

/*Class SinglyLinkedList<E>
	Class Node
		E Element
		Nodo next
		constructor(T element, Node next)
		getElement()
		getNext()
		setNext()
	Node head
	Node tail
	int size
	constructor()
	getHead()
	getTail()
	getSize()
	isEmpty()
	getFirst()
	getLast()
	addFirst()
	addLast()
	removeFirst()
	toString()*/

