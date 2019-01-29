import java.util.ArrayList;

/**
 * @author ahscuml
 * @date 2018/12/10
 * @time 20:15
 */
public class Question34 {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(12);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(7);


        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        int target = 22;

        System.out.println(FindPath(treeNode1, target));
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        // 返回的list中，数组长度大的数组靠前

        // 一定要从根节点开始遍历
        // 简单思路，通过HashMap存储所有路径的值，然后读出，空间复杂度会增加，时间复杂度也会增加
        // 如果不用HashMap存储，也要对所有的路径进行遍历，遍历过程中有trick,
        // 1. 如何遍历所有路径
        // 2. trick 一个参数count记录当前的路径值，大于target就可以放弃这条路径

        // 另外一个思路，也可以在每一个节点(新建一个树)，记录从根节点到这里的路径值，然后看最后叶子节点的值哪一个与value相同
        ArrayList<Integer> pathRes = new ArrayList();
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        helper(root, target, pathRes, res);
        return res;
    }

    public static void helper(TreeNode root, int target, ArrayList<Integer> pathRes,
                              ArrayList<ArrayList<Integer>> res) {
        if (root == null) {
            return;
        }
        target -= root.val;
        pathRes.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(pathRes));
        }
        // 提前终止条件
        if (target <= 0) {
            pathRes.remove(pathRes.size() - 1);
            return;
        }
        helper(root.left, target, pathRes, res);
        helper(root.right, target, pathRes, res);

        pathRes.remove(pathRes.size() - 1);
    }

    /**
     * 树结构的定义
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
