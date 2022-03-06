// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/in-order-morris-traversal-in-binarytree/ojquestion
import java.util.*;
public class morrisTraversal {
    public class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode getRightMost(TreeNode cLeft, TreeNode curr){
        while(cLeft.right != null && cLeft.right != curr)cLeft = cLeft.right;
        return cLeft;
    }
    public static ArrayList<Integer> morrisPreorderTraversal(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode rm = getRightMost(curr.left, curr);
                if(rm.right == null){//thread creation
                    rm.right = curr;
                    curr = curr.left;
                }
                else{//thread removal
                    ans.add(curr.val);
                    rm.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
    public static void main(String[]args){

    }
}
