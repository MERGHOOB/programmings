package tree;

import java.util.*;

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
public class AllViewsOfBinaryTree {

    private void leftView(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode remove = queue.remove();
            while (remove == null && !queue.isEmpty()) {
                remove = queue.remove();
            }
            if (remove == null) {
                break;
            }
            System.out.print(remove.data + " ");
            int size = queue.size();
            queue.add(remove.left);
            queue.add(remove.right);
            // clean current and take new elements
            while (size > 0 && !queue.isEmpty()) {
                TreeNode removed = queue.remove();
                if (removed != null) {
                    queue.add(removed.left);
                    queue.add(removed.right);
                }
                size--;
            }
        }
        System.out.println();

    }

    private void rightView(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // for sorted values based on distance

        Queue<TreeNode> queue = new LinkedList<>(); // for level order traversal
        queue.add(root);

        Map<TreeNode, Integer> hashMap = new HashMap<>(); // for hd distance
        hashMap.put(root, 0); //consider root as center

        while (!queue.isEmpty()) {
            TreeNode removed = queue.remove();
            if (!treeMap.containsKey(hashMap.get(removed))) {
                treeMap.put(hashMap.get(removed), removed.data);
            }
            if (removed.right != null) {
                queue.add(removed.right);
                hashMap.put(removed.right, hashMap.get(removed) + 1); // increment the height at each level
            }

            if (removed.left != null) {
                queue.add(removed.left);
                hashMap.put(removed.left, hashMap.get(removed) + 1);
            }

        }

        treeMap.values().forEach(e -> {
            System.out.print(e + " ");
        });

    }

    private void bottomView(TreeNode node) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        bottomView(node, 0, queue, treeMap);

        treeMap.values().forEach(e -> {
            System.out.print(e + " ");
        });


    }

    private void bottomView(TreeNode node, int hd, Queue<TreeNode> queue, TreeMap<Integer, Integer> treeMap) {
        if (node == null) {
            return;
        }
        node.horizontalDistance = hd;
        queue.add(node);
// This approach fails as it is like left order traversal. while need a level order traversal
        /*

        bottomView(node.left, hd-1, queue, treeMap);
        bottomView(node.right, hd+1, queue, treeMap);
 */
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();
        hashMap.put(node, hd);
        while (!queue.isEmpty()) {
            TreeNode remove = queue.remove();
            treeMap.put(hashMap.get(remove), remove.data);
            if (remove.left != null) {
                hashMap.put(remove.left, hashMap.get(remove) - 1);
//                remove.left.horizontalDistance = remove.horizontalDistance -1;
                queue.add(remove.left);
            }

            if (remove.right != null) {

                hashMap.put(remove.right, hashMap.get(remove) + 1);
//                remove.right.horizontalDistance = remove.horizontalDistance +1;
                queue.add(remove.right);
            }

        }

    }

    private void topView(TreeNode root) {

        if (root == null) {
            return;
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // for sorted values based on distance

        Queue<TreeNode> queue = new LinkedList<>(); // for level order traversal
        queue.add(root);

        Map<TreeNode, Integer> hashMap = new HashMap<>(); // for hd distance
        hashMap.put(root, 0); //consider root as center

        while (!queue.isEmpty()) {
            TreeNode removed = queue.remove();
            if (!treeMap.containsKey(hashMap.get(removed))) {
                treeMap.put(hashMap.get(removed), removed.data);
            }
            if (removed.left != null) {
                queue.add(removed.left);
                hashMap.put(removed.left, hashMap.get(removed) - 1);
            }
            if (removed.right != null) {
                queue.add(removed.right);
                hashMap.put(removed.right, hashMap.get(removed) + 1);
            }

        }

        treeMap.values().forEach(e -> {
            System.out.print(e + " ");
        });


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

        new AllViewsOfBinaryTree().leftView(root);
    }
}
