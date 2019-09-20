package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

 */
public class LC637_AverageOfLevelsInBinaryTree {


    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            double sum = 0;
            for (int i = 0; i < size; i++) {

                TreeNode treeNode = queue.poll();
                sum += treeNode.val;

                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.right);
                }
            }
            result.add(sum / size);

        }


        return result;
    }
}

class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
