package com.niraj.trees.utitilites;

import java.util.Stack;

public class NodeDeletion {

    public Node deleteNode(Node node, int data) {

        Stack<Node> nodeStack = new Stack<>();

        if (node != null) {

           nodeStack.push(node);
           while (nodeStack.peek() != null) {

               Node currentNode = nodeStack.pop();
               if (data < currentNode.getData()) {
                   Node leftNode = currentNode.getLeftNode();
                   leftNode.setParentNode(currentNode);
                   nodeStack.push(leftNode);

               } else if (data > currentNode.getData()) {
                   Node rightNode = currentNode.getRightNode();
                   rightNode.setParentNode(currentNode);
                   nodeStack.push(rightNode);

               } else {

                   if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
                       currentNode = null;

                   } else if (currentNode.getLeftNode() != null && currentNode.getRightNode() == null) {
                       Node leftNode = currentNode.getLeftNode();
                       Node parentNode = currentNode.getParentNode();
                       parentNode.setLeftNode(leftNode);
                       leftNode.setParentNode(parentNode);

                   } else if (currentNode.getRightNode() != null && currentNode.getLeftNode() == null) {
                       Node rightNode = currentNode.getRightNode();
                       Node parentNode = currentNode.getParentNode();
                       parentNode.setRightNode(rightNode);
                       rightNode.setParentNode(currentNode.getParentNode());

                   } else {
                       Node minRightNode = findMin(currentNode.getRightNode());


                   }

               }
           }

        }

        return node;
    }

    private static Node findMin(Node node) {

        while (node.getLeftNode() != null) {
            node = node.getLeftNode();
        }
        return node;
    }
}
