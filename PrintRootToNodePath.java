package FreeKaTree;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem link : https://www.interviewbit.com/problems/path-to-given-node/
 * Problem Description
 *
 * Given a Binary Tree A containing N nodes.
 *
 * You need to find the path from Root to a given node B.
 *
 * NOTE:
 *
 * No two nodes in the tree have same data values.
 * You can assume that B is present in the tree A and a path always exists.
 *
 *
 * Problem Constraints
 *  1 <= N <= 105
 *
 *  1 <= Data Values of Each Node <= N
 *
 *  1 <= B <= N
 *
 *
 *
 * Input Format
 * First Argument represents pointer to the root of binary tree A.
 *
 * Second Argument is an integer B denoting the node number.
 *
 *
 *
 * Output Format
 * Return an one-dimensional array denoting the path from Root to the node B in order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A =
 *
 *            1
 *          /   \
 *         2     3
 *        / \   / \
 *       4   5 6   7
 *
 *
 * B = 5
 *
 * Input 2:
 *
 *  A =
 *             1
 *           /   \
 *          2     3
 *         / \ .   \
 *        4   5 .   6
 *
 *
 * B = 1
 *
 *
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 5]
 * Output 2:
 *
 *  [1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We need to find the path from root node to node with data value 5.
 *  So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]
 * Explanation 2:
 *
 *  We need to find the path from root node to node with data value 1.
 *  As node with data value 1 is the root so there is only one node in the path.
 *  So we will return [1]
 */
public class PrintRootToNodePath extends TreeNode{

    // Hint : Perform inorder traversal for better and easy solution to understand
    public static boolean getPath(TreeNode root, int destinationNode, ArrayList<Integer> path){

        // if root is null then path is not possible
        if(root == null){
            return false;
        }
        path.add(root.data);    // else add root value

        // if root value == destination node then path has been found
        if(root.data == destinationNode){
            return true;
        }

        // else call inorder recursive function
        if(getPath(root.left, destinationNode, path) || getPath(root.right, destinationNode, path)){
            return true;
        }

        // if we reach at leaf node but node is not found then remove the last element(leaf ele) and move
        // in other direction
        path.remove(path.size() - 1);
        return false;
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

        ArrayList<Integer> path = new ArrayList<>();
        System.out.println("Enter the destination node : ");
        int destinationNode = sc.nextInt();
        boolean result = getPath(root, destinationNode, path);

        if(result){
            System.out.println("Node found : ");
            System.out.println("Path is : " + path);
        }else{
            System.out.println("Node not found in the given binary tree.");
        }
    }
}
