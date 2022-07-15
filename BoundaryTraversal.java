package FreeKaTree;

import java.util.ArrayList;

/**
 * Problem Statement: BoundaryTraversal of a binary tree.
 * Write a program for the Anti-Clockwise Boundary traversal of a binary tree.
 */
public class BoundaryTraversal extends TreeNode{

    // method for checking is the node leaf node or not
    public static boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

    // method for adding Left boundary elements
    public static void leftBoundary(ArrayList<Integer> boundaryTraversal, TreeNode root){
        TreeNode cur = root.left;
        while (cur != null){
            if(!isLeaf(cur)){
                boundaryTraversal.add(cur.data);
            }
            if(cur.left != null){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
    }

    // method for adding leaf elements : Inorder Traversal
    public static void addLeafEle(ArrayList<Integer> boundaryTraversal, TreeNode root){
        if(root == null){
            return;
        }
        addLeafEle(boundaryTraversal, root.left);
        if(isLeaf(root)){
            boundaryTraversal.add(root.data);
        }
        addLeafEle(boundaryTraversal, root.right);
    }

    // method for adding Right boundary elements
    public static void rightBoundary(ArrayList<Integer> boundaryTraversal, TreeNode root){
        TreeNode cur = root.right;
        ArrayList<Integer> tempList = new ArrayList<>();
        while(cur != null){
            if(!isLeaf(cur)){
                tempList.add(cur.data);
            }
            if(cur.right != null){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }

        // adding elements in reverse order into the boundaryTraversal list
        for(int i=tempList.size()-1 ; i>=0 ; i--){
            boundaryTraversal.add(tempList.get(i));
        }
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

        ArrayList<Integer> boundaryTraversal = new ArrayList<>();
        boundaryTraversal.add(root.data);
        leftBoundary(boundaryTraversal, root);
        addLeafEle(boundaryTraversal, root);
        rightBoundary(boundaryTraversal, root);


        System.out.println("Boundary Traversal of the Binary Tree is as follows : ");
        System.out.println(boundaryTraversal);
    }
}
