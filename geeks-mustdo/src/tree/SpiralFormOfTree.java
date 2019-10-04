package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralFormOfTree {

    void printSpiral(TreeNode node)
    {
        if(node == null) {
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);

        while ( !queue.isEmpty() || !stack.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeNode remove = queue.remove();
                System.out.print(remove.data + " ");
                if(remove.left != null) stack.add(remove.left);
                if(remove.right!=null) stack.add(remove.right);
            }

            while (!stack.isEmpty()) {
                TreeNode remove = stack.pop();
                System.out.print(remove.data + " ");
                if(remove.right!=null) queue.addFirst(remove.right);
                if(remove.left != null) queue.addFirst(remove.left);
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        new SpiralFormOfTree().printSpiral(root);
    }
}
