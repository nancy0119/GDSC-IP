import java.util.*;
public class sumSq {
    public static class NodeT{
        int sqSum;
        int sum;
        NodeT(){
            sqSum = 0;
            sum = 0;
        }
    }
    public static class NodeL{  
        int val;
        int type;
        NodeL(){
            val = 0;
            type = 0;
        }
    }
    public static void build(int [] nums, NodeT []st, int start, int end, int treeNode){
        if(start == end){
            st[treeNode].sqSum = nums[start] * nums[start];
            st[treeNode].sum = nums[start];
            return;
        }
        int mid = (start) + (end - start) / 2;
        build(nums, st, start, mid, 2 * treeNode);
        build(nums, st, mid + 1, end, 2 * treeNode + 1);
        st[treeNode].sqSum = st[2* treeNode].sqSum + st[2 * treeNode + 1].sqSum;
        st[treeNode].sum = st[2* treeNode].sum + st[2 * treeNode + 1].sum;
        return;
    }
    public static void lazyUpd(int [] nums, NodeT[] st, NodeL[] lazy, int start, int end, int treeNode, int type, int val){
        // int val  = lazy[treeNode].val;
        // int type = lazy[treeNode].type;
        if(type != 0){
            // 0 - nochange, 1 - increment, 2 - set
            if(type == 1){
                st[treeNode].sqSum += ((end - start + 1) * val * val) + (2 * val * st[treeNode].sum);
                st[treeNode].sum += (end - start + 1) * val;

                if(start != end){
                    if(val == 0 || type == 1){
                        lazy[2 * treeNode].type = 1;
                        lazy[2 * treeNode].val += val;
                    }
                    else lazy[2 * treeNode].val += val;
                    lazy[2 * treeNode + 1].type = 1;
                    lazy[2 * treeNode + 1].val = val;
                }
            }
            else{
                st[treeNode].sqSum = (end - start + 1) * val * val + 2 * val * st[treeNode].sum;
                st[treeNode].sum = (end - start + 1) * val;

                if(start != end){
                    lazy[2 * treeNode].type = 2;
                    lazy[2 * treeNode].val = val;
                    lazy[2 * treeNode + 1].type = 2;
                    lazy[2 * treeNode + 1].val = val;
                }
            }
            lazy[treeNode].type = 0;
            lazy[treeNode].val = 0;
        }
    }
    public static void update(int [] nums, NodeT []st, NodeL [] lazy, int ss, int se, int treeNode, int qs, int qe, int val, int type){
        // No overlap
        if(se < qs || ss > qe)return;
        lazyUpd(nums, st, lazy, ss, se, treeNode, lazy[treeNode].type, lazy[treeNode].val);
        // Complete overlap
        if(ss >= qs && se <= qe){
            lazyUpd(nums, st, lazy, ss, se, treeNode, type, val); 
            return;
        }   
        else{
            int mid = ss + (se - ss) / 2;
            if( mid <= se)update(nums, st, lazy, ss, mid, treeNode, qs, qe, val, type);
            else update(nums, st, lazy, mid + 1, se, treeNode, qs, qe, val, type);
            st[treeNode].sqSum = st[2* treeNode].sqSum + st[2 * treeNode + 1].sqSum;
            st[treeNode].sum = st[2* treeNode].sum + st[2 * treeNode + 1].sum;
            return;
        }
    }
    public static int query(int [] nums, NodeT []st, NodeL[] lazy, int ss, int se, int treeNode, int qs, int qe){
        if(qe < ss || qs > se)return 0;
        lazyUpd(nums, st, lazy, ss, se, treeNode, lazy[treeNode].type, lazy[treeNode].val);
        if(qe >= se && qs <= ss)return st[treeNode].sqSum;
        int mid = (ss) + (se - ss) / 2;
        return query(nums, st, lazy, ss, mid, 2 * treeNode, qs, qe) + query(nums, st, lazy, mid + 1, se, 2 * treeNode + 1, qs, qe);
    }
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++)nums[i] = s.nextInt();
        int q = s.nextInt();
        int [][] queries = new int[q][4];
        for(int i = 0; i < q; i++){
        for(int j = 0; j < 4; j++)queries[i][j] = s.nextInt();
        }

        // int nums[] = {1, 3, 2, 7, 9, 11};
        NodeT st[] = new NodeT[4 * nums.length + 1];
        for(int i = 0; i < st.length; i++)st[i] = new NodeT();
        NodeL lazy[] = new NodeL[4 * nums.length + 1];
        for(int i = 0; i < lazy.length; i++)lazy[i] = new NodeL();
        build(nums, st, 0, nums.length - 1, 1);
        // System.out.println(st[1].sqSum + " " + st[1].sum);

        for(int i = 0; i < q; i++){
            // 0 - nochange, 1 - increment, 2 - set
            if(queries[i][0] == 0){
                update(nums, st, lazy, 0, nums.length - 1, 1, queries[i][1], queries[i][2], queries[i][3], 1);
            }
            else if(queries[i][0] == 1){
                update(nums, st, lazy, 0, nums.length - 1, 1, queries[i][1], queries[i][2], queries[i][3], 2);
              }
            else{
                System.out.println(query(nums, st, lazy, 0, nums.length - 1, 1, queries[i][1], queries[i][2]));
            }
            }
    }
}
