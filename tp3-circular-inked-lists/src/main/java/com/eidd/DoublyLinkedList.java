package com.eidd;

import java.util.ArrayList;

public class DoublyLinkedList implements LinkedList {
    ArrayList<Node> nodes;

    public DoublyLinkedList(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node, int index) {
        nodes.add(index, node);
        if (index > 0) {
            node.setNext(nodes.get(index - 1));
            ((DoublyNode) node).setPrev(nodes.get(index + 1));
        } else {
            node.setNext(nodes.get(index + 1));
        }
    }

    public void deleteNode(int index) {
        nodes.remove(index);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Node node : nodes) {
            sb.append(node.getValue());
            if (node.hasNext()) {
                sb.append("<----->");

            }

        }
        return sb.toString();
    }

}
