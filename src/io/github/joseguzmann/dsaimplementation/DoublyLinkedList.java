package io.github.joseguzmann.dsaimplementation;

/**
 * @author Jose Guzman
 */

public class DoublyLinkedList<T> implements Cloneable {
    public class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(T element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> header;
    private Node<T> trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.setNext(trailer);
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
        return header.getNext().getElement();
    }

    public T getLast() {
        if(isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }

    public void addFirst(T element) {
        addBetween(element, header, header.getNext());

//        Node<T> oldFirst = header.getNext();
//        Node<T> newFirst = new Node(element, header, oldFirst);
//        header.setNext(newFirst);
//        oldFirst.setPrev(newFirst);
//        size++;

    }

    public void addLast(T element) {
        addBetween(element, trailer.getPrev(), trailer);

//        Node<T> oldLast = trailer.getPrev();
//        Node<T> newLast = new Node(element, oldLast, trailer);
//        trailer.setPrev(newLast);
//        oldLast.setNext(newLast);
//        size++;
    }

    public void removeFirst() {
        if(size > 0) {
            remove(header.getNext());

//            Node<T> newFirst = header.getNext().getNext();
//            header.setNext(newFirst);
//            newFirst.setPrev(header);
        }
    }

    public void removeLast() {
        if(size > 0) {
            remove(trailer.getPrev());

//            Node<T> newLast = trailer.getPrev().getPrev();
//            newLast.setNext(trailer);
//            trailer.setPrev(newLast);
        }
    }

    // New methods

    public void addBetween(T element, Node<T> prev, Node<T> next) {
        Node<T> newNode = new Node(element, prev, next);
        prev.setNext(newNode);
        next.setPrev(newNode);
        size++;
    }

    public void remove(Node<T> node) {
        Node<T> next = node.getNext();
        Node<T> prev = node.getPrev();
        prev.setNext(next);
        next.setPrev(prev);
        node = null;
        size--;
    }

    public void printFromHeader() {
        Node<T> currentNode = header;
        do {
            currentNode = currentNode.getNext();
            System.out.print(currentNode.getElement() + " ");
        } while(currentNode.getNext() != trailer);
        System.out.print("\n");
    }

    public void printFromTrailer() {
        Node<T> currentNode = trailer;
        do {
            currentNode = currentNode.getPrev();
            System.out.print(currentNode.getElement() + " ");
        } while(currentNode.getPrev() != header);
        System.out.print("\n");
    }

    public DoublyLinkedList<T> clone() throws CloneNotSupportedException {
        DoublyLinkedList<T> newList = (DoublyLinkedList<T>) super.clone();
        newList.header = new Node(null, null, null);
        newList.trailer = new Node(null, header, null);
        newList.header.next = newList.trailer;
        Node<T> newCurrentNode = newList.header;
        Node<T> oldCurrentNode = header.next;
        if(size > 0) {
            do {
                newCurrentNode.setNext(new Node(oldCurrentNode.getElement(), newCurrentNode, null));
                newCurrentNode = newCurrentNode.next;
                oldCurrentNode = oldCurrentNode.next;
            } while(oldCurrentNode != trailer);
            newCurrentNode.setNext(newList.trailer);
            newList.trailer.setPrev(newCurrentNode);
        }
        return newList;
    }
}


/*
    Class CircularlyLinkedList<E>
	Class Node
		E Element
		Node prev
		Node next
		constructor(T element, Node prev, Node next)
		getElement()
		getPrev()
		getNext()
		setPrev()
		setNext()
	Node header;
	Node trailer;
	int size;

	constructor()

	getSize()
	isEmpty()
	getFirst()
	getLast()
	addFirst()
	addLast()
	removeFirst()
	removeLast()

	// Between methods
	addBetween()
	remove()

	*toString()

*/
