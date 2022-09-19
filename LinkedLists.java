package com.java.day14.llist;

import java.util.ArrayList;

public class LinkedLists<E> {

  Node<E> head;
  private int count;

  public void addFirst(E item) {
    Node<E> newNode = new Node<>(item);

    if (head == null) head = newNode;//list is empty condition
    else {
      newNode.next = head;
      head = newNode;
    }
    count++;
    sort();
  }

  public void addLast(E item) {
    Node<E> newNode = new Node<>(item);

    if (head == null) head = newNode;//node being added is the first node
    else if (head.next == null) head.next = newNode;  //node being added is the second node
    else {
      Node<E> temp = head;
      while (temp.next != null) temp = temp.next; //traverse to the last node
      temp.next = newNode;
    }
    count++;
    sort();
  }

  public void insertAt(int index, E item) {
    if (index < 1 || index > count + 1) {
      System.out.println("invalid index. enter between 1 and " + (count + 1));
      return;
    } else if (index == 1) {
      if (head == null) System.out.println("list empty! adding " + item + " at index 1.");
      addFirst(item);
    } else if (index == count + 1) addLast(item);
    else {
      Node<E> newNode = new Node<>(item);
      Node<E> temp = head;

      for (int i = 1; i < index - 1; i++) temp = temp.next;
      newNode.next = temp.next;
      temp.next = newNode;
      count++;
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

  public void displayFromEnd() {
    if (isEmpty()) {
      System.out.println("list empty! nothing to display");
      return;
    }

    ArrayList<E> nodes = new ArrayList<>(); //creating an empty ArrayList, to the node elements.
    Node<E> temp = head;
    
    while (temp.next != null) {
        nodes.add(temp.data); //adding nodes to arraylist till current node's next points to null
        temp = temp.next;
      }
    nodes.add(temp.data); //adding last node to arraylist

    for (int i = nodes.size() - 1; i > 0; i--) {
      System.out.print(nodes.get(i) + " -> ");
    }
    System.out.println(nodes.get(0));
  }

  public void pop() {
    if (head == null) {
      System.out.println("list empty! nothing to delete");
      return;
    } else {
      Node<E> temp = head;

      head = head.next;
      temp.next = null;
      count--;
    }
  }

  public void popLast() {
    if (head == null) {
      System.out.println("list empty! nothing to delete");
      return;
    } else if (head.next == null) {
      System.out.println("deleted " + head.data);
      head = head.next;
      count--;
    }
    else {
      Node<E> temp = head;

      while (temp.next.next != null) temp = temp.next;
      System.out.println("deleted " + temp.next.data);
      temp.next = null;
      count--;
    }
  }

  public void deleteNode(E nodeTodelete) {
    if (isEmpty()) {
      System.out.println("list empty! cant delete " + nodeTodelete);
    } else if (head.data == nodeTodelete) {
      System.out.println("deleted " + nodeTodelete + " from index " + 1);
      pop();
    } else {
      Node<E> temp = head;
      Node<E> temp2 = head.next;
      for (int i = 2; i <= count; i++) {    //looping until we find the node to delete.
        if (temp2.data == nodeTodelete) {
          System.out.println("deleted " + nodeTodelete + " from index " + i);
          temp.next = temp2.next;
          count--;
          return;
        }
        temp = temp.next;
        temp2 = temp2.next;
      }
      System.out.println("we couldnt find " + nodeTodelete + " in the list.");    //when looped till the end and couldn't find the node
    }
  }

  public void findNode(E nodeToFind) {
    if (isEmpty()) {
      System.out.println("list empty! cant add after " + nodeToFind);
    } else {
      Node<E> temp = head;
      for (int i = 1; i <= count; i++) {    //looping until we find the given node.
        if (temp.data == nodeToFind) {
          System.out.println(nodeToFind + " found at index " + i);
          return;
        }
        temp = temp.next;
      }
      System.out.println("we couldnt find " + nodeToFind + " in the list.");    //when looped till the end and couldn't find the node
    }
  }

  public void addNodeAfter(E prevNode, E nodeToAdd) {
    if (isEmpty()) {
      System.out.println("list empty! cant add after " + prevNode);
    } else {
      Node<E> temp = head;

      for (int i = 1; i <= count; i++) {    //looping until we find the node to add after.
        if (temp.data == prevNode) {
          Node<E> newNode = new Node<>(nodeToAdd);
          newNode.next = temp.next;
          temp.next = newNode;
          System.out.println(prevNode + " found at index " + i + ". added " + nodeToAdd + " at index " + (i + 1));
          count++;
          return;
        }
        temp = temp.next;
      }
      System.out.println("we couldnt find " + prevNode + " in the list. perhaps try a different node"); //when looped till the end and didnt find the node
    }
  }

  public short size() {
    if (isEmpty()) return 0;
    else if (head.next == null) return 1;
    else {
      short size = 1;
      Node<E> temp = head;
      for (short i = 0; i <= count; i++) {
        if (temp.next == null) return size;
        temp = temp.next;
        size++;
      }
      return size;
    }
  }

  @SuppressWarnings({"unchecked", "rawtypes", "hiding"})
  public <E extends Comparable> void sort() {
    boolean swapped = false;
    do {
      Node<E> fNode = (Node<E>) head;
      Node<E> sNode = (Node<E>) head.next;
      swapped = false;
      for (short i = 2; i <= count; i++) {
        if (fNode.data.compareTo(sNode.data) > 0) {
          E temp = fNode.data;
          fNode.data = sNode.data;
          sNode.data = temp;
          swapped = true;
        }
        fNode = fNode.next;
        sNode = sNode.next;
      }
    } while (swapped);
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