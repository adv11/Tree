package FreeKaTree;

import java.util.*;
/**
 * LeetCode hard : */
class Tuple{
    TreeNode node;  // node's val
    int row, col;   // row -> level, col -> vertical lines
    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
public class VerticalOrderTraversal extends TreeNode{
    public static List<List<Integer>> verticalOrderTraversal(TreeNode root){
        // Data structure for storing traversals
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // Queue for BFS Traversal
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            // if for vertical, TreeMap doesn't exist so create one
            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }

            // if for leaves, PriorityQueue doesn't exist so create one
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.data);

            // for left child : vertical decrease by 1 and level increase by 1
            if(node.left != null){
                queue.offer(new Tuple(node.left, x-1, y+1));
            }

            // for right child : both vertical and level increase by 1
            if(node.right != null){
                queue.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()){
                list.get(list.size() - 1).add(nodes.poll());
            }
        }
        return list;
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

        List<List<Integer>> result = verticalOrderTraversal(root);
        System.out.println("Vertical Order Traversal:");
        System.out.println(result);
    }
}
