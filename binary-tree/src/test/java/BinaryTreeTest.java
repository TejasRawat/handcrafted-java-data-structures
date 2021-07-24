import org.dslib.binarytree.BinaryTreeImpl;
import org.dslib.binarytree.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinaryTreeTest {

    BinaryTreeImpl<Integer> binaryTree;

    @BeforeEach
    public void init() {
        /**
         *
         *      1
         *    2   3
         *  4  5
         *
         */
        binaryTree = new BinaryTreeImpl<>();
        binaryTree.root = new TreeNode(1);
        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(3);
        binaryTree.root.left.left = new TreeNode(4);
        binaryTree.root.left.right = new TreeNode(5);
    }

    @Test
    public void dfsOrder() {
        List<Integer> dfsOrder = binaryTree.getDFSOrder();
        Integer a[] = {1, 2, 4, 5, 3};
        int index = 0;
        for (Integer vertex : dfsOrder) {
            Assertions.assertEquals(vertex, a[index]);
            index++;
        }
    }

    @Test
    public void inOrder() {
        List<Integer> dfsOrder = binaryTree.getInOrder();
        Integer a[] = {4, 2, 5, 1, 3};
        int index = 0;
        for (Integer vertex : dfsOrder) {
            Assertions.assertEquals(vertex, a[index]);
            index++;
        }
    }

    @Test
    public void bfsOrder() {
        List<Integer> dfsOrder = binaryTree.getBFSOrder();
        Integer a[] = {1, 2, 3, 4, 5};
        int index = 0;
        for (Integer vertex : dfsOrder) {
            Assertions.assertEquals(vertex, a[index]);
            index++;
        }
    }


}
