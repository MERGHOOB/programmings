package tree;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode(int val) {
        this.data = val;
        left = right = null;
    }

}
