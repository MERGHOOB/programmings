package tree;
/*

https://leetcode.com/problems/minimum-distance-between-bst-nodes/
Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \
    1   3

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.
 */
public class LC783_MinimumDistanceBetweenBSTNodes {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

        private static int[] arr= new int[100];
        private static int index = 0;
        public int minDiffInBST(TreeNode root) {
            index = 0; // for many test case, this can cause a problem if not re-valued here as 0;
            inorder(root);
            int min = Integer.MAX_VALUE;
            for(int i = 1; i<index; i++) {
                min = Integer.min(min, arr[i] - arr[i-1]);
            }

            return min;
        }

        public void inorder(TreeNode root) {

            if(root.left != null) {
                inorder(root.left);
            }
            arr[index++] = root.val;
            if(root.right!=null) {
                inorder(root.right);
            }

        }
}
