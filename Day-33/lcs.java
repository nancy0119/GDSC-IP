// Link  - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/lca-of-a-bt/ojquestion
// Link - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

import java.util.*;

public class lcs {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  public static ArrayList<TreeNode> nodeToRootPath(TreeNode root, int node){
        ArrayList<TreeNode> ans = new ArrayList<>();
        if(root == null)return ans;
        if(root.val == node){
            ans.add(root);
            return ans;
        }
        ArrayList<TreeNode> left = nodeToRootPath(root.left, node);
        if(left.size() > 0){
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right = nodeToRootPath(root.right, node);
        if(right.size() > 0){
            right.add(root);
            return right;
        }
        return ans;
    }
    static TreeNode LCA = null;
    public static boolean lca(TreeNode root, int p, int q){
        if(root == null)return false;
        boolean left = lca(root.left, p, q);
        boolean right = lca(root.right, p, q);
        boolean selfPresent = (root.val == p || root.val == q);
        if((left && right) || (selfPresent && right) || (selfPresent && left))
           LCA = root;
        return left || right || selfPresent;
    }
  public static TreeNode lowestCommonAncestor(TreeNode node, int p, int q) {
         // M1
        if(lca(node, p, q))return LCA;
        return null;
        // M2
        // ArrayList<TreeNode> path1 = nodeToRootPath(node, p);
        // ArrayList<TreeNode> path2 = nodeToRootPath(node, q);
        // if(path1.size() == 0 || path2.size() == 0)return null;
        // int idx1 = path1.size() - 1, idx2 = path2.size() - 1;
        // TreeNode ans = null;
        // while(idx1 >= 0 && idx2 >= 0){
        //     if(path1.get(idx1) != path2.get(idx2))return ans;
        //     ans = path1.get(idx1);
        //     idx1--;
        //     idx2--;
        // }
        // return ans;
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

  public static int idx = 0;

  private static TreeNode deserialize(String[] arr) {
    if (idx >= arr.length || arr[idx].equals("null")) {
      idx++;
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
    node.left = deserialize(arr);
    node.right = deserialize(arr);

    return node;
  }

  public static TreeNode deserialize(String str) {
    String[] arr = str.split(" ");
    return deserialize(arr);
  }

  public static void solve() {
    String str = scn.nextLine();
    TreeNode root = deserialize(str);

    int e1 = scn.nextInt();
    int e2 = scn.nextInt();

    TreeNode ans = lowestCommonAncestor(root, e1, e2);
    System.out.println(ans == null ? null : ans.val);
  }

  public static void main(String[] args) {
    solve();
  }
}