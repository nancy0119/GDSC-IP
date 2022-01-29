// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/all-nodes-distance-k-in-binarytree/ojquestion

import java.util.*;

public class allNodesDistanceK {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
//   
        public static ArrayList<TreeNode> nodeToRootPath(TreeNode root, int target){
        if(root == null)return new ArrayList<TreeNode>();
        if(root.val == target){
            ArrayList<TreeNode> ans = new ArrayList<>();
            ans.add(root);
            return ans;
        }
        ArrayList<TreeNode> left = nodeToRootPath(root.left, target);
        if(left.size() > 0){
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right = nodeToRootPath(root.right, target);
        if(right.size() > 0){
            right.add(root);
            return right;
        }
        return new ArrayList<TreeNode>();
    }
    public static List<Integer> kDisDown(TreeNode root, int k, TreeNode exc){
        if(root == null || root == exc)return new ArrayList<Integer>();
        if(k == 0){
            List<Integer> ans  =new ArrayList<>();
            ans.add(root.val);
            return ans;
        }
        List<Integer> ans  =new ArrayList<>();
        ans.addAll(kDisDown(root.left, k - 1, exc));
        ans.addAll(kDisDown(root.right, k - 1, exc));
        return ans;
    }
    public int find(TreeNode root, TreeNode target, List<Integer> ans, int k){
        if(root == null)return -1;
        if(root == target){
            ans.addAll(kDisDown(root, k, null));
            return 1;
        }
        int findL = find(root.left, target, ans, k);
        if(findL != -1){
            ans.addAll(kDisDown(root, k - findL, root.left));
            return findL + 1;
        }
        int findR = find(root.right, target, ans, k);
        if(findR != -1){
            ans.addAll(kDisDown(root, k - findR, root.right));
            return findR + 1;
        }
        return -1;
    }
      public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        // M1
        ArrayList<TreeNode> path = nodeToRootPath(root, target);
        ans.addAll(kDisDown(path.get(0), k, null));
        for(int i = 1; i <= Math.min(k, path.size() - 1); i++){
            ans.addAll(kDisDown(path.get(i), k - i, path.get(i - 1)));
        }
        // M2
        find(root, target, ans, k);
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
    int target = scn.nextInt();
    int k = scn.nextInt();

    ArrayList<Integer> ans = distanceK(root, target, k);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.println(ele + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}