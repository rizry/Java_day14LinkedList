package com.java.day14.llist;

public class Main {

  public static void main(String[] args) {

    LinkedLists<Integer> linkedL = new LinkedLists<>();

    linkedL.addFirst(70);
    linkedL.addFirst(30);
    linkedL.addFirst(56);

    linkedL.display();
  }

}
