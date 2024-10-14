
package com.eidd;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Node n1 = new DoublyNode<String>("noeud 1");
        Node n2 = new DoublyNode<String>("noeud 2");
        Node n3 = new DoublyNode<String>("noeud 3");
        Node n4 = new DoublyNode<String>("noeud 4");
        Node n5 = new DoublyNode<String>("noeud 5");
        Node n6 = new DoublyNode<String>("noeud 6");
        Node n7 = new DoublyNode<String>("noeud 7");
        Node n8 = new DoublyNode<String>("noeud 8");

        ((DoublyNode) n1).setPrev(null);
        n1.setNext(n2);
        ((DoublyNode) n2).setPrev(n1);
        ((DoublyNode) n3).setPrev(n2);
        n1.setNext(n2);
        ((DoublyNode) n2).setPrev(n1);

        n2.setNext(n3);
        ((DoublyNode) n3).setPrev(n2);

        n3.setNext(n4);
        ((DoublyNode) n4).setPrev(n3);

        n4.setNext(n5);
        ((DoublyNode) n5).setPrev(n4);

        n5.setNext(n6);
        ((DoublyNode) n6).setPrev(n5);

        n6.setNext(n7);
        ((DoublyNode) n7).setPrev(n6);

        n7.setNext(n8);
        ((DoublyNode) n8).setPrev(n7);
        n8.setNext(null);

        ArrayList al = new ArrayList<>();
        al.add(n1);
        al.add(n2);
        al.add(n3);
        al.add(n4);
        al.add(n5);
        al.add(n6);
        al.add(n7);
        al.add(n8);
        DoublyLinkedList dl = new DoublyLinkedList(al);

        System.out.println(dl);
        dl.deleteNode(4);
        System.out.println(dl);

    }
}