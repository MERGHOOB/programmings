package tree;

import sun.reflect.generics.tree.Tree;

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

    boolean isMirror(TreeNode root) {
        if(root != null) {
            return isMirror(root.left, root.right);
        }
        return false;
    }
    boolean isMirror(TreeNode left, TreeNode right)
    {

          if(left == null && right == null) {
              return true;
          }
          if(left == null || right == null) {
              return false;
          }
          return left.data == right.data && isMirror(left.left, right.right) && isMirror(left.right, right.left);

        //Your code here
    }
}
