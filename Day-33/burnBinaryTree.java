// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/burning-tree-/ojquestion

// Link - https://practice.geeksforgeeks.org/problems/burning-tree/1

import java.util.*;

public class burnBinaryTree {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  static int ans = 0;
    public static void kDisDown(TreeNode root, int time, TreeNode blockNode){
        if(root == null || root == blockNode)return;
        ans = Math.max(time, ans);
        kDisDown(root.left, time + 1, blockNode);
        kDisDown(root.right, time + 1, blockNode);
    }

    public static int find(TreeNode root, int target){
        if(root == null)return -1;
        if(root.val == target){
            kDisDown(root, 0, null);
            return 1;
        }
        int findL = find(root.left, target);
        if(findL != -1){
            kDisDown(root, findL, root.left);
            return findL + 1;
        }
        int findR = find(root.right, target);
        if(findR != -1){
            kDisDown(root, findR, root.right);
            return findR + 1;
        }
        return -1;
    }
  public static int burningTree(TreeNode root, int fireNode) {
    ans = 0;
    find(root, fireNode);
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
    int fireNode = scn.nextInt();

    int ans = burningTree(root, fireNode);
    System.out.println(ans);

  }

  public static void main(String[] args) {
    solve();
  }
}