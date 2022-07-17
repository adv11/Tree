package FreeKaTree;
import java.util.ArrayList;
/**
 * LeetCode : https://leetcode.com/problems/binary-tree-right-side-view/
 * Given a Binary Tree, find Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.
 *
 * Right view of following tree is 1 3 7 8.
 *
 *           1
 *        /     \
 *      2        3
 *    /   \      /    \
 *   4     5   6    7
 *     \
 *      8
 */
public class RightViewOfBinaryTree extends TreeNode{

    /**
     * Hint : Perform reverse preorder traversal in the tree for the required answer.
     * Reverse preorder means Root, Right, Left
     */
    public static void rightView(TreeNode root, int level, ArrayList<Integer> result){
        if(root == null){
            return;
        }

        // if the level is equal to the size of the result data structure
        // then the first node is the result of our question while traversing from right to left direction
        if(level == result.size()){
            result.add(root.data);
        }
        rightView(root.right, level+1, result);
        rightView(root.left, level+1, result);
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
        rightView(root, 0, result);
        System.out.println("Right view of the given binary tree is : " + result);
    }
}
