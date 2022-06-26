package FreeKaTree;

import java.util.ArrayList;
import java.util.Stack;

class TreeNode{
    int data;
    TreeNode left, right;

    TreeNode(){}

    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Pair{
    TreeNode node;
    int num;

    Pair(){}

    Pair(TreeNode newNode, int newNum){
        this.node = newNode;
        this.num = newNum;
    }
}
public class Preorder_Inorder_Postorder_inOneTraversal extends Pair{
    TreeNode root = null;

    public static void allTraversal(TreeNode root){
        Stack<Pair> stack = new Stack<>();
        ArrayList<Integer> preorder = new ArrayList<>();
        ArrayList<Integer> inorder = new ArrayList<>();
        ArrayList<Integer> postorder = new ArrayList<>();

        if(root == null){
            return;
        }
        stack.push(new Pair(root, 1));

        while(!stack.isEmpty()){
            Pair poppedPair = stack.pop();

            /**
             * Case 1:
             * if poopedPair.num == 1 then
             * Step 1 : store it in preorder list.
             * Step 2 : increment poppedPair.num by 1 and push it.
             * Step 3 : if left child is present then push it with num as 1
             */
            if(poppedPair.num == 1){
                preorder.add(poppedPair.node.data);
                poppedPair.num++;
                stack.push(poppedPair);

                // If left child is present
                if(poppedPair.node.left != null){
                    stack.push(new Pair(poppedPair.node.left, 1));
                }
            }

            /**
             * Case 2 :
             * if poppedPair.num == 2 then
             * Step 1 : store it in inorder list.
             * Step 2 : increment poppedPair.num by 1 and push it.
             * Step 3 : if right child is present then push it with num as 1.
             */
            else if(poppedPair.num == 2){
                inorder.add(poppedPair.node.data);
                poppedPair.num++;
                stack.push(poppedPair);

                // if right child is present
                if(poppedPair.node.right != null){
                    stack.push(new Pair(poppedPair.node.right, 1));
                }
            }

            /**
             * Case 3 :
             * if poppedPair.num == 3 then
             * Step 1 : store it in postorder list.
             */
            else{
                postorder.add(poppedPair.node.data);
            }
        }

        System.out.println("Preorder Traversal : " + preorder);
        System.out.println("Inorder Traversal : " + inorder);
        System.out.println("Postorder Traversal : " + postorder);
    }
    public static void main(String[] args) {
        Preorder_Inorder_Postorder_inOneTraversal tree = new Preorder_Inorder_Postorder_inOneTraversal();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        allTraversal(tree.root);
    }
}
