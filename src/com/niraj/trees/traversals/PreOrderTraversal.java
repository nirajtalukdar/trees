package com.niraj.trees.traversals;

import com.niraj.trees.utitilites.Node;
import com.niraj.trees.utitilites.NodeInsertion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    public List<Integer> doPreOrderTraversal(Node node) {

        List<Integer> nodeList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();

        if (node != null) {

            nodeStack.push(node);
            while (nodeStack.peek() != null) {

                Node currentNode = nodeStack.pop();
                if (!currentNode.isVisited()) {
                    nodeList.add(currentNode.getData());
                    currentNode.setVisited(true);
                }
                if (currentNode.getLeftNode() != null && !currentNode.getLeftNode().isVisited()) {
                    Node leftNode = currentNode.getLeftNode();
                    nodeList.add(leftNode.getData());
                    leftNode.setParentNode(currentNode);
                    leftNode.setVisited(true);
                    nodeStack.push(leftNode);

                } else if (currentNode.getRightNode() != null && !currentNode.getRightNode().isVisited()) {
                    Node rightNode = currentNode.getRightNode();
                    nodeList.add(rightNode.getData());
                    rightNode.setParentNode(currentNode);
                    rightNode.setVisited(true);
                    nodeStack.push(rightNode);
                } else {
                    nodeStack.push(currentNode.getParentNode());
                }

            }
        }

        return nodeList;
    }

    public static void main(String[] args) {

        PreOrderTraversal pOrderTraversal = new PreOrderTraversal();
        NodeInsertion nInsert = new NodeInsertion();
        Node rootNode = nInsert.nodeGenerator();
        List<Integer> nodeList = pOrderTraversal.doPreOrderTraversal(rootNode);

        for (Integer node : nodeList) {
            System.out.print(node+" ");
        }
    }
}
