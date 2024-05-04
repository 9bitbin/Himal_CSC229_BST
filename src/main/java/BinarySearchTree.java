/**
 * Name: Himal Shrestha
 * Course: CSC 229 Data Structures and Algorithms
 * Extra Credit BST
 * Professor: Dr. Moaath Alrajab
 *
 * This class represents a Binary Search Tree (BST). It includes methods to:
 * - Check if the tree is empty
 * - Insert elements into the tree
 * - Perform in-order and pre-order traversals
 * - Find the height of the tree
 * - Get the depth of a specific node
 * - Print the tree structure
 **/


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root; // Declare a private member variable 'root' of type 'BstNode'

    // Method to check if the tree is empty
    public boolean isEmpty() {
        return (this.root == null); // Return true if 'root' is null, indicating an empty tree
    }

    // Method to insert a new element into the tree
    public void insert(Integer data) {
        System.out.print("[input: " + data + "]"); // Print input data
        if (root == null) { // If the tree is empty
            this.root = new BstNode(data); // Create a new node with the input data and set it as the root
            System.out.println(" -> inserted: " + data); // Print a message indicating successful insertion
            return;
        }
        insertNode(this.root, data); // If the tree is not empty, call the recursive insertNode method
        System.out.print(" -> inserted: " + data); // Print a message indicating successful insertion
        System.out.println();
    }

    // Recursive method to insert a new node into the tree
    private BstNode insertNode(BstNode root, Integer data) {
        BstNode tmpNode = null; // Temporary node variable
        System.out.print(" ->" + root.getData()); // Print the current node's data
        if (root.getData() >= data) { // If the input data is less than or equal to the current node's data
            System.out.print(" [L]"); // Print a message indicating insertion on the left side
            if (root.getLeft() == null) { // If the left child of the current node is null
                root.setLeft(new BstNode(data)); // Create a new node with the input data and set it as the left child
                return root.getLeft(); // Return the newly inserted node
            } else {
                tmpNode = root.getLeft(); // Otherwise, set the temporary node as the left child
            }
        } else { // If the input data is greater than the current node's data
            System.out.print(" [R]"); // Print a message indicating insertion on the right side
            if (root.getRight() == null) { // If the right child of the current node is null
                root.setRight(new BstNode(data)); // Create a new node with the input data and set it as the right child
                return root.getRight(); // Return the newly inserted node
            } else {
                tmpNode = root.getRight(); // Otherwise, set the temporary node as the right child
            }
        }
        return insertNode(tmpNode, data); // Recursively call insertNode on the appropriate child node
    }

    // Method to perform in-order traversal of the tree
    public void inOrderTraversal() {
        doInOrder(this.root); // Call the recursive doInOrder method starting from the root
    }

    // Recursive method to perform in-order traversal
    private void doInOrder(BstNode root) {
        if (root != null) { // If the current node is not null
            doInOrder(root.getLeft()); // Traverse the left subtree
            System.out.print(root.getData() + " "); // Print the data of the current node
            doInOrder(root.getRight()); // Traverse the right subtree
        }
    }

    // Method to perform pre-order traversal of the tree
    public void preOrderTraversal() {
        doPreOrder(this.root); // Call the recursive doPreOrder method starting from the root
    }

    // Recursive method to perform pre-order traversal
    private void doPreOrder(BstNode root) {
        if (root != null) { // If the current node is not null
            System.out.print(root.getData() + " "); // Print the data of the current node
            doPreOrder(root.getLeft()); // Traverse the left subtree
            doPreOrder(root.getRight()); // Traverse the right subtree
        }
    }

    // Method to find the height of the tree
    public int findHeight() {
        return calculateHeight(this.root); // Call the recursive calculateHeight method starting from the root
    }

    // Recursive method to calculate the height of the tree
    private int calculateHeight(BstNode node) {
        if (node == null) { // If the current node is null
            return -1; // Return -1 (base case for height calculation)
        }
        int leftHeight = calculateHeight(node.getLeft()); // Recursively calculate the height of the left subtree
        int rightHeight = calculateHeight(node.getRight()); // Recursively calculate the height of the right subtree
        return Math.max(leftHeight, rightHeight) + 1; // Return the maximum height of the left and right subtrees plus 1
    }

    // Method to get the depth of a specific node in the tree
    public int getDepth(BstNode node) {
        return calculateDepth(this.root, node, 0); // Call the recursive calculateDepth method starting from the root
    }

    // Recursive method to calculate the depth of a specific node
    private int calculateDepth(BstNode root, BstNode node, int depth) {
        if (root == null) { // If the current node is null
            return -1; // Return -1 (indicating node not found)
        }
        if (root == node) { // If the current node is the target node
            return depth; // Return the current depth
        }
        int leftDepth = calculateDepth(root.getLeft(), node, depth + 1); // Recursively search the left subtree
        if (leftDepth != -1) { // If the node is found in the left subtree
            return leftDepth; // Return the depth
        }
        return calculateDepth(root.getRight(), node, depth + 1); // Recursively search the right subtree
    }

    // Method to print the tree structure
    public void print() {
        System.out.println("\n==== BST Print ===== \n"); // Print a header for tree printing
        print("", root, false); // Call the recursive print method starting from the root
    }

    // Recursive method to print the tree with proper indentation
    private void print(String prefix, BstNode node, boolean isLeft) {
        if (node != null) { // If the current node is not null
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.getData()); // Print the node data with proper indentation
            print(prefix + (isLeft ? "|   " : "    "), node.getLeft(), true); // Recursively print the left subtree
            print(prefix + (isLeft ? "|   " : "    "), node.getRight(), false); // Recursively
        }
    }

}