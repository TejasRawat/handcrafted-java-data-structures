package org.dslib.binarytree;

import java.util.Objects;

public class TreeNode<E> {

    public E element;
    public TreeNode<E> left;
    public TreeNode<E> right;

    public TreeNode(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return element.equals(treeNode.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }
}
