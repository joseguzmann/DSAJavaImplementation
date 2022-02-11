package io.github.joseguzmann.dsaimplementation;

/**
 * @author Jose Guzman
 */

public class Main {
    public static void main(String[] args) {
        CircularlyLinkedList<Integer> lista = new CircularlyLinkedList<Integer>();
        lista.addFirst(1);
        lista.addLast(9);
        System.out.println(lista.toString());
    }
}
