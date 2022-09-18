package com.java.day14.llist;

public class LinkedLists<E> {

  Node<E> head;
}

class Node<E> {

  E data;
  Node<E> next;

  Node(E data) {
    this.data = data;
  }
}