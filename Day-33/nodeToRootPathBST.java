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
  public static TreeNode max(TreeNode root){
    TreeNode temp = root;
    while(temp.right != null)temp = temp.right;
    return temp;
  }
  public static TreeNode min(TreeNode root){
    TreeNode temp = root;
    while(temp.left != null)temp = temp.left;
    return temp;
  }
  public static boolean find(TreeNode root, TreeNode target){
    if(root == null)return false;
    TreeNode temp = root;
    while(temp != null){
      if(temp == target)return true;
      else if(temp.val > target.val)temp = temp.left;
      else temp = temp.right;
    }
    return false;
}
  public static boolean nodeToRoot1(TreeNode node, int data, ArrayList<TreeNode> arr){
    if(node == null)return false;
    TreeNode temp = root;
    while(temp != null){
        arr.add(temp);
        if(temp == target)return true;
        else if(temp.val > data)temp = temp.left;
        else temp = temp.right;
    }
    return false;
}
public static ArrayList<TreeNode> nodeToRoot2(TreeNode node, int data){
    ArrayList<TreeNode> ans = new ArrayList<>();
    if(node == null)return ans;
    TreeNode temp = node;
    while(temp != null){
        ans.add(temp);
        if(temp.val == data)return ans;
        else if(temp.val > data)temp = temp.left;
        else temp = temp.right;
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