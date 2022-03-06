// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/bst-iterator/ojquestion
// https://leetcode.com/problems/binary-search-tree-iterator/

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
// M1 - using stack
// class BSTIterator {
//     private LinkedList<TreeNode> st = new LinkedList<>();
//     public BSTIterator(TreeNode root) {
//         insertAllLeft(root, st);
//     }
//     private void insertAllLeft(TreeNode node, LinkedList<TreeNode> st){
//         while(node != null){
//             st.addFirst(node);
//             node = node.left;
//         }
//     }
//     public int next() {
//         TreeNode temp = st.removeFirst();
//         insertAllLeft(temp.right, st);
//         return temp.val;
//     }
    
//     public boolean hasNext() {
//         return st.size() != 0;
//     }
// }

// M2 - Morris Traversal
class BSTIterator {
    private TreeNode curr = null;
    public BSTIterator(TreeNode root) {
        curr = root;
    }
    private TreeNode getRightMost(TreeNode cLeft, TreeNode curr){
        while(cLeft.right != null && cLeft.right != curr)cLeft = cLeft.right;
        return cLeft;
    }
    public int next() {
        int ans = -1;
        while(ans == -1){
            if(curr.left == null){
                ans = curr.val;
                curr = curr.right;
                break;
            }
            else{
                TreeNode rm = getRightMost(curr.left, curr);
                if(rm.right == null){
                    rm.right = curr;
                    curr = curr.left;
                }
                else{
                    ans = curr.val;
                    rm.right = null;
                    curr = curr.right;
                    break;
                }
            }
        }
        return ans;
    }
    
    public boolean hasNext() {
        return curr != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */