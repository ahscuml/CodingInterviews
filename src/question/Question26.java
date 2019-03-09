package question;

/**
 * 判断是否是子树
 *
 * @author ahscuml
 * @date 2018/11/17
 * @time 10:47
 */
public class Question26 {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {

    }

    /**
     * 判断是否是子树，首先要确定是否头结点拥有相同的值，然后再进行判断，是否拥有相同的结构
     * 判断头结点是否相同等同于对树的遍历，对于树的遍历有两种方法，一种是利用递归，一种是利用循环
     * */
    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        boolean result = false;

        return result;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}

