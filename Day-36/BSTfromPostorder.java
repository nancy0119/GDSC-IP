// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/construct-bst-from-postorder-traversal/ojquestion

import java.util.Scanner;

public class BSTfromPostorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode bstFromPostorderHelper(int []postorder, int lr, int rr, int[]idx){
        if(idx[0] < 0 || postorder[idx[0]] < lr || postorder[idx[0]] > rr)return null;
        TreeNode root = new TreeNode(postorder[idx[0]]);
        idx[0]--;
        root.right = bstFromPostorderHelper(postorder, root.val, rr, idx);
        root.left = bstFromPostorderHelper(postorder, lr, root.val, idx);
        return root;
    }
    public static TreeNode bstFromPostorder(int[] postorder) {
        int idx [] = {postorder.length - 1};
        return bstFromPostorderHelper(postorder, (int)1e-9, (int)1e9, idx);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
