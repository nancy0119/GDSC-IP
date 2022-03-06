// Link - https://practice.geeksforgeeks.org/problems/root-to-leaf-paths/1/
import java.util.*;
class rootToLeafPath{
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }
    
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here
        ArrayList<Integer> smallAns = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        rootToLeaf(smallAns, ans, root);
        return ans;
    }
    
    public void rootToLeaf(ArrayList<Integer> smallAns, ArrayList<ArrayList<Integer>> ans, Node node){
        if(node == null)return;
        if(node.left == null && node.right == null){
            ArrayList<Integer> base = new ArrayList<>(smallAns);
            base.add(node.data);
            ans.add(base);
            return;
        }
        smallAns.add(node.data);
        rootToLeaf(smallAns, ans, node.left);
        rootToLeaf(smallAns, ans, node.right);
        smallAns.remove(smallAns.size() - 1);
    }
}