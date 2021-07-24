package org.dslib.stack;

import java.util.EmptyStackException;

public class MyStack<E> {

    private Object[] elements;
    private int top = 0;
    private int maxCapacity = 10;

    public MyStack() {
        this.elements = new Object[maxCapacity];
    }

    public Boolean push(E element) {
        if (top == maxCapacity - 1) {
            throw new StackOverflowError();
        }
        elements[top++] = element;

        return true;
    }

    public E pop() {
        if (top == 0) {
            throw new EmptyStackException();
        }

        E poppedElement = (E) elements[top];
        top--;
        return poppedElement;
    }

    public Boolean isEmpty() {
        return top == 0;
    }

}
