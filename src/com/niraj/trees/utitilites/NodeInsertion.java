package com.niraj.trees.utitilites;

import java.util.Random;

public class NodeInsertion {

    public Node insertNode(Node node, int data) {

        if (node != null) {

            if (data <= node.getData()) {
                Node leftNode = node.getLeftNode();
                leftNode = insertNode(leftNode, data);
                node.setLeftNode(leftNode);
            } else {
                Node rightNode = node.getRightNode();
                rightNode = insertNode(rightNode, data);
                node.setRightNode(rightNode);
            }

        } else {

            node = new Node();
            node.setData(data);
        }

        return node;
    }

    public Node nodeGenerator() {

        NodeInsertion bst = new NodeInsertion();

        Node node = bst.insertNode(null, 10);
        node = bst.insertNode(node, 20);
        node = bst.insertNode(node, 12);
        node = bst.insertNode(node, 17);
        node = bst.insertNode(node, 8);
        node = bst.insertNode(node, 25);
        node = bst.insertNode(node, 4);
        node = bst.insertNode(node, 9);
        node = bst.insertNode(node, 5);
        node = bst.insertNode(node, 6);
        node = bst.insertNode(node, 7);


        return node;
    }
}