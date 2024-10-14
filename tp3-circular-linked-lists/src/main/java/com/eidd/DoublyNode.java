package com.eidd;

public class DoublyNode<T> extends Node<T> {
    private Node prev;

    public DoublyNode(T data) {
        super(data);
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public boolean hasPrev() {
        return prev != null;
    }

}
