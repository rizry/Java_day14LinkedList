package com.java.day14.llist;

public class Main {

  public static void main(String[] args) {

    LinkedLists<Integer> linkedL = new LinkedLists<>();
    linkedL.addLast(56);
    linkedL.addLast(70);

    linkedL.insertAt(2, 30);
    linkedL.display();

    linkedL.popLast();
    linkedL.display();

  }

}
