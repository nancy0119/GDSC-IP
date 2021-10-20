// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/solve-sudoku-official/ojquestion

import java.io.*;
import java.util.*;

public class sudoku {
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    // write yopur code here
    if(i == board.length || j == board.length){
        display(board);
        return;
    }
    int line = i * 9 + j;
    int nr = (line + 1) / 9;
    int nc = (line + 1) % 9;
    if(board[i][j] != 0)solveSudoku(board, nr, nc);
    else{
        for(int no = 1; no <= 9; no++){
            if(isAvail(board, i, j, no)){
                board[i][j] = no;
                solveSudoku(board, nr, nc);
                board[i][j] = 0;
            }
        }
    }
  }
    public static boolean isAvail(int [][] board, int i, int j, int no){
        for(int row = 0; row < board.length; row++){
            if(board[row][j] == no)return false;
        }
        for(int col = 0; col < board.length; col++){
            if(board[i][col] == no)return false;
        }
        int sr = (i / 3) * 3;
        int sc = (j / 3) * 3;
        for(int row = sr; row < sr + 3; row++){
            for(int col = sc; col < sc + 3; col++){
                if(board[row][col] == no)return false;
            }
        }
        return true;
    }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
