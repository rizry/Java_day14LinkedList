package com.java.day14.llist;

public class LinkedLists<E> {

  Node<E> head;

  public void addLast(E item) {
    Node<E> newNode = new Node<>(item);

    if (head == null) head = newNode;//node being added is the first node
    else if (head.next == null) head.next = newNode;  //node being added is the second node
    else {
      Node<E> temp = head;
      while (temp.next != null) temp = temp.next; //traverse to the last node
      temp.next = newNode;
    }
  }

  public void addFirst(E item) {
    Node<E> newNode = new Node<>(item);

    if (head == null) head = newNode;//list is empty condition
    else {
      newNode.next = head;
      head = newNode;
    }
  }

  public void display() {
    if (isEmpty()) {
      System.out.println("list empty! nothing to display");
      return;
    }

    Node<E> temp = head;
    while (temp.next != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.println(temp.data);
  }

  private boolean isEmpty() {
    if (head == null) return true;
    else return false;
  }

}

class Node<E> {

  E data;
  Node<E> next;

  Node(E data) {
    this.data = data;
  }
}