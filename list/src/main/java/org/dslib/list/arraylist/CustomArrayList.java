package org.dslib.list.arraylist;

import java.lang.reflect.Array;
import java.util.*;

public class CustomArrayList<E> extends AbstractList<E> implements List<E> {
    private E[] eArray = null;
    private E[] doubleArray = null;
    private int top = 0;
    private int capacity = 1;
    private Class<E> classType = null;

    public CustomArrayList(Class<E> classType) {
        this.eArray = (E[]) Array.newInstance(classType, this.capacity);
        this.classType = classType;
    }

    public boolean add(E e) {
        if (this.top < this.capacity) {
            this.eArray[this.top++] = e;
            return true;
        } else {
            this.doubleArray = (E[]) Array.newInstance(this.classType, this.capacity * 2);
            this.updateArray();
            this.eArray[this.top++] = e;
            return true;
        }
    }

    private void updateArray() {
        for (int i = 0; i < this.eArray.length; ++i) {
            this.doubleArray[i] = this.eArray[i];
        }

        this.eArray = this.doubleArray;
        this.capacity *= 2;
    }

    public E remove() {
        --this.top;
        return null;
    }

    public Iterator<E> iterator() {
        Iterator<E> iter = new CustomArrayListIterator<>(this.eArray, this.top);
        return iter;
    }

    public void add(int index, E element) {
        if (index <= this.top) {
            this.eArray[index] = element;
            if (index == this.top) {
                ++this.top;
            }

        } else {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    public int size() {
        return this.top;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public E get(int index) {
        if (index >= this.top) {
            throw new ArrayIndexOutOfBoundsException(index);
        } else {
            return this.eArray[index];
        }
    }

    public E remove(int index) {
        if (index >= this.top) {
            throw new ArrayIndexOutOfBoundsException(index);
        } else {
            for (int i = index; i < this.top; ++i) {
                this.eArray[i] = this.eArray[i + 1];
            }

            --this.top;
            return null;
        }
    }

    public E set(int index, E element) {
        if (index >= this.top) {
            throw new ArrayIndexOutOfBoundsException(index);
        } else {
            this.eArray[index] = element;
            return null;
        }
    }

    public void clear() {
        this.top = 0;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex >= this.top) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        } else if (toIndex >= this.top) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        } else {
            CustomArrayList<E> subList = new CustomArrayList(this.classType);

            for (int i = fromIndex; i <= toIndex; ++i) {
                subList.add(this.eArray[i]);
            }

            return subList;
        }
    }

    public boolean removeAll(Collection<?> c) {
        this.top = 0;
        this.eArray = null;
        return false;
    }

    public Object[] toArray() {
        return this.eArray;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }
}
