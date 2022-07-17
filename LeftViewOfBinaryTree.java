package FreeKaTree;
import java.util.ArrayList;

/**
 * GFG Link : https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
 *
 * Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when
 * tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.
 *
 * Left view of following tree is 1 2 4 8.
 *
 *           1
 *        /     \
 *      2        3
 *    /     \    /    \
 *   4     5   6    7
 *    \
 *      8
 */
public class LeftViewOfBinaryTree extends TreeNode{

    /**
     * Hint : Perform preorder traversal and put first node in the particular level into the data structure.
     * Root, left , right
     */
    public static void leftView(TreeNode root, int level, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        if(level == result.size()){
            result.add(root.data);
        }
        leftView(root.left, level+1, result);
        leftView(root.right, level+1, result);
    }
    public static void main(String[] args) {
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

        ArrayList<Integer> result = new ArrayList<>();
        leftView(root, 0, result);
        System.out.println("Left view of the given binary tree is : " + result);
    }
}
