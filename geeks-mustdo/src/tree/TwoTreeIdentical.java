package tree;

public class TwoTreeIdentical {


    boolean isIdentical(TreeNode root1, TreeNode root2)
    {

        if(root1 == null && root2 == null) {
            return true;
        }
        else if((root1 == null || root2 == null) ) {
            return false;
        }
        else {
            if(root1.data !=root2.data) {
                return  false;
            }

            return isIdentical(root1.left, root2.left) &&
                        isIdentical(root1.right, root1.right);
        }

        //Your code here
    }
}
