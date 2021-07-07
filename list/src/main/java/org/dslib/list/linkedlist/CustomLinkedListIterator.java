package org.dslib.list.linkedlist;

import java.util.Iterator;

public class CustomLinkedListIterator<E> implements Iterator<E> {
    private Node<E> front;

    public CustomLinkedListIterator(Node<E> front) {
        this.front = front;
    }

    public boolean hasNext() {
        boolean iterFlag = false;
        if (this.front == null) {
            iterFlag = false;
        } else {
            iterFlag = true;
        }

        return iterFlag;
    }

    public E next() {
        Node<E> temp = this.front;
        this.front = this.front.next;
        return temp.data;
    }

    public void remove() {
    }

    public Node<E> getNode() {
        return this.front;
    }

    public void setNode(Node<E> front) {
        this.front = front;
    }
}
