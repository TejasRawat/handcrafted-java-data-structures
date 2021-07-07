package org.dslib.tree.bst;

import java.util.List;

public interface BST {

    void insert(Integer data);

    Boolean isElementPresent(Integer data);

    Integer findMin();

    Integer findMax();

    void deleteNode(Integer num);

    Integer getAncestorNode(Integer num);

    List<Integer> getElementInBFSOrder();
    List<Integer> getElementInPreOrder();
    List<Integer> getElementInInOrder();
    List<Integer> getElementInPostOrder();

}
