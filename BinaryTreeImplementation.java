package BinaryTree;
import java.util.Scanner;

public class BinaryTreeImplementation {
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        createTree();
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
