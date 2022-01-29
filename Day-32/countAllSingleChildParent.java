// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/count-all-single-child-parent-in-binary-tree/ojquestion

import java.util.*;

public class countAllSingleChildParent {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static int countExactlyOneChild(TreeNode root) {
      int count = 0;
      if(root == null)return 0;
      if((root.right == null && root.left != null) || (root.right != null && root.left == null))count++;
    int left = countExactlyOneChild(root.left);
    int right = countExactlyOneChild(root.right);
    return count + left + right;
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

    System.out.println(countExactlyOneChild(root));
  }

  public static void main(String[] args) {
    solve();
  }
}