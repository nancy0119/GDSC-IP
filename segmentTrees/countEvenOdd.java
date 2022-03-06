import java.io.*;
import java.util.*;
public class countEvenOdd {
public static int []st;
public static void buildMain(int nums[]){
    st = new int[4 * nums.length + 1];
    for(int i = 0; i < st.length; i++)st[i] = 0;
    build(nums, 0, nums.length - 1, 1);
    return;
    }
public static void build(int nums[], int ss, int se, int treeNode){
    if(ss == se){
        st[treeNode] = 0;
        if((nums[ss] % 2) == 0)st[treeNode] = 1;
        return;
    }
    int mid = ss + (se - ss) / 2;
    build(nums, ss, mid, 2 * treeNode);
    build(nums, mid + 1, se, 2 * treeNode + 1);
    st[treeNode] = st[2 * treeNode] + st[2 * treeNode + 1];
}
public static void update(int treeNode, int ss, int se, int idx, int val){
    if(idx < ss || idx > se || ss > se)return;
    if(ss == se){
        if((val % 2) == 0)st[treeNode] = 1;
        else st[treeNode] = 0;
        return;
    }
    int mid = ss + (se - ss) / 2;
    if(idx <= mid)update(2 * treeNode, ss, mid, idx, val);
    else update(2 * treeNode + 1, mid + 1, se, idx, val);
    st[treeNode] = st[2 * treeNode] + st[2 * treeNode + 1];
}
public static int query(int ss, int se, int qs, int qe, int treeNode){
    if(ss > qe || se < qs)return 0;//No overlap
    if(qs <= ss && qe >= se){//Complete overlap
        return st[treeNode];
    }
    int mid = ss + (se - ss) / 2;
    return query(ss, mid, qs, qe, 2 * treeNode) + query(mid + 1, se, qs, qe, 2 * treeNode + 1);
}
  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int nums[] = new int[n];
    for(int i = 0; i < n; i++)nums[i] = s.nextInt();
    int q = s.nextInt();
    int [][] queries = new int[q][3];
    for(int i = 0; i < q; i++){
      for(int j = 0; j < 3; j++)queries[i][j] = s.nextInt();
    }

    buildMain(nums);

    for(int i = 0; i < q; i++){
    if(queries[i][0] == 0){
        update(1, 0, nums.length - 1, queries[i][1], queries[i][2]);
    }
    else if(queries[i][0] == 1){
        System.out.println(query(0, nums.length - 1, queries[i][1], queries[i][2], 1));
      }
    else{
        int even = query(0, nums.length - 1, queries[i][1], queries[i][2], 1);
        System.out.println(queries[i][2] - queries[i][1] + 1 - even);
    }
    }
  }    
}


//     class NodeL{
//         int val;
//         int idx;
//         NodeL(){
//             val = 0;
//             idx = -1;
//         }
//     }
//     public static void build(int [] nums, int start, int end, int treeNode, NodeT[] st){
//         if(start > end)return;
//         if(start == end){
//             if(nums[start] % 2 == 0)st[treeNode].even = 1;
//             else st[treeNode].odd = 1;
//             return;
//         }
//         int mid = start + (end - start) / 2;
//         build(nums, start, mid, 2 * treeNode, st);
//         build(nums, mid + 1, end, 2 * treeNode + 1, st);
//         st[treeNode].even = st[2 * treeNode].even + st[2 * treeNode + 1].even;
//         st[treeNode].odd = st[2 * treeNode].odd + st[2 * treeNode + 1].odd;
//     }
//     public static void lazyUpd(int [] nums, int start, int end, int treeNode, NodeT[]st, NodeL[]lazy){
// 		if(lazy[treeNode].idx != -1){
//             int idx = lazy[treeNode].idx;
//             int val = lazy[treeNode].val;
// 			if(idx >= start && idx <= end){
// 				if(val % 2 == 0){
// 					st[treeNode].even++;
//                     st[treeNode].odd--;
//                 }
//                 else{
// 					st[treeNode].even--;
//                     st[treeNode].odd++;
//                 }
//                 if(start != end){
// 					lazy[2 * treeNode].val = val;
//                     lazy[2 * treeNode].idx = idx;
//                     lazy[2 * treeNode + 1].val = val;
//                     lazy[2 * treeNode + 1].idx = idx;
//                 }
//             }
//             lazy[treeNode].idx = -1;
//             lazy[treeNode].val = 0;
//         }
//     }	
//     public static void update(int [] nums, NodeT[]st, NodeL[] lazy, int ss, int se, int val, int idx, int treeNode){
//         //        No overlap
//         if(idx < ss || idx > se || ss > se)return;
//         lazyUpd(nums, ss, se, treeNode, st, lazy);
//         if(ss == se){
//             if(val % 2 == 0)st[treeNode].even = 1;
//             else st[treeNode].odd = 1;
//             return;
//         }
// //        Complete overlap
//         if(idx >= ss && idx <= se){
// 			if(val % 2 == 0){
// 				st[treeNode].even++;
//                 st[treeNode].odd--;
//             }
//             else{
// 				st[treeNode].even--;
//                 st[treeNode].odd++;
//             }
//             if(ss != se){
// 				lazy[2 * treeNode].val = val;
//                 lazy[2 * treeNode].idx = idx;
//                 lazy[2 * treeNode + 1].val = val;
//                 lazy[2 * treeNode + 1].idx = idx;
//             }
//         }
// 	}
//     public static int query(int[]nums, NodeT[] st, NodeL[] lazy, int treeNode, int qs, int qe, int ss, int se, int type){
// 		lazyUpd(nums, ss, se, treeNode, st, lazy);
//         if(qe < ss || qs > se)return 0;//No overlap
//         if(qs <= ss && qe >= se){//Complete overlap
// 			if(type == 1)return st[treeNode].even;
//             else return st[treeNode].odd;
//         }
//         int mid = ss + (se - ss) / 2;
//         int queryl = query(nums, st, lazy, 2 * treeNode, qs, qe, ss, mid, type);
//         int queryr = query(nums, st, lazy, 2 * treeNode + 1, qs, qe, mid + 1, se, type);
//         return queryl + queryr;
//     }
//     public static List<Integer> solve(int n, int[] arr, int q, int[][] queries) {
//         // Write your code here.
//         NodeT [] st = new NodeT[3 * n];
//         NodeL[] lazy = new NodeL[3 * n];
//         List<Integer> ans = new ArrayList<>();
//         for(int i = 0; i < q; i++){
// 			if(queries[i][0] == 0)update(arr, st, lazy, 0, n - 1, queries[i][2], queries[i][1], 1);
//             else if(queries[i][0] == 1)ans.add(query(arr, st, lazy, 1, queries[i][1], queries[i][2], 0, n - 1, 1));
//             else ans.add(query(arr, st, lazy, 1, queries[i][1], queries[i][2], 0, n - 1, 2));
//         }
//         return ans;
//     }