package tree;

public class BSTCheck {


    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int minValue, int maxValue) {

        if (root == null) {
            return true;
        }
        if (root.data < minValue || root.data > maxValue) {
            return false;
        }

        return isBST(root.left, minValue, root.data - 1) &&
                isBST(root.right, root.data + 1, maxValue);


    }

    private static TreeNode prev = null;

    private boolean isBSTWithInOrderTraversal(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (!isBSTWithInOrderTraversal(root.left)) {
            return false;
        }
        if (prev != null &&
                root.data <= prev.data) {
            return false;
        }
        prev = root;
        return isBSTWithInOrderTraversal(root.right);
    }


    public static void main(String[] args) {
        //10 20 L 10 30 R 20 40 L 20 60 R
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(2);
        root.left.left.left.right = new TreeNode(3);
//        root.left = new TreeNode(20);
//        root.left.left = new TreeNode(40);
//        root.left.right = new TreeNode(50);
//        root.left.left.right = new TreeNode(80);
//        root.right = new TreeNode(30);
//        root.right.left = new TreeNode(60);
//        root.right.right = new TreeNode(70);
//
//        boolean bst = new BSTCheck().isBST(root);
//        System.out.println(bst);
//        System.out.println(new BSTCheck().isBSTWithInOrderTraversal(root));


        root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.left.right.right.left = new TreeNode(9);
        root.left.right.right.right = new TreeNode(17);
        root.left.right.right.right.left = new TreeNode(8);
        root.left.right.right.right.right = new TreeNode(9);
        System.out.println("Bottom view of the given binary tree:");


        System.out.println("Right view of the given binary tree:");
    }
}
