// Link - https://practice.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication1024/1#

class bracketsmcm{
    static String matrixChainOrder(int p[], int n){
        // code here
        String sdp[][] = new String[n][n];
        mcmT(p, sdp);
        return sdp[0][n - 1];
    }
    static void mcmT(int[] arr, String[][] sdp){
        int n = arr.length;
        int dp[][] = new int [n][n];
        for(int gap = 1; gap < n; gap++){
            for(int si = 0, ei = gap; ei < n; si++, ei++){
                if(ei - si == 1){
                    sdp[si][ei] = (char)(si + 'A') + "";
                    dp[si][ei] = 0;
                    continue;
                }
                String ans = "";
                int minans = (int)1e9;
                for(int cut = si + 1; cut < ei; cut++){
                    int leftans = dp[si][cut];
                    int rightans = dp[cut][ei];
                    if(leftans + arr[si] * arr[cut] * arr[ei] + rightans < minans){
                        minans = leftans + arr[si] * arr[cut] * arr[ei] + rightans;
                        ans = "(" + sdp[si][cut] + sdp[cut][ei] +")";
                    }
                }
                dp[si][ei] = minans;
                sdp[si][ei] = ans;
            }
        }
        
    }
}