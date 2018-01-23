package com.niraj.trees.traversals;

import com.niraj.trees.utitilites.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public List<Integer> doPostOrderTraversal(Node node) {

        List<Integer> nodeList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();

        if (node != null) {

            nodeStack.push(node);
            while (nodeStack.peek() != null) {

                Node currentNode = nodeStack.pop();

                if (currentNode.getLeftNode() != null && !currentNode.getLeftNode().isVisited()) {
                    Node leftNode = currentNode.getLeftNode();
                    leftNode.setParentNode(currentNode);
                    nodeStack.push(leftNode);

                } else if (currentNode.getRightNode() != null && !currentNode.getRightNode().isVisited()) {
                    Node rightNode = currentNode.getRightNode();
                    rightNode.setParentNode(currentNode);
                    nodeStack.push(rightNode);

                } else {
                    nodeList.add(currentNode.getData());
                    currentNode.setVisited(true);
                    nodeStack.push(currentNode.getParentNode());
                }
            }
        }

        return nodeList;
    }
}
