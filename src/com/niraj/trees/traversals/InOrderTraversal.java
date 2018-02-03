package com.niraj.trees.traversals;

import com.niraj.trees.utitilites.Node;
import com.niraj.trees.utitilites.NodeInsertion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {


    /**
     * The below method uses a simple algorithm to do a in order traversal of a binary tree
     * by associating the parent node and marking the visited node
     * @param node
     * @return java.util.List
     */
    public List<Integer> doInOrderTraversal(Node node) {

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

                } else if (!currentNode.isVisited()) {
                    nodeList.add(currentNode.getData());
                    currentNode.setVisited(true);
                    nodeStack.push(currentNode);

                } else if (currentNode.getRightNode() != null && !currentNode.getRightNode().isVisited()) {

                    Node rightNode = currentNode.getRightNode();
                    rightNode.setParentNode(currentNode);
                    nodeStack.push(rightNode);

                } else {
                    nodeStack.push(currentNode.getParentNode());
                }
            }
        }

        return nodeList;
    }

    /**
     * Non recursive way of doing InOrderTraversal without using associating with any
     * parent nodes or flags
     * @param node
     * @return java.util.List
     */

    public List<Integer> inOrderTraverse(Node node) {

        List<Integer> nodeList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node previousNode = null;

        if (node != null) {

            nodeStack.push(node);
            while (!nodeStack.isEmpty()) {

                Node currentNode = nodeStack.peek();

                if (previousNode == null || previousNode.getLeftNode() == currentNode
                        || previousNode.getRightNode() == currentNode) {

                    if (currentNode.getLeftNode() != null) {
                        nodeStack.push(currentNode.getLeftNode());

                    } else {
                        nodeList.add(currentNode.getData());
                        if (currentNode.getRightNode() != null) {
                            nodeStack.push(currentNode.getRightNode());
                        } else {
                            nodeStack.pop();
                        }
                    }

                } else if (currentNode.getLeftNode() == previousNode) {
                    nodeList.add(currentNode.getData());
                    if (currentNode.getRightNode() != null) {
                        nodeStack.push(currentNode.getRightNode());
                    } else {
                        nodeStack.pop();
                    }

                } else {
                    nodeStack.pop();
                }

                previousNode = currentNode;
            }
        }

        return nodeList;
    }
}
