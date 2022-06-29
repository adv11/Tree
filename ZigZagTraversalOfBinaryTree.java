package FreeKaTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversalOfBinaryTree extends TreeNode{
    TreeNode root = null;

    public static List<List<Integer>> zigzagTraversal(TreeNode root){
        List<List<Integer>> wrapList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        // edge case
        if(root == null){
            return wrapList;
        }
        queue.offer(root);
        boolean flag = true;

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> subList = new ArrayList<>();

            for(int i=0 ; i<queueSize ; i++){

                // if left child is present then append it
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }

                // if right child is present then append it
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }

                // if flag is true then left to right traversal
                if(flag){
                    subList.add(queue.poll().data);
                }
                // else right to left
                else{
                    subList.add(0, queue.poll().data);
                }
            }

            // after one traversal reverse the value of flag variable
            flag = !flag;
            wrapList.add(subList);
        }
        return wrapList;
    }
    public static void main(String[] args) {
        ZigZagTraversalOfBinaryTree tree = new ZigZagTraversalOfBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.right.left = new TreeNode(8);

        List<List<Integer>> result = zigzagTraversal(tree.root);
        System.out.println("Zig Zag Traversal is : " + result);
    }
}
