// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/bit-manipulation-xor-qs/ojquestion
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int [] consXor = new int [arr.length];
        consXor[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            consXor[i] = arr[i] ^ consXor[i - 1];
        }
        int ans [] = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            ans[i] = consXor[queries[i][1]] ^ consXor[queries[i][0]] ^ arr[queries[i][0]];
        }
        return ans;
    }
}
