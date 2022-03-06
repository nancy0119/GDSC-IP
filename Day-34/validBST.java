// Link - 1) https://leetcode.com/problems/validate-binary-search-tree/submissions/
// 2) https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/levelup_validate-bst/ojquestion
import java.util.LinkedList;
import java.util.Scanner;

public class validBST {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode getRightMost(TreeNode cLeft, TreeNode curr){
        while(cLeft.right != null && cLeft.right != curr)cLeft = cLeft.right;
        return cLeft;
    }
    public static boolean isValidBST(TreeNode root) {
        long prev = -(long)1e13;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                if(curr.val <= prev)return false;
                else prev = curr.val;
                curr = curr.right;
            }
            else{
                TreeNode rm = getRightMost(curr.left, curr);
                if(rm.right == null){
                    rm.right = curr;
                    curr = curr.left;
                }
                else{
                    if(curr.val <= prev)return false;
                    else prev = curr.val;
                    rm.right = null;
                    curr = curr.right;
                }
            }
        }
        return true;
    }
    public static void insertAllLeft(TreeNode node, LinkedList<TreeNode> st){
        while(node != null){
            st.addFirst(node);
            node = node.left;
        }
    }
    public static boolean isValidBST2(TreeNode root){
        TreeNode curr = root;
        long prev = -(long)1e13;
        LinkedList<TreeNode> st = new LinkedList<>();
        insertAllLeft(curr, st);
        while(st.size() != 0){
            TreeNode temp = st.removeFirst();
            if(prev >= temp.val)return false;
            prev = temp.val;
            insertAllLeft(temp.right, st);            
        }
        return true;
    }
    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        System.out.println(isValidBST(root));
    }

    public static void main(String[] args) {
        solve();
    }
}