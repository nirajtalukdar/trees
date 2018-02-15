package com.niraj.trees.utitilites;

public class AVLInsertion {


    private Node insertNode (Node node, int data) {

        if (node == null) {
            node = new Node();
            node.setData(data);

        } else if (data < node.getData()) {
            node.setLeftNode(insertNode(node.getLeftNode(), data));

        } else if (data > node.getData()) {
            node.setRightNode(insertNode(node.getRightNode(), data));
        }
        node.setHeight(setNodeHeight(node));

        return node;
    }

    private int setNodeHeight(Node currentNode) {

        if (currentNode == null) {
            return -1;
        }

        int leftNodeHeight = setNodeHeight(currentNode.getLeftNode());
        int rightNodeHeight = setNodeHeight(currentNode.getRightNode());

        int height = Math.max(leftNodeHeight, rightNodeHeight) + 1;
        currentNode.setHeight(height);
        return height;
    }

    public static void main(String[] args) {

        AVLInsertion avlInsert = new AVLInsertion();

        Node node = avlInsert.insertNode(null, 10);
        node = avlInsert.insertNode(node, 20);
        node = avlInsert.insertNode(node, 12);
        node = avlInsert.insertNode(node, 17);
        node = avlInsert.insertNode(node, 8);
        node = avlInsert.insertNode(node, 25);
        node = avlInsert.insertNode(node, 4);
        node = avlInsert.insertNode(node, 9);
        node = avlInsert.insertNode(node, 5);
        node = avlInsert.insertNode(node, 6);
        node = avlInsert.insertNode(node, 7);

        System.out.println("Tree created");
    }


}
