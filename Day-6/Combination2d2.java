// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/queens-combinations-2das2d-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        // write your code here
        if(qpsf == tq){
            display(chess);
            System.out.println();
            return;
        }
        for(int col = j + 1; col < tq; col++){
                chess[i][col] = true;
                queensCombinations(qpsf + 1, tq, chess, i, col);
                chess[i][col] = false;
        }
        for(int row = i + 1; row < tq; row++){
            for(int col = 0; col < tq; col++){
                chess[row][col] = true;
                queensCombinations(qpsf + 1, tq, chess, row, col);
                chess[row][col] = false;
        }
    }
}
    public static void display(boolean[][]chess){
        for(int row = 0; row < chess.length; row++){
            for(int col = 0; col < chess.length; col++){
                if(chess[row][col])System.out.print("q\t");
                else System.out.print("-\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}