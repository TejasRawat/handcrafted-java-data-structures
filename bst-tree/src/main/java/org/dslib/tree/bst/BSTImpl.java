package org.dslib.tree.bst;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTImpl implements BST {

    Node root;
    List<Integer> listPreOrder = new LinkedList<>();
    List<Integer> listInOrder = new LinkedList();
    List<Integer> listPostOrder = new LinkedList();

    @Override
    public void insert(Integer data) {
        this.root = this.insertInBST(this.root, data);
    }

    @Override
    public Boolean isElementPresent(Integer data) {
        return this.searchInBST(this.root, data);
    }

    @Override
    public Integer findMin() {
        Integer min = this.root.data;
        Node temp;
        for (temp = this.root; temp.left != null; temp = temp.left) {
        }
        min = temp.data;
        return min;
    }

    @Override
    public Integer findMax() {
        Integer max = this.root.data;
        for (Node temp = this.root; temp.right != null; temp = temp.right) {
        }
        max = this.root.data;
        return max;
    }

    @Override
    public void deleteNode(Integer num) {

    }

    @Override
    public Integer getAncestorNode(Integer num) {
        Node currentNode = searchElement(root, num);
        Node ansesterNode = root;

        while (ansesterNode != currentNode) {
            if (currentNode.data < ansesterNode.data) {
                ansesterNode = ansesterNode.left;
            } else {
                ansesterNode = ansesterNode.right;
            }
        }

        return ansesterNode.data;
    }

    @Override
    public List<Integer> getElementInBFSOrder() {
        List<Integer> list = new ArrayList();
        if (this.root == null) {
            System.err.println("Empty Tree");
        } else {
            Queue<Node> queue = new LinkedList();
            queue.add(this.root);

            for (; !queue.isEmpty(); queue.remove()) {
                Node currentNode = (Node) queue.peek();
                list.add(currentNode.data);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return list;
    }

    @Override
    public List<Integer> getElementInPreOrder() {
        this.getPreOrder(this.root);
        return this.listPreOrder;
    }

    private void getPreOrder(Node root) {
        if (root != null) {
            this.listPreOrder.add(root.data);
            this.getPreOrder(root.left);
            this.getPreOrder(root.right);
        }
    }

    private void getInOrder(Node root) {
        if (root != null) {
            this.getInOrder(root.left);
            this.listInOrder.add(root.data);
            this.getInOrder(root.right);
        }
    }

    private void getPostOrder(Node root) {
        if (root != null) {
            this.getPostOrder(root.left);
            this.getPostOrder(root.right);
            this.listPostOrder.add(root.data);
        }
    }

    @Override
    public List<Integer> getElementInInOrder() {
        this.getInOrder(this.root);
        return this.listInOrder;
    }

    @Override
    public List<Integer> getElementInPostOrder() {
        this.getPostOrder(this.root);
        return this.listPostOrder;
    }

    private static Node searchElement(Node root, int element) {
        Node current = null;
        if (root == null) {
            System.out.println("Empty Root");
        } else if (element == root.data) {
            System.out.println("Number Also Found in BST");
        } else if (element < root.data) {
            current = searchElement(root.left, element);
        } else {
            current = searchElement(root.right, element);
        }

        return current;
    }

    private Boolean searchInBST(Node root, Integer num) {
        boolean flag = false;
        if (root == null) {
            return flag;
        } else if (root.data == num) {
            flag = true;
            return flag;
        } else {
            if (root.data < num) {
                flag = this.searchInBST(root.right, num);
            } else {
                flag = this.searchInBST(root.left, num);
            }

            return flag;
        }
    }

    private Node insertInBST(Node root, int data) {
        if (root == null) {
            root = this.getNewNode(data);
        } else if (data <= root.data) {
            root.left = this.insertInBST(root.left, data);
        } else {
            root.right = this.insertInBST(root.right, data);
        }

        return root;
    }

    private Node getNewNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }
}
