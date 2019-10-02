package tree;

public class TreeNode {
   int horizontalDistance;
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val, TreeNode left, TreeNode right, int horizontalDistance) {
        this.data = val;
        this.left = left;
        this.right = right;
        this.horizontalDistance = horizontalDistance;
    }
    public TreeNode(int val) {
        this.data = val;
        left = right = null;
        horizontalDistance = Integer.MIN_VALUE;
    }

}
