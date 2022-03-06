// Link - https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class kthsmallestBST {
    public void insertAllLeft(TreeNode curr, LinkedList<TreeNode> st){
        while(curr != null){
            st.addFirst(curr);
            curr = curr.left;
        }
    }
    public int kthSmallest(TreeNode curr, int k) {
        LinkedList<TreeNode> st = new LinkedList<>();
        TreeNode root = curr;
        int ans = 0;
        insertAllLeft(root, st);
        while(st.size() != 0){
            TreeNode temp = st.removeFirst();
            if(--k == 0)ans = temp.val;
            insertAllLeft(temp.right, st);
        }
        return ans;
    }
}