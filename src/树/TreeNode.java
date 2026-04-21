package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }

    public static List<List<Integer>> level(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){return list;}

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){queue.offer(node.left);}
                if (node.right != null){queue.offer(node.right);}
            }
            list.add(level);
        }
        return list;
    }

}
