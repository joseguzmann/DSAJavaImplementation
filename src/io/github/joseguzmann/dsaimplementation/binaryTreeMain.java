package io.github.joseguzmann.dsaimplementation;

/**
 * @author Jose Guzman
 */

public class binaryTreeMain {
    public static void main(String[] args) {
        binaryTree bt = new binaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.traverseInOrder(bt.root);
        System.out.println("\n");
        bt.traversePreOrder(bt.root);
        System.out.println("\n");
        bt.traversePostOrder(bt.root);
        System.out.println("\n");
        bt.traverseLevelOrder(bt.root);
        System.out.println("\n");
    }
}
