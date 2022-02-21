package io.github.joseguzmann.dsaimplementation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jose Guzman
 */

public class AVLTree<T extends Comparable<T>> {
    public class Node<T> {
        private T data;
        private int height = 1;
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

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
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

    // AVL Implementation

    private Node<T> root;

    private Node<T> insert(T data, Node<T> node) {
        if(null == node) {
            return new Node<>(data);
        }
        if(data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(data, node.getLeftChild()));
        } else if(data.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(data, node.getRightChild()));
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    public AVLTree<T> insert(T data) {
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
        updateHeight(node);
        return applyRotation(node);
    }

    public void delete(T data) {
        root = delete(data, root);
    }

    private Node<T> applyRotation(Node<T> node) {
        int balance = balance(node);
        if(balance > 1) {
            if(balance(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        } else if(balance < -1) {
            if(balance(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.getLeftChild();
        Node<T> centerNode = leftNode.getRightChild();
        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightNode = node.getRightChild();
        Node<T> centerNode = rightNode.getLeftChild();
        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private int balance(Node<T> node) {
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    private void updateHeight(Node<T> node) {
        int maxHeight = Math.max(
                height(node.getLeftChild()),
                height(node.getRightChild())
        );
        node.setHeight(maxHeight + 1);
    }

    private int height(Node<T> node) {
        return node != null ? node.getHeight() : 0;
    }

    // Same as BST

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
