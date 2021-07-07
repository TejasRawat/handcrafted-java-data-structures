package org.dslib.list.arraylist;

import java.util.Iterator;

public class CustomArrayListIterator<E> implements Iterator<E> {
    private E[] e = null;
    private int top = 0;
    private int ptr = 0;

    public CustomArrayListIterator(E[] e, int top) {
        this.e = e;
        this.top = top;
    }

    public boolean hasNext() {
        boolean flag = false;
        if (this.ptr < this.top) {
            flag = true;
        }

        return flag;
    }

    public E next() {
        return this.e[this.ptr++];
    }

    public void remove() {
    }
}
