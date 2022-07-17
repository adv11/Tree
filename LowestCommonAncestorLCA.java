package FreeKaTree;
import java.util.Scanner;

/**
 * Problem Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Given a Binary Search Tree (with all values unique) and two node values. Find the Lowest Common Ancestors of the two nodes in the BST.
 *
 * Example 1:
 *
 * Input:
 *               5
 *            /    \
 *          4       6
 *         /         \
 *        3           7
 *                     \
 *                      8
 * n1 = 7, n2 = 8
 * Output: 7
 * Example 2:
 *
 * Input:
 *      2
 *    /   \
 *   1     3
 * n1 = 1, n2 = 3
 * Output: 2
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function LCA() which takes the root Node of the BST and two integer values n1 and n2 as inputs and returns the Lowest Common Ancestor of the Nodes with values n1 and n2 in the given BST.
 *
 * Expected Time Complexity: O(Height of the BST).
 * Expected Auxiliary Space: O(Height of the BST).
 *
 * Constraints:
 * 1 <= N <= 104
 */
public class LowestCommonAncestorLCA extends TreeNode{
    public static TreeNode lca(TreeNode root, int p, int q){
        if(root == null || root.data == p || root.data == q){
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        // Case : if anyone node is null then return other node
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }

        // Case : if both nodes are null then this is our answer
        else{
            return root;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        System.out.println("Enter the first node :");
        int p = sc.nextInt();
        System.out.println("Enter the second node : ");
        int q = sc.nextInt();

        TreeNode lca = lca(root, p, q);
        System.out.println(lca.data);
    }
}
