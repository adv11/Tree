package FreeKaTree;
/**
 * Properties of tree :

 * 1) Number of nodes at the level(l) is 2^l
 * 2) Maximum number of nodes in a binary tree of height(h) is 2^h-1
 * 3) In a binary tree with N nodes minimum possible height or the minimum number of levels is log2(N+1)
 * 4) A binary tree with l leaf nodes has at least |log2L|+1 levels
 * 5) In a binary tree where every node has 0 or 2 children, the number of leaf nodes is always one more than nodes having 2 children


 * Types of Binary Tree :

 * 1) Perfect Binary Tree : If every node has 0 or 2 children. also known as Proper Binary Tree.
 * 2) Complete Binary Tree : If all the levels are completely filled except possibly the last level and the last level has all the keys
                             as left as possible.
 * 3) Perfect Binary Tree : All internal nodes have 2 children and leaf nodes should be at the same level.
 * 4) Balanced Binary Tree : Difference between left and right subtree should be 0 or 1. It takes O(log N) time for the operations
                             like - searching, inserting and deletion like - AVL Tree, Red Black Tree.
 * 5) Degenerated/Pathological Tree : A tree where every internal node has only one child. Performance of these is same as LinkedList.


 * Tree Traversals :

 * 1) Depth First Search(DFS)
       a) Preorder Traversal
       b) Inorder Traversal
       c) Postorder Traversal
 * 2) Breadth First Search(BFS)/Level Order Traversal
*/

// Class for node creation
class Node{
    int key;
    Node leftChild, rightChild;

    // Used defined constructor
    Node(int newKey){
        this.key = newKey;
        this.leftChild = null;
        this.rightChild = null;
    }
}

public class BinaryTree {
    Node root;
    // constructor
    BinaryTree(){
        root = null;
    }

    // Preorder Traversal : root, left, right
    void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.key + " ");   // root
        preOrder(root.leftChild);   // left
        preOrder(root.rightChild);  // right
    }

    // Inorder Traversal : left, root, right
    void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.leftChild);    // left
        System.out.print(root.key + " ");   // root
        inOrder(root.rightChild);   // right
    }

    // Postorder Traversal : left, right, root
    void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.leftChild);  // left
        postOrder(root.rightChild);     // right
        System.out.print(root.key + " ");   // root
    }

    // display methods for preorder, inorder, postorder
    void preorder(){
        preOrder(root);
    }

    void inorder(){
        inOrder(root);
    }

    void postorder(){
        postOrder(root);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.leftChild = new Node(1);
        binaryTree.root.rightChild = new Node(2);
        binaryTree.root.leftChild.leftChild = new Node(3);
        binaryTree.root.leftChild.rightChild = new Node(4);
        binaryTree.root.rightChild.leftChild = new Node(5);
        binaryTree.root.rightChild.rightChild = new Node(6);

        System.out.println("Preorder of the tree is : ");
        binaryTree.preorder();

        System.out.println();

        System.out.println("Inorder of the tree is : ");
        binaryTree.inorder();

        System.out.println();

        System.out.println("Postorder of the tree is : ");
        binaryTree.postorder();
    }
}
