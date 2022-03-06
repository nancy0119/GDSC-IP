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
//  
    public static void kDisDown(TreeNode root, int time, TreeNode blockNode, ArrayList<ArrayList<Integer>> ans, HashSet<Integer> waterSet){
        if(root == null || root == blockNode || waterSet.contains(root.val))return;
        if(time == ans.size())ans.add(new ArrayList<Integer>());
        ans.get(time).add(root.val); 
        kDisDown(root.left, time + 1, blockNode, ans, waterSet);
        kDisDown(root.right, time + 1, blockNode, ans, waterSet);
    }

    public static int find(TreeNode root, int target, ArrayList<ArrayList<Integer>> ans, HashSet<Integer> waterSet){
        // -1 target not found
        // -2 target found but is in waterSet
        if(root == null)return -1;
        if(root == target){
            if(waterSet.contains(root.val))return -2;
            kDisDown(root, 0, null, ans);
            return 1;
        }
        int findL = find(root.left, target, ans);
        if(findL > 0){
            if(waterSet.contains(root.val))return -2;
            kDisDown(root, findL, root.left, ans, waterSet);
            return findL + 1;
        }
        if(findL == -2)return -2;

        int findR = find(root.right, target, ans, waterSet);
        if(findR > 0){
            if(waterSet.contains(root.val))return -2;
            kDisDown(root, findR, root.right, ans, waterSet);
            return findR + 1;
        }
        if(findL == -2)return -2;
        
        return -1;
    }
      public static ArrayList<ArrayList<Integer>> burnTree(TreeNode root, int target, HashSet<Integer> waterSet) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        find(root, target, ans, waterSet);
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