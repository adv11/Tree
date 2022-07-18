package FreeKaTree;
import java.util.LinkedList;
import java.util.Queue;

/***
 * LeetCode Link : https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
 * Given the root of a binary tree, return the maximum width of the given tree.
 * The maximum width of a tree is the maximum width among all levels.
 * The width of one level is defined as the length between the end-nodes
 * (the leftmost and rightmost non-null nodes), where the null nodes between the
 * end-nodes that would be present in a complete binary tree extending down to that
 * level are also counted into the length calculation.
 * It is guaranteed that the answer will in the range of a 32-bit signed integer.
 *
 *
 *
 * Example 1:
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
 */
class Pair3{
    TreeNode node;
    int index;
    public Pair3(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}
public class MaximumWidthOfBinaryTree extends TreeNode{
    public static int maximumWidth(TreeNode root){
        Queue<Pair3> queue = new LinkedList<>();
        if(root == null){
            return 0;
        }
        queue.offer(new Pair3(root, 0));
        int maxWidth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            int firstNodeIndex = 0, lastNodeIndex = 0;
            int minIndex = queue.peek().index;  // minimum index at the particular level

            for(int i=0 ; i<size ; i++){
                int curIndex = queue.peek().index - minIndex;
                TreeNode node = queue.remove().node;

                // for first node at the particular level
                if(i == 0){
                    firstNodeIndex = curIndex;
                }
                // for last node at the particular level
                if(i == size-1){
                    lastNodeIndex = curIndex;
                }

                if(node.left != null){
                    queue.offer(new Pair3(node.left, 2*curIndex+1));
                }
                if(node.right != null){
                    queue.offer(new Pair3(node.right, 2*curIndex+2));
                }
            }
            maxWidth = Math.max(maxWidth, (lastNodeIndex-firstNodeIndex+1));
        }
        return maxWidth;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.right.right.right = new TreeNode(14);

        System.out.println("Maximum width is : " + maximumWidth(root));
    }
}