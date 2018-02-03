package com.niraj.trees.traversals;

import com.niraj.trees.utitilites.Node;
import com.niraj.trees.utitilites.NodeInsertion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {


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

                } else if (currentNode.getRightNode() != null) {
                    if (currentNode.getRightNode() == previousNode) {
                        nodeStack.pop();

                    } else {
                        nodeStack.push(currentNode.getRightNode());
                    }

                } else {
                    nodeList.add(currentNode.getData());
                    nodeStack.pop();
                }

                previousNode = currentNode;
            }
        }

        return nodeList;
    }

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

                } else if (currentNode.getRightNode() != null) {
                    if (currentNode.getRightNode() == previousNode) {
                        nodeStack.pop();

                    } else {
                        nodeStack.push(currentNode.getRightNode());
                    }

                } else {
                    nodeList.add(currentNode.getData());
                    nodeStack.pop();
                }

                previousNode = currentNode;
            }
        }

        return nodeList;
    }

    public static void main(String[] args) {

        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        NodeInsertion nInsert = new NodeInsertion();
        Node rootNode = nInsert.nodeGenerator();
        List<Integer> nodeList = inOrderTraversal.doInOrderTraversal(rootNode);

        for (Integer node : nodeList) {
            System.out.print(node+" ");
        }
    }
}
