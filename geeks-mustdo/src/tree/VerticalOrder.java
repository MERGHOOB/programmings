package tree;

import java.util.*;

public class VerticalOrder {

    void verticalOrder(TreeNode root) {

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(); // sorted map required to print:

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Map<TreeNode, Integer> hashMap = new HashMap<>(); // to store horizotal distance
        hashMap.put(root, 0);

        while (!queue.isEmpty()) {
            TreeNode remove = queue.remove();
            int hd = hashMap.get(remove);
            if (!treeMap.containsKey(hd)) {
                treeMap.put(hd, new ArrayList<>());
            }

            treeMap.get(hd).add(remove.data);
            if (remove.left != null) {
                queue.add(remove.left);
                hashMap.put(remove.left, hd - 1);
            }

            if (remove.right != null) {
                queue.add(remove.right);
                hashMap.put(remove.right, hd + 1);
            }
        }

        /*
        print vertical order
         */

        treeMap.values().forEach(list ->
                list.forEach(e -> System.out.print(e + " ")));
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

        new VerticalOrder().verticalOrder(root);
    }
}
