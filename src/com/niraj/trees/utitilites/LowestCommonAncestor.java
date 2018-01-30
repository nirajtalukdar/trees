package com.niraj.trees.utitilites;

public class LowestCommonAncestor {

    public Node getLCA(Node node, int dataNode1, int dataNode2) {

        if (node == null) {
            return null;

        } else if (node.getData() == dataNode1 || node.getData() == dataNode2 ) {
            return node;

        }
        Node leftNode = getLCA(node.getLeftNode(), dataNode1, dataNode2);
        Node rightNode = getLCA(node.getRightNode(), dataNode1, dataNode2);

        if (leftNode != null && rightNode != null) {
            return node;

        } else if (leftNode == null && rightNode == null) {
            return null;
        }

        return (leftNode != null) ? leftNode : rightNode;
    }

    public static void main(String[] args) {

        LowestCommonAncestor lca = new LowestCommonAncestor();
        NodeInsertion nInsert = new NodeInsertion();
        Node rootNode = nInsert.nodeGenerator();
        Node lowestAncestor = lca.getLCA(rootNode, 7,4);

        System.out.println(lowestAncestor.getData());
    }
}
