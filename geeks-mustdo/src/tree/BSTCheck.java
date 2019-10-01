package tree;

public class BSTCheck {


    public boolean isBST(TreeNode root) {
       return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int minValue, int maxValue) {

        if(root == null) {
            return true;
        }
        if(root.data <minValue || root.data > maxValue) {
            return false;
        }

        return isBST(root.left, minValue, root.data -1) &&
                    isBST(root.right, root.data+1, maxValue);


    }


    public static void main(String[] args) {
        //10 20 L 10 30 R 20 40 L 20 60 R
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left = new TreeNode(30);
//        root.left = new TreeNode(20);
//        root.left.left = new TreeNode(40);
//        root.left.right = new TreeNode(50);
//        root.left.left.right = new TreeNode(80);
//        root.right = new TreeNode(30);
//        root.right.left = new TreeNode(60);
//        root.right.right = new TreeNode(70);

        boolean bst = new BSTCheck().isBST(root);
        System.out.println(bst);
    }
}
