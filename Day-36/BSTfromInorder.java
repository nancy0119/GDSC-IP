// Link - https://nados.io/question/construct-bst-from-inorder-traversal
import java.util.Scanner;

public class BSTfromInorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode construct_helper(int[] inOrder, int ss, int se){
        if(ss > se)return null;
        int mid = (ss + se) / 2;
        TreeNode root = new TreeNode(inOrder[mid]);
        root.left = construct_helper(inOrder, ss, mid - 1);
        root.right = construct_helper(inOrder, mid + 1, se);
        return root;
    }
    public static TreeNode constructFromInOrder(int[] inOrder) {
        return construct_helper(inOrder, 0, inOrder.length - 1);
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
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = constructFromInOrder(in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}