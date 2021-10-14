// link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/queens-combinations-2das1d-queen-chooses-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        // write your code here
        if(qpsf == tq){
            display(chess);
            System.out.println();
            return;
        }
        for(int i = lcno + 1; i < tq * tq; i++){
            int row = i / tq;
            int col = i % tq;
            chess[row][col] = true;
            queensCombinations(qpsf + 1, tq, chess, i);
            chess[row][col] = false;
        }
    }
    public static void display(boolean[][]chess){
        for(int row = 0; row < chess.length; row++){
            for(int col = 0; col < chess[0].length; col++){
                if(chess[row][col])System.out.print("q	");
                else System.out.print("-	");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}