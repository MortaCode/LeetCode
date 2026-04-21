package 树;

//二叉树展开为链表-114
public class Flatten {

//    给你二叉树的根结点 root ，请你将它展开为一个单链表：
//    展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
//    展开后的单链表应该与二叉树 先序遍历 顺序相同。


    /**
     * 当前节点
     *      左节点非空
     *      循环：左节点的mostRight
     *      当前节点的右节点， 作为mostRight的right
     *      当前节点的左节点，移动到当前节点的右节点
     *      当前节点的左节点，置NULL
     * 向右移动一位
     */
    public class FlattenBinaryTreeMorris {

        /**
         * Morris遍历方式展开，
         * 核心思想：找到左子树的最右节点，将右子树接到该节点后面
         */
        public void flatten(TreeNode root) {
            TreeNode curr = root;

            while (curr != null) {
                if (curr.left != null) {
                    // 找到左子树的最右节点
                    TreeNode rightmost = curr.left;
                    while (rightmost.right != null) {
                        rightmost = rightmost.right;
                    }

                    // 将当前右子树接到最右节点的右边
                    rightmost.right = curr.right;

                    // 将左子树移到右边
                    curr.right = curr.left;
                    curr.left = null;
                }

                // 继续处理下一个节点
                curr = curr.right;
            }
        }
    }
}
