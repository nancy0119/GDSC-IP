// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/all-single-child-parent-in-binary-tree/ojquestion

import java.util.*;

public class allSingleChildParent {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  public static void exactlyOne(TreeNode root, ArrayList<Integer> ans){
      if(root == null || (root.right == null && root.left == null))return;
      if(root.left == null || root.right == null)ans.add(root.val);
      exactlyOne(root.left, ans);
      exactlyOne(root.right, ans);
  }
  public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
    //   M1
    // ArrayList<Integer> ans = new ArrayList<>();
    // exactlyOne(root, ans);
    // return ans;
    // M2
      ArrayList<Integer> ans = new ArrayList<>();
      if(root == null)return ans;
      if((root.right == null && root.left != null) || (root.right != null && root.left == null))ans.add(root.val);
    ArrayList<Integer> left = exactlyOneChild(root.left);
    ArrayList<Integer> right = exactlyOneChild(root.right);
    ans.addAll(left);
    ans.addAll(right);
    return ans;
  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);

    ArrayList<Integer> ans = exactlyOneChild(root);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.print(ele + " ");
  }

  public static void main(String[] args) {
    solve();
  }
}