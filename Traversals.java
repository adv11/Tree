package BinaryTree;
import java.util.Scanner;

public class Traversals {
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();

        System.out.println("Preorder Traversal");
        preOrder(root);

        System.out.println();

        System.out.println("Inorder Traversal");
        inOrder(root);

        System.out.println();

        System.out.println("Postorder Traversal");
        postOrder(root);
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);      // left
        System.out.print(root.data + " ");    // root
        inOrder(root.right);    // right
    }

    public static void preOrder(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");  // root
        preOrder(root.left);    // left
        preOrder(root.right);   // right
    }
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        preOrder(root.left);    // left
        preOrder(root.right);   // right
        System.out.print(root.data + " ");  // root
    }

    public static Node createTree(){
        Node root = null;
        System.out.println("Enter data:");
        int data = sc.nextInt();
        if(data == -1){ // means node has no left or right child
            return null;
        }
        root = new Node(data);

        System.out.println("Enter the left child of the node : " + data);   // left child
        root.left = createTree();
        System.out.println("Enter the right child of the node : " + data);  // right child
        root.right = createTree();

        return root;
    }
}
