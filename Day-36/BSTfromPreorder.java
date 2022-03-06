// Link - https://nados.io/question/construct-bst-from-preorder-traversal?zen=true
import java.util.Scanner;

public class BSTfromPreorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode bstToPreHelper(int[] preorder, int lr, int rr, int []idx){
        if(idx[0] >= preorder.length || preorder[idx[0]] < lr || preorder[idx[0]] > rr)return null;
        TreeNode root = new TreeNode(preorder[idx[0]]);
        // we want to keep idx static
        idx[0]++;
        root.left = bstToPreHelper(preorder, lr, root.val, idx);
        root.right = bstToPreHelper(preorder, root.val, rr, idx);
        return root;
    }   
    public static TreeNode bstFromPreorder(int[] preorder) {
        int idx[] = new int[1];
        idx[0] = 0;
        return bstToPreHelper(preorder, (int)1e-9, (int)1e9, idx);
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

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}