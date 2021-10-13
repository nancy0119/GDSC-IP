// link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/queens-permutations-2das2d-queen-chooses-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int[][] chess){
        // write your code here
        if(tq == qpsf){
            displayChess(chess);
            System.out.println();
            return;
        }
        for(int row = 0; row < chess.length; row++){
            for(int col = 0; col < chess[0].length; col++){
                if(chess[row][col] == 0){
                    chess[row][col] = qpsf + 1;
                    queensPermutations(qpsf + 1, tq, chess);
                    chess[row][col] = 0;
                }
            }
        }
    }
    public static void displayChess(int [][]chess){
        for(int row = 0; row < chess.length; row++){
            for(int col = 0; col < chess[0].length; col++){
                if(chess[row][col] == 0)System.out.print("-	");
                else System.out.print("q" + chess[row][col] + "	");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queensPermutations(0, n, chess);
    }
}