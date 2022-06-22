package FreeKaTree;
/**
 * BFS(Breadth First Search) is also known as Level Order Traversal.
 * In Level Order Traversal, we traverse the tree level by level.
 * In this Traversal, we use Queue Data Structure for the traversal purpose.
 */
import java.util.*;

public class BFS_LevelOrderTraversal extends BinaryTree{
    Node root;
    BFS_LevelOrderTraversal(){
        this.root = null;
    }

    public static List<List<Integer>> BFS(Node root){
        Queue<Node> queue = new LinkedList<>();     // for traversal
        List<List<Integer>> list = new ArrayList<>();      // for storing nodes level wise

        // edge case : if the tree has no node then return empty list
        if(root == null){
            return list;
        }
        // otherwise append the root node
        queue.offer(root);


        // traverse until queue has an element
        while (!queue.isEmpty()){

            // Temporary list for storing nodes present at same level
            List<Integer> subList = new ArrayList<>();

            // storing the number of nodes present at particular node
            int levelOfNodes = queue.size();


            // run till number of nodes at that level
            for(int i=0 ; i<levelOfNodes ; i++){

                // if left child is present then append it
                if(queue.peek().leftChild != null){
                    queue.offer(queue.peek().leftChild);
                }

                // if right child is present then append it
                if(queue.peek().rightChild != null){
                    queue.offer(queue.peek().rightChild);
                }

                // at last add the nodes present at the previous level in to the temporary list
                subList.add(queue.poll().key);
            }

            // add temporary list to the final list
            list.add(subList);
        }
        return list;    // return final list
    }

    public static void main(String[] args) {
        BFS_LevelOrderTraversal tree = new BFS_LevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);
        tree.root.rightChild.leftChild = new Node(6);
        tree.root.rightChild.rightChild = new Node(7);

        List<List<Integer>> levelOrderedList = BFS(tree.root);
        System.out.println("BFS or Level Order Traversal of the given Tree is : ");
        System.out.println(levelOrderedList);
    }
}
