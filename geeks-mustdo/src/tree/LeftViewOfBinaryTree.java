package tree;

import java.util.LinkedList;
import java.util.Queue;
/*
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

                                          1
                                       /     \
                                     2        3
  View ==>                         /     \    /    \
                                  4     5   6    7
                                   \
                                     8

     Answer: 1, 2, 4, 8
 */
public class LeftViewOfBinaryTree {

    void leftView(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode remove = queue.remove();
            while(remove == null && !queue.isEmpty()) {
                remove = queue.remove();
            }
            if(remove == null) {
                break;
            }
            System.out.print(remove.data + " ");
            int size = queue.size();
            queue.add(remove.left);
            queue.add(remove.right);
            // clean current and take new elements
            while (size >0 && !queue.isEmpty()) {
                TreeNode removed = queue.remove();
                if(removed != null) {
                    queue.add(removed.left);
                    queue.add(removed.right);
                }
                size--;
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {

        //10 20 L 10 30 R 20 40 L 20 60 R
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.left.left.right = new TreeNode(80);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);

        new LeftViewOfBinaryTree().leftView(root);
    }
}
