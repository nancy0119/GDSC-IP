// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/sudoku-using-bit-manipulation-official/ojquestion

import java.io.*;
import java.util.*;

public class sudoku {

  public static void display(int[][] arr){
    for (int ii = 0; ii < arr.length; ii++) {
      for (int jj = 0; jj < arr.length; jj++) {
        System.out.print(arr[ii][jj] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void solveSudoku(int[][] arr, int[] rows, int[] cols, int[][] grid, int i, int j) {
    // write your code here. Use display function to display arr
    if(i == arr.length){
        display(arr);
        return;
    }
    int line = i * 9 + j;
    line++;
    int nr = line / 9;
    int nc = line % 9;
    if(arr[i][j] != 0)solveSudoku(arr, rows, cols, grid, nr, nc);
    else{
        for(int digit = 1; digit <= 9; digit++){
            int mask = (1 << digit);
            if((rows[i] & mask) == 0 && (cols[j] & mask) == 0 && (grid[i / 3][j / 3] & mask) == 0){
                arr[i][j] = digit;
                rows[i] |= mask;
                cols[j] |= mask;
                grid[i / 3][j / 3] |= mask;
                solveSudoku(arr, rows, cols, grid, nr, nc);
                arr[i][j] = 0;
                rows[i] ^= mask;
                cols[j] ^= mask;
                grid[i / 3][j / 3] ^= mask;
            }
        }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[][] grid = new int[3][3];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int digit = scn.nextInt();
        arr[i][j] = digit;
        rows[i] |= (1 << digit);
        cols[j] |= (1 << digit);
        grid[i / 3][j / 3] |= (1 << digit);
      }
    }

    solveSudoku(arr, rows, cols, grid, 0, 0);
  }

}