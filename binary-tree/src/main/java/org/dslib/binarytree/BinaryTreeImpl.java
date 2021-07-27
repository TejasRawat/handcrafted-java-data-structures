package org.dslib.binarytree;

import java.util.*;

public class BinaryTreeImpl<E> {

    public TreeNode<E> root;

    public BinaryTreeImpl() {
    }

    public List<E> getDFSOrder() {
        List<E> visitedNodes = new LinkedList<>();
        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<E> topNode = stack.pop();
            visitedNodes.add(topNode.element);
            TreeNode<E> leftNode = topNode.left;
            TreeNode<E> rightNode = topNode.right;
            if (Objects.nonNull(rightNode) && !visitedNodes.contains(rightNode.element)) {
                stack.push(rightNode);
            }
            if (Objects.nonNull(leftNode) && !visitedNodes.contains(leftNode.element)) {
                stack.push(leftNode);
            }
        }
        return visitedNodes;
    }

    public List<E> getInOrder() {
        List<E> visitedNodes = new LinkedList<>();
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> currNode = root;

        while (!stack.isEmpty() || Objects.nonNull(currNode)) {
            while (Objects.nonNull(currNode)) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            visitedNodes.add(currNode.element);
            currNode = currNode.right;
        }
        return visitedNodes;
    }

    public List<E> getBFSOrder() {
        List<E> visitedNodes = new LinkedList<>();
        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<E> topNode = queue.poll();
            visitedNodes.add(topNode.element);

            TreeNode<E> leftNode = topNode.left;
            TreeNode<E> rightNode = topNode.right;
            if (Objects.nonNull(leftNode) && !visitedNodes.contains(leftNode.element)) {
                queue.add(leftNode);
            }
            if (Objects.nonNull(rightNode) && !visitedNodes.contains(rightNode.element)) {
                queue.add(rightNode);
            }
        }
        return visitedNodes;

    }

    public E addElementsInLevelOrder(E element) {
        if (Objects.isNull(root)) {
            root = createNewNode(element);
            return element;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode peek = queue.poll();
            if (Objects.isNull(peek.left)) {
                peek.left = createNewNode(element);
                return element;
            } else if (Objects.isNull(peek.right)) {
                peek.right = createNewNode(element);
                return element;
            }

            if (Objects.nonNull(peek.left)) {
                queue.add(peek.left);
            }
            if (Objects.nonNull(peek.right)) {
                queue.add(peek.right);
            }
        }

        return null;
    }

    private TreeNode<E> createNewNode(E element) {
        TreeNode<E> treeNode = new TreeNode<>(element);
        treeNode.left = null;
        treeNode.right = null;
        return treeNode;
    }

}


































