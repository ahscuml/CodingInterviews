package question;

import util.TreeNode;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,
 * 6}，则重建二叉树并返回。
 * <p>
 * 遍历二叉树
 * 前序遍历：
 * 1.访问根节点
 * 2.前序遍历访问根节点的左子树
 * 3.前序遍历访问根节点的右子树
 * <p>
 * 中序遍历：
 * 1.中序遍历访问根节点的左子树
 * 2.访问中节点
 * 3.中序遍历访问根节点的右子树
 *
 * @author ahscuml
 * @date 2018/8/13
 * @time 12:10
 */
public class Q4reConstructBinaryTree {
    /**
     * @param pre 前序遍历
     * @param in  中序遍历
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode t = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return t;
    }

    /**
     * 前序遍历可以知道根节点是什么，再通过中序遍历，可以知道左右子树是什么，再递归。
     * 方便迭代，所以采用私有方法，包括前序遍历和中序遍历下标
     */
    private static TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int
            inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 根节点
        TreeNode root = new TreeNode(pre[preStart]);
        // 迭代的步骤，重点是怎么选择迭代的前序和中序遍历的下标
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                // 左子树的递归， 前序遍历起始下标是preStart + 1(因为第一个是root)，结束的下标是preStart + 左子树的个数， 左子树一共有i - inStart个
                // 中序遍历下标 起始是inStart, 结束是遍历的下标 i - 1
                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                // 根据左子树的下标方便搞定右子树
                root.right = reConstructBinaryTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }

    /**
     * 打印二叉树
     * 通过前序遍历
     */
    public static void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }
}


