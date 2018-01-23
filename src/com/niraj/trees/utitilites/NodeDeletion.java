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
                }
            }

        }

        return node;
    }
}
