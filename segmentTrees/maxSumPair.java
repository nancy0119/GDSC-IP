import java.util.*;
public class maxSumPair{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < nums.length; i++)nums[i] = s.nextInt();
        int q = s.nextInt();
        int [][] queries = new int[q][3];
        for(int i = 0; i < q; i++){
        for(int j = 0; j < 3; j++)queries[i][j] = s.nextInt();
        }

        buildMain(nums);

        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == 1){
				Node temp = query(0, nums.length - 1, 1, queries[i][1], queries[i][2]);
				System.out.println(temp.maxSum + temp.secMaxSum);
            }
            else update(0, nums.length - 1, 1, queries[i][1], queries[i][2]);
        }
    }
    public static ArrayList<Integer> maximumSum(int[] nums, int[][] queries)
    {
        // Write your code here.
        buildMain(nums);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == 1){
				Node temp = query(0, nums.length - 1, 1, queries[i][1], queries[i][2]);
				ans.add(temp.maxSum + temp.secMaxSum);
            }
            else update(0, nums.length - 1, 1, queries[i][1], queries[i][2]);
        }
        return ans;
    }
    public static Node[] st;
    public static class Node{
        int secMaxSum;
        int maxSum;
        Node(){
            secMaxSum = 0;
            maxSum = 0;
        }
    }
    public static void buildMain(int []nums){
        st = new Node[4 * nums.length + 1];
        for (int i = 0; i < st.length; i++)st[i] = new Node();
        build(nums, 0, nums.length - 1, 1);
        return;
    }
    public static void build(int [] nums, int start, int end, int treenode){
        if(start == end){
            st[treenode].maxSum = nums[start];
            st[treenode].secMaxSum = Integer.MIN_VALUE;
            return;
        }
        int mid = start + (end - start) / 2;
        build(nums, start, mid, 2 * treenode);
        build(nums, mid + 1, end, 2 * treenode + 1);
        Node left = st[2 * treenode];
        Node right = st[2 * treenode + 1];
        st[treenode].maxSum = Math.max(left.maxSum, right.maxSum);
        st[treenode].secMaxSum = Math.min(Math.max(left.maxSum, right.secMaxSum), Math.max(left.secMaxSum, right.maxSum));
        return;
    }
    public static void update(int start, int end, int treenode, int idx, int val){
        if(idx < start || idx > end)return;
        if(start == end){
            st[treenode].maxSum = val;
            st[treenode].secMaxSum = Integer.MIN_VALUE;
            return;
        }
        int mid = start + (end - start) / 2;
        if(idx <= mid)update(start, mid, 2 * treenode, idx, val);
        else update(mid + 1, end, 2 * treenode + 1, idx, val);
        Node left = st[2 * treenode];
        Node right = st[2 * treenode + 1];
        st[treenode].maxSum = Math.max(left.maxSum, right.maxSum);
        st[treenode].secMaxSum = Math.min(Math.max(left.maxSum, right.secMaxSum), Math.max(left.secMaxSum, right.maxSum));
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
        ans.maxSum = Math.max(left.maxSum, right.maxSum);
        ans.secMaxSum = Math.min(Math.max(left.maxSum, right.secMaxSum), Math.max(left.secMaxSum, right.maxSum));
        return ans;
    }
}