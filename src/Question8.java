/**
 * 二叉树的下一个节点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author ahscuml
 * @date 2018/9/10
 * @time 22:09
 */
public class Question8 {
    /**
     * 明白中序遍历的过程，中序遍历先是 中序遍历左节点 然后遍历根节点 再遍历右节点
     * 所以找一个节点的下一个中序遍历节点可以分为几种情况
     * 如果右节点存在 中序遍历右子树，找第一个节点(就是找右子树的最左节点)
     * 如果右节点不存在，找这个节点的父节点（当前节点必须是这个父节点的左子树才行）否则继续向上遍历，找到一个是它父节点的左子节点的节点
     * 否则没有
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 如果中序遍历右节点存在，则找右节点的最左节点
        if(pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 如果中序遍历右节点不存在，则找第一个当前节点是父节点左孩子的节点！！！ 只要在一个节点的左子树中就是存在后面的数字
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        // 如果这两项都不存在就返回空
        return null;
    }
}

/**
 * 二叉树的定义
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}