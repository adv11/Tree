package FreeKaTree;
/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value
 *
 * Link : https://leetcode.com/problems/same-tree/
 */
public class Check_identical_trees extends TreeNode{
    TreeNode root1 = null;
    TreeNode root2 = null;

    public static boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null){
            return (root1 == root2);
        }
        return (root1.data == root2.data) && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
    public static void main(String[] args) {
        Check_identical_trees tree1 = new Check_identical_trees();
        tree1.root1 = new TreeNode(1);
        tree1.root1.left = new TreeNode(2);
        tree1.root1.right = new TreeNode(3);
        tree1.root1.right.left = new TreeNode(4);
        tree1.root1.right.right = new TreeNode(5);

        Check_identical_trees tree2 = new Check_identical_trees();
        tree2.root2 = new TreeNode(1);
        tree2.root2.left = new TreeNode(2);
        tree2.root2.right = new TreeNode(3);
        tree2.root2.right.left = new TreeNode(4);
        tree2.root2.right.right = new TreeNode(5);

        System.out.println("Is same tree ? " + isSameTree(tree1.root1, tree2.root2));
    }
}
