// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/nqueens-permutations-2das1d-official-queen-chooses/ojquestion

import java.io.*;
import java.util.*;

public class Main {

    public static boolean isQueenSafe(int[][] chess, int row, int col) {
        // write your code here
        for(int r = chess.length - 1; r >= 0; r--){
            if(chess[r][col] != 0)return false;
        }
        for(int c = chess.length - 1; c >= 0; c--){
            if(chess[row][c] != 0)return false;
        }
        
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(chess[i][j] != 0)return false;
        }
        for(int i = row, j = col; i < chess.length && j < chess.length; i++, j++){
            if(chess[i][j] != 0)return false;
        }
        for(int i = row, j = col; i >= 0 && j < chess[0].length; i--, j++){
            if(chess[i][j] != 0)return false;
        }
        for(int i = row, j = col; i < chess.length && j >= 0; i++, j--){
            if(chess[i][j] != 0)return false;
        }
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        // write your code here
        if(qpsf == tq){
            display(chess);
            System.out.println();
            return;
        }
        for(int row = 0; row < chess.length; row++){
            for(int col = 0; col < chess[0].length; col++){
                if(chess[row][col] == 0 && isQueenSafe(chess, row, col)){
                    chess[row][col] = qpsf + 1;
                    nqueens(qpsf + 1, tq, chess);
                    chess[row][col] = 0;
                }    
            }
        }
    }
    public static void display(int [][] chess){
        for(int row = 0; row < chess.length; row++){
            for(int col = 0; col < chess.length; col++){
                if(chess[row][col] != 0)System.out.print("q" + chess[row][col] + "	");
                else System.out.print("-	");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}