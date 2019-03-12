package question;

import org.junit.Assert;
import org.junit.Test;
import util.TreeNode;

/**
 * @author ahscuml
 * @date 2019/3/12
 * @time 18:33
 */
public class Q4reConstructBinaryTreeTest {
    public static void preorderRec(TreeNode root, TreeNode root1) {
        if (root != null && root1 != null) {
            Assert.assertEquals(root.val, root1.val);
            preorderRec(root.left, root1.left);
            preorderRec(root.right, root1.right);
        }
    }

    @Test
    public void reConstructBianryTreeTest() {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(5);
        TreeNode treeNode8 = new TreeNode(6);
        TreeNode treeNode9 = new TreeNode(8);

        treeNode1.left = treeNode2;
        treeNode2.left = treeNode5;
        treeNode5.right = treeNode4;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode7;
        treeNode3.right = treeNode8;
        treeNode8.left = treeNode9;

        Q4reConstructBinaryTree q4 = new Q4reConstructBinaryTree();
        preorderRec(q4.reConstructBinaryTree(pre, in), treeNode1);
    }
}
