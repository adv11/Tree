package FreeKaTree;
import java.util.*;
/**
 * GFG Link : https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
 *
 * Given below is a binary tree. The task is to print the top view of binary tree.
 * Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree
 *
 *        1
 *     /     \
 *    2       3
 *   /  \    /   \
 *  4    5  6     7
 *
 * Top view will be: 4 2 1 3 7
 * Note: Return nodes from leftmost node to rightmost node.
 */
class Pair1{
    TreeNode node;
    int hd;
    public Pair1(TreeNode node, int hd){
        this.node = node;
        this.hd = hd;
    }
}
public class TopViewOfBinaryTree extends TreeNode{
    public static ArrayList<Integer> topView(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair1> queue = new LinkedList<>();
        queue.offer(new Pair1(root, 0));

        while(!queue.isEmpty()){
            Pair1 pair = queue.remove();
            int hd = pair.hd;
            TreeNode tempNode = pair.node;

            if(map.get(hd) == null){
                map.put(hd, tempNode.data);
            }
            if(tempNode.left != null){
                queue.add(new Pair1(tempNode.left, hd-1));
            }
            if(tempNode.right != null){
                queue.add(new Pair1(tempNode.right, hd+1));
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
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

        System.out.println("Top View of given Binary Tree is : " + topView(root));
    }
}
