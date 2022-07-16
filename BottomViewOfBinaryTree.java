package FreeKaTree;
import java.util.*;
/**\
 * GFG Link : https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
 * Given a binary tree, print the bottom view from left to right.
 * A node is included in bottom view if it can be seen when we look at the tree from bottom.
 *
 *                       20
 *                     /    \
 *                   8       22
 *                 /   \        \
 *               5      3       25
 *                     /   \
 *                   10    14
 *
 * For the above tree, the bottom view is 5 10 3 14 25.
 * If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal.
 * For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.
 *
 *                       20
 *                     /    \
 *                   8       22
 *                 /   \     /   \
 *               5      3 4     25
 *                      /    \
 *                  10       14
 *
 * For the above tree the output should be 5 10 4 14 25.
 *  */
class Pair2{
    TreeNode node;  // node's value
    int line;   // vertical line value
    public Pair2(TreeNode node, int line){
        this.node = node;
        this.line = line;
    }
}
public class BottomViewOfBinaryTree extends TreeNode{
    public static ArrayList<Integer> bottomView(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<Pair2> queue = new LinkedList<>();
        queue.offer(new Pair2(root, 0));
        Map<Integer, Integer> map = new TreeMap<>();

        while(!queue.isEmpty()){
            Pair2 pair = queue.poll();
            TreeNode node = pair.node;
            int line = pair.line;

            map.put(line, node.data);
            if(node.left != null){
                queue.offer(new Pair2(node.left, line-1));
            }
            if(node.right != null){
                queue.offer(new Pair2(node.right, line+1));
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
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

        ArrayList<Integer> list = bottomView(root);
        System.out.println("Bottom view of Binary Tree is : " + list);
    }
}
