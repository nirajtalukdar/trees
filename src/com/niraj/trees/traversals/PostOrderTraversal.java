package com.niraj.trees.traversals;

import com.niraj.trees.utitilites.Node;
import com.niraj.trees.utitilites.NodeInsertion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    /**
     * The below method uses a simple algorithm to do a post order traversal of a binary tree
     * by associating the parent node and marking the visited node
     * @param node
     * @return java.util.List
     */
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

    /**
     * The below algorithm does a post order traversal of a binary tree without using a parent node
     * and without marking the visited flag
     * @param node
     * @return java.util.List
     */
    public List<Integer> postOrderTraverse(Node node) {

        List<Integer> nodeList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node previousNode = null;

        if (node != null) {

            nodeStack.push(node);
            while (!nodeStack.isEmpty()) {

                Node currentNode = nodeStack.peek();

                /** Condition to traverse in the forward direction **/

                if (previousNode == null || previousNode.getLeftNode() == currentNode || previousNode.getRightNode() == currentNode) {

                    if (currentNode.getLeftNode() != null) {
                        nodeStack.push(currentNode.getLeftNode());

                    } else if (currentNode.getRightNode() != null) {
                        nodeStack.push(currentNode.getRightNode());

                    } else {
                        nodeList.add(currentNode.getData());
                        nodeStack.pop();
                    }

                    /** Condition to traverse in the reverse direction **/

                } else if (currentNode.getLeftNode() == previousNode) {

                    if (currentNode.getRightNode() != null) {
                        nodeStack.push(currentNode.getRightNode());
                    }
                } else {

                    nodeList.add(currentNode.getData());
                    nodeStack.pop();
                }

                /** Save the current node as the previous node to track the most recently visited node **/
                previousNode = currentNode;

            }
        }

        return nodeList;
    }
}
