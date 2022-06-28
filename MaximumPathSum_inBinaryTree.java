package FreeKaTree;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 *
 * Link of the Problem : https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class MaximumPathSum_inBinaryTree extends TreeNode{
    TreeNode root = null;
    public static int maxPathSum(TreeNode root){
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }
    public static int maxPathDown(TreeNode root, int[] maxValue){
        if(root == null){
            return 0;
        }

        // finding max path sum from left and right child
        int left = Math.max(0, maxPathDown(root.left, maxValue));
        int right = Math.max(0, maxPathDown(root.right, maxValue));

        // applying formula : root.val + left + right
        maxValue[0] = Math.max(maxValue[0], (left + right + root.data));

        // returning root.val + max(left, right)
        return root.data + Math.max(left, right);
    }
    public static void main(String[] args) {
        MaximumPathSum_inBinaryTree tree = new MaximumPathSum_inBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.right.left = new TreeNode(8);
    }
}
