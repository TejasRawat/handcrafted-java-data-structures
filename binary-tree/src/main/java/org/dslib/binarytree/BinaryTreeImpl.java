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
}

