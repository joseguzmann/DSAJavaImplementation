package io.github.joseguzmann.dsaimplementation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jose Guzman
 */

public class BinarySearchTree<T extends Comparable> {
    public class Node<T> {
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }
    }

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public BinarySearchTree() {
        root = null;
    }

    private Node<T> insert(T data, Node<T> node) {
        if(node == null) {
            return new Node<>(data);
        }
        if(data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(data, node.getLeftChild()));
        } else if(data.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(data, node.getRightChild()));
        }
        return node;
    }

    public BinarySearchTree<T> insert(T data) {
        root = insert(data, root);
        return this;
    }

    private Node<T> delete(T data, Node<T> node) {
        if(node == null) {
            return null;
        }
        if(data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(data, node.getLeftChild()));
        } else if(data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(data, node.getRightChild()));
        } else {
            if(node.getLeftChild() == null) {
                return node.getRightChild();
            } else if(node.getRightChild() == null) {
                return node.getLeftChild();
            }
            // Two Children
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
        }
        return node;
    }

    public void delete(T data) {
        root = delete(data, root);
    }

    void traverseInOrder(Node<T> node) {
        if(node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.print(" " + node.getData());
            traverseInOrder(node.getRightChild());
        }
    }

    void traversePreOrder(Node<T> node) {
        if(node != null) {
            System.out.println(" " + node.getData());
            traversePreOrder(node.getLeftChild());
            traversePreOrder(node.getRightChild());
        }
    }

    void traversePostOrder(Node<T> node) {
        if(node != null) {
            traversePostOrder(node.getLeftChild());
            traversePostOrder(node.getRightChild());
            System.out.println(" " + node.getData());
        }
    }

    void traverseLevelOrder(Node<T> node) {
        if(node == null) {
            return;
        }

        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.add(node);

        while(!nodes.isEmpty()) {
            Node<T> nodeTemp = nodes.remove();

            System.out.print(" " + nodeTemp.getData());

            if(nodeTemp.getLeftChild() != null) {
                nodes.add(node.getLeftChild());
            }

            if(nodeTemp.getRightChild() != null) {
                nodes.add(node.getRightChild());
            }
        }
    }

    public T getMax(Node<T> node) {
        if(node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    public T getMax() {
        if(isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    public T getMin(Node<T> node) {
        if(node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }

    public T getMin() {
        if(isEmpty()) {
            return null;
        }
        return getMin(root);
    }

    boolean isEmpty() {
        return root == null;
    }

}
