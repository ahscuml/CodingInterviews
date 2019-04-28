package question;
import util.TreeNode;

import java.util.ArrayDeque;

/**
 * @author ahscuml
 * @date 2019/4/23
 * @time 21:21
 */
public class Q35Convert {
    public static void main(String[] args) {

    }


    /**
     * 递归中序遍历
     * */
    TreeNode head = null;
    TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        helper(pRootOfTree);
        return head;
    }

    public void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root.left);
        if(head == null) {
            head = root;
            pre = root;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        helper(root.right);
    }

    /**
     * 利用循环的中序遍历
     * */
    public TreeNode ConvertII(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        TreeNode head = null, pre = null;
        ArrayDeque<TreeNode> stack = new ArrayDeque();
        TreeNode cur = pRootOfTree;
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if(head == null) {
                    head = cur;
                    pre = head;
                } else {
                    cur.left = pre;
                    pre.right = cur;
                    pre = cur;
                }
                cur = cur.right;
            }
        }
        return head;
    }
}
