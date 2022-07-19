package FreeKaTree;

/**
 * Given a binary tree, we have to make each node in binary tree such that the sum of each node in BT
 * should be equal to the sum of it's left and right children.
 *
 * Property : Node's value = left child + right child
 *
 * We can change the value of any node only by +1 any number of times.
 *
 * TC : O(N), SC : O(H)
 */
public class ChildrenSumPropertyInBT extends TreeNode{

    // method for printing preorder of binary tree
    public static void printBT(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printBT(root.left);
        printBT(root.right);
    }
    public static void childrenSumProperty(TreeNode root){
        if(root == null)
            return;
        int child = 0;
        if(root.left != null){
            child += root.left.data;
        }
        if(root.right != null){
            child += root.right.data;
        }

        // checking if the sum of (left + right) < node's value then left = node and right = node
        // else assign node = left + right
        if(child < root.data){
            if(root.left != null){
                root.left.data = root.data;
            }
            if(root.right != null){
                root.right.data = root.data;
            }
        }else{
            root.data = child;
        }

        // Recursive calls
        childrenSumProperty(root.left);
        childrenSumProperty(root.right);

        // while returning from the recursive call, we are calculating the sum of left and right children
        // for assigning it to the node
        int newChild = 0;
        if(root.left != null){
            newChild += root.left.data;
        }
        if(root.right != null){
            newChild += root.right.data;
        }

        // checking if the node is not leaf node then assign the value otherwise not
        if(root.left != null || root.right != null){
            root.data = newChild;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);

        System.out.println("Old Tree is : ");
        printBT(root);

        childrenSumProperty(root);

        System.out.println("\n New Tree is : ");
        printBT(root);
    }
}
