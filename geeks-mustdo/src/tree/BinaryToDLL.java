package tree;
/*
https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1

Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place.
The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL.
The order of nodes in DLL must be same as Inorder of the given Binary Tree.
The first node of Inorder traversal (left most node in BT) must be head node of the DLL.

Example:
Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
3 1 2
2 1 3
40 20 60 10 30
30 10 60 20 40
 */
public class BinaryToDLL {

    TreeNode head, prev;
    TreeNode bToDLL(TreeNode root) // consider left and right as backword
    {
        inorderTraversal(root);
//
//        while(head != null) {
//            System.out.println(head.data);
//            head = head.right;
//        }

        return head;
        //  Your code here
    }

    private void inorderTraversal(TreeNode root) {
        if(root.left != null) {
            inorderTraversal(root.left);
        }
        if(head == null) {
            head = root;
            prev = head;
        }
        else {
            prev.right =root;
            root.left = prev;
            prev = root;
        }

        if(root.right != null) {
            inorderTraversal(root.right);
        }
    }

}
