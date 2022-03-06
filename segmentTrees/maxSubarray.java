import java.io.*;
import java.util.*;

public class maxSubarray {

  public static void main(String[] args) throws Exception {
    // BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int nums[] = new int[n];
    for(int i = 0; i < n; i++)nums[i] = s.nextInt();
    int q = s.nextInt();
    int [][] queries = new int[q][3];
    for(int i = 0; i < q; i++){
      for(int j = 0; j < 3; j++)queries[i][j] = s.nextInt();
    }

    st = new Node[4 * nums.length + 1];
    for (int i = 0; i < st.length; i++) st[i] = new Node();
    buildMain(nums);
    
    for(int i = 0; i < q; i++){
    if(queries[i][0] == 1){
      System.out.println(query(0, nums.length - 1, 1, queries[i][1], queries[i][2]).maxSum);
    }
    else{
      update(0, nums.length - 1, 1, queries[i][1], queries[i][2]);
    }
    }

  }
    public static Node[] st;
    public static class Node{
        int totalSum;
        int maxSum;
        int maxPrefix;
        int maxSuffix;
        Node(){
            totalSum = Integer.MIN_VALUE;
            maxSum = Integer.MIN_VALUE;
            maxPrefix =  Integer.MIN_VALUE;
            maxSuffix = Integer.MIN_VALUE;
        }
    }
    public static void buildMain(int []nums){
        build(nums, 0, nums.length - 1, 1);
        return;
    }
    public static void build(int [] nums, int start, int end, int treenode){
        if(start > end)return;
        if(start == end){
            st[treenode] = new Node();
            st[treenode].totalSum = nums[start];
            // if(nums[start] > 0){
                st[treenode].maxPrefix = nums[start];
                st[treenode].maxSuffix = nums[start];
                st[treenode].maxSum = nums[start];
            // }
            return;
        }
        
        int mid = start + (end - start) / 2;
        build(nums, start, mid, 2 * treenode);
        build(nums, mid + 1, end, 2 * treenode + 1);
        Node left = st[2 * treenode];
        Node right = st[2 * treenode + 1];
        st[treenode].totalSum = left.totalSum + right.totalSum;
        st[treenode].maxPrefix = Math.max(left.totalSum + right.maxPrefix, left.maxPrefix);
        st[treenode].maxSuffix = Math.max(right.totalSum + left.maxSuffix, right.maxSuffix);
        st[treenode].maxSum = Math.max(left.maxSuffix + right.maxPrefix, Math.max(left.maxSum, right.maxSum));
    }
    public static void update(int start, int end, int treenode, int idx, int val){
        if(idx < start || idx > end)return;
        if(start == end){
            st[treenode].totalSum = val;
            st[treenode].maxPrefix = val;
            st[treenode].maxSuffix = val;
            st[treenode].maxSum = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if(idx <= mid)update(start, mid, 2 * treenode, idx, val);
        else update(mid + 1, end, 2 * treenode + 1, idx, val);
        Node left = st[2 * treenode];
        Node right = st[2 * treenode + 1];
        st[treenode].totalSum = left.totalSum + right.totalSum;
        st[treenode].maxPrefix = Math.max(left.totalSum + right.maxPrefix, left.maxPrefix);
        st[treenode].maxSuffix = Math.max(right.totalSum + left.maxSuffix, right.maxSuffix);
        st[treenode].maxSum = Math.max(left.maxSuffix + right.maxPrefix, Math.max(left.maxSum, right.maxSum));
    }
    public static Node query(int start, int end, int treeNode, int l, int r){
        Node ans = new Node();
        if(l > end || r < start)return ans;
        if(l <= start && r >= end)return st[treeNode];
        int mid = start + (end - start ) / 2;
        if (r <= mid)return query(start, mid, 2 * treeNode, l, r);
        if (l > mid)return query(mid + 1, end, 2 * treeNode + 1,  l, r);
        Node left = query(start, mid, 2 * treeNode, l, r);
        Node right = query(mid + 1, end, 2 * treeNode + 1, l, r);
        ans.totalSum = left.totalSum + right.totalSum;
        ans.maxPrefix = Math.max(left.totalSum + right.maxPrefix, left.maxPrefix);
        ans.maxSuffix = Math.max(right.totalSum + left.maxSuffix, right.maxSuffix);
        ans.maxSum = Math.max(left.maxSuffix + right.maxPrefix, Math.max(left.maxSum, right.maxSum));
        return ans;
    }
}