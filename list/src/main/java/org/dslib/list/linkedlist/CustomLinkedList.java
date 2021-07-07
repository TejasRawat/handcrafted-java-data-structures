package org.dslib.list.linkedlist;

import java.util.*;

public class CustomLinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E> {
    private Node<E> front = null;
    private Node<E> rear = null;
    private int size = 0;

    public CustomLinkedList() {
    }

    public boolean add(E e) {
        this.addFirst(e);
        return true;
    }

    public void addFirst(E e) {
        Node<E> temp = new Node();
        if (this.front == null && this.rear == null) {
            temp.data = e;
            temp.next = null;
            temp.prev = null;
            this.front = temp;
            this.rear = temp;
        } else {
            temp.data = e;
            temp.next = this.front;
            this.front.prev = temp;
            temp.prev = null;
            this.front = temp;
        }

        ++this.size;
    }

    public void addLast(E e) {
        Node<E> temp = new Node();
        if (this.front == null && this.rear == null) {
            temp.data = e;
            temp.next = null;
            temp.prev = null;
            this.front = temp;
            this.rear = temp;
        } else {
            temp.data = e;
            temp.next = null;
            temp.prev = this.rear;
            this.rear.next = temp;
            this.rear = temp;
        }

        ++this.size;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E remove() {
        if (this.rear == null) {
            System.err.println("List is Empty");
        } else if (this.front == this.rear) {
            this.front = null;
            this.rear = null;
        } else {
            this.rear = this.rear.prev;
        }

        return null;
    }

    public Iterator<E> iterator() {
        Iterator<E> iter = new CustomLinkedListIterator(this.front);
        return iter;
    }

    public E peek() {
        return this.rear.data;
    }

    public E getFirst() {
        return this.front.data;
    }

    public E getLast() {
        return this.rear.data;
    }

    public E peekFirst() {
        return this.front.data;
    }

    public E peekLast() {
        return this.rear.data;
    }

    public E poll() {
        if (this.front == null && this.rear == null) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node<E> temp = this.front;
            this.front = this.front.next;
            return temp.data;
        }
    }

    public boolean removeAll(Collection<?> c) {
        this.front = null;
        this.rear = null;
        return true;
    }

    public boolean offer(E e) {
        this.addLast(e);
        return true;
    }

    public boolean offerFirst(E e) {
        this.addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        this.addLast(e);
        return true;
    }

    public E element() {
        return this.front.data;
    }

    public void add(int index, E element) {
        int i = 0;
        if (index > this.size) {
            throw new IndexOutOfBoundsException(index + ", Current List Size-" + this.size);
        } else {
            Node temp;
            if (index == 0) {
                temp = new Node();
                temp.data = element;
                temp.prev = null;
                temp.next = this.front;
                this.front.prev = temp;
                this.front = temp;
                ++this.size;
            } else if (index == this.size) {
                temp = new Node();
                temp.data = element;
                temp.prev = this.rear;
                temp.next = null;
                this.rear.next = temp;
                this.rear = temp;
                ++this.size;
            } else {
                for (temp = this.front; temp != null; ++i) {
                    if (i == index - 1) {
                        Node<E> tempNode = new Node();
                        tempNode.data = element;
                        tempNode.next = temp.next;
                        tempNode.prev = temp;
                        temp.next.prev = tempNode;
                        temp.next = tempNode;
                        ++this.size;
                        break;
                    }

                    temp = temp.next;
                }
            }

        }
    }

    public E remove(int index) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException("" + index + this.size);
        } else {
            if (index == 0) {
                if (this.front == null) {
                    throw new NullPointerException("list" + this.front);
                }

                if (this.front == this.rear) {
                    this.front = null;
                    this.rear = null;
                    --this.size;
                } else {
                    this.front = this.front.next;
                    this.front.prev = null;
                    --this.size;
                }
            } else if (index == this.size - 1) {
                if (this.rear == null) {
                    throw new NullPointerException("Rear" + this.rear);
                }

                if (this.front == this.rear) {
                    this.front = null;
                    this.rear = null;
                    --this.size;
                } else {
                    this.rear = this.rear.prev;
                    this.rear.next = null;
                    --this.size;
                }
            } else {
                int i = 0;

                for (Node temp = this.front; temp != null; ++i) {
                    if (i == index - 1) {
                        temp.next = temp.next.next;
                        temp.next.next.prev = temp;
                        --this.size;
                        break;
                    }

                    temp = temp.next;
                }
            }

            return null;
        }
    }

    public boolean remove(Object o) {
        for (Node temp = this.front; temp != null; temp = temp.next) {
            if (o == temp.data) {
                if (temp == this.front) {
                    this.front = this.front.next;
                    this.front.prev = null;
                    --this.size;
                } else if (temp == this.rear) {
                    this.rear = this.rear.prev;
                    this.rear.next = null;
                    --this.size;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    temp = null;
                    --this.size;
                }
                break;
            }
        }

        return false;
    }

    public E get(int index) {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("" + index);
        } else {
            return null;
        }
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

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public Object[] toArray() {
        return null;
    }

    public <T> T[] toArray(T[] a) {
        return null;
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

    public E set(int index, E element) {
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    public E removeFirst() {
        return null;
    }

    public E removeLast() {
        return null;
    }

    public E pollFirst() {
        return null;
    }

    public E pollLast() {
        return null;
    }

    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    public void push(E e) {
    }

    public E pop() {
        return null;
    }

    public Iterator<E> descendingIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }
}
