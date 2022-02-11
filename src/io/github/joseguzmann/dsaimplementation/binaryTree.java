package io.github.joseguzmann.dsaimplementation;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author Jose Guzman
 */

public class binaryTree {
    class Node {
        int value;
        Node right;
        Node left;

        public Node(int v) {
            value = v;
            right = null;
            left = null;
        }
    }

    Node root;

    private Node addRecursive(Node current, int value) {
        if(current == null) {
            return new Node(value);
        }

        if(value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if(value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public boolean containsNodeRecursive(Node current, int value) {
        if(current == null) {
            return false;
        } else if(value == current.value == true) {
            return true;
        } else {
            return value < current.value ? containsNodeRecursive(current.left, value) : containsNodeRecursive(current.right, value);
        }
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    public Node deleteRecursive(Node current, int value) {
        if(current == null) {
            return null;
        } else if(value == current.value) {
            //node has no children
            if(current.left == null && current.right == null) {
                return null;
            }
            //node has exactly one child
            if(current.left == null) {
                return current.right;
            } else if(current.right == null) {
                return current.left;
            }
            // node has two children
            int min = findSmallestValue(current.right);
            deleteRecursive(current.right, min);
            current.value = min;
        } else if(value < current.value) {
            current.left = deleteRecursive(current.left, value);
        } else if(value > current.value) {
            current.right = deleteRecursive(current.right, value);
        }
        return current;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public static int findSmallestValue(Node tree) {
        return tree.left == null ? tree.value : findSmallestValue(tree.left);
    }

    public void traverseInOrder(Node node) {
        if(node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if(node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if(node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public void traverseLevelOrder(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if(node.left != null) {
                nodes.add(node.left);
            }

            if(node.right != null) {
                nodes.add(node.right);
            }
        }
    }
}
