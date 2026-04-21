package 树;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//从前序和中序遍历序列中构造二叉树
public class BuildTree {

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        BuildTree buildTree = new BuildTree();
        TreeNode root = buildTree.buildTree(preorder, inorder);
        List<List<Integer>> list = TreeNode.level(root);
        System.out.println(list);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length, inLen = inorder.length;
//        Map<Integer, Integer> inMap = new HashMap<>();
//        for (int i=0; i<inLen; i++){inMap.put(inorder[i], i);}
        Map<Integer, Integer> inMap = IntStream.range(0, inorder.length - 1)
                .boxed().collect(Collectors.toMap(
                i -> inorder[i],
                i -> i,
                (v1, v2) -> v1));
        return build(preorder, 0, preLen-1, inorder, 0, inLen-1, inMap);
    }

    private TreeNode build(int[] preorder, int pStart, int pEnd,
                           int[] inorder, int iStart, int iEnd,
                           Map<Integer, Integer> inMap) {
        if (pStart > pEnd || iStart > iEnd){
            return null; //尾节点
        }

        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal); //根节点[先序的第一个节点]
        int rootIndex = inMap.get(rootVal);
        int leftSize = rootIndex - iStart;     //左分支的长度

        root.left = build(preorder, pStart+1, pStart+leftSize,
                inorder, iStart, rootIndex-1, inMap);
        root.right = build(preorder, pStart+leftSize+1, pEnd,
                inorder,rootIndex+1, iEnd, inMap);

        return root;
    }
}
