package com.eidd;

public class Node<T> {
    private T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    void deleteValue() {
        data = null;
    }

    T getValue() {
        return data;
    }

    void setValue(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean equals(Node node) {
        return this.data.equals(node.data);
    }

    public boolean hasNext() {
        return next != null;
    }

}
