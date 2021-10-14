// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/nqueens-branch-and-bound-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    //write your code here
    int col [] = new int [n];
    int dia1 [] = new int [2 * n - 1];
    int dia2 [] = new int [2 * n - 1];
    findPos(board, col, dia1, dia2, "", 0);
  }
    public static void findPos (boolean [][] board, int [] col, int [] dia1, int [] dia2, String ans, int row){
        if(row == col.length){
            System.out.println(ans + ".");
            return;
        }
        for(int c = 0; c < col.length; c++){
            if(col[c] == 0 && dia1[row + c] == 0 && dia2[row - c + col.length - 1] == 0){
            col[c] = 1;
            dia1[row + c] = 1;
            dia2[row - c + col.length - 1] = 1;
            findPos(board, col, dia1, dia2, ans + row + "-" + c + ", ", row + 1);
            col[c] = 0;
            dia1[row + c] = 0;
            dia2[row - c + col.length - 1] = 0;
            }
        }
        return;
    }
}