// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/node-to-root-path-binary-tree/ojquestion

import java.util.*;

public class nodeToRootPath {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  public static boolean nodeToRoot(TreeNode node, int data, ArrayList<TreeNode> arr){
      if(node == null)return false;
      if(node.val == data){
          arr.add(node);
          return true;
      }
      boolean bool = nodeToRoot(node.left, data, arr) || nodeToRoot(node.right, data, arr);
      if(bool)arr.add(node);
      return bool;
  }
  public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
    // write your code here
    // M1
    // ArrayList<TreeNode> arr = new ArrayList<>();
    // boolean bool = nodeToRoot(node, data, arr);
    // return arr;
    // M2
    ArrayList<TreeNode> ans = new ArrayList<>();
    if(node == null)return ans;
    if(node.val == data){
        ans.add(node);
        return ans;
    }
    ArrayList<TreeNode> left = nodeToRootPath(node.left, data);
    if(left.size() > 0){
        left.add(node);
        return left;
    }
    
    ArrayList<TreeNode> right = nodeToRootPath(node.right, data);
    if(right.size() > 0){
        right.add(node);
        return right;
    }
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

    int data = scn.nextInt();
    ArrayList<TreeNode> ans = nodeToRootPath(root, data);
    if (ans.size() == 0)  System.out.println();
    for (TreeNode node : ans)
      System.out.print(node.val + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}