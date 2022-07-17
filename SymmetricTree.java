package FreeKaTree;
/**
 * LeetCode link : https://leetcode.com/problems/symmetric-tree/
 * Given a Binary Tree. Check whether it is Symmetric or not, i.e. whether the binary tree is a Mirror image of itself or not.
 *
 * Example 1:
 *
 * Input:
 *          5
 *        /   \
 *       1     1
 *      /       \
 *     2         2
 * Output: True
 * Explanation: Tree is mirror image of
 * itself i.e. tree is symmetric
 */
public class SymmetricTree extends TreeNode{
    public static boolean isSymmetricTree(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot == null || rightRoot == null){
            return leftRoot == rightRoot;
        }
        if(leftRoot.data != rightRoot.data){
            return false;
        }
        return isSymmetricTree(leftRoot.left, rightRoot.right) && isSymmetricTree(leftRoot.right, rightRoot.left);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = isSymmetricTree(root.left, root.right);
        if(result)
            System.out.println("Symmetric tree");
        else
            System.out.println("Not symmetric tree");
    }
}
