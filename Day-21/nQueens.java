// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/nqueens-using-bits-official/ojquestion

import java.io.*;
import java.util.*;

public class nQueens {

  public static void solution(boolean[][] board, int row, int cols, int ndiag, int rdiag, String asf) {
    // write your code here
    if(row == board.length){
        System.out.println(asf + ".");
        return;
    }
    for(int col = 0; col < board.length; col++){
        int maskC = (1 << col);
        int maskN = (1 << (col + row));
        int maskR = (1 << (board.length + row - col - 1));
        if((cols & maskC) == 0 && (ndiag & maskN) == 0 && (rdiag & maskR) == 0){
            cols ^= maskC;
            ndiag ^= maskN;
            rdiag ^= maskR;
            solution(board, row + 1, cols, ndiag, rdiag, asf + row + "-" + col + ", ");
            cols ^= maskC;
            ndiag ^= maskN;
            rdiag ^= maskR;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    int cols = 0;
    int ndiag = 0;
    int rdiag = 0;
    solution(board, 0, cols, ndiag, rdiag, "");
  }

}