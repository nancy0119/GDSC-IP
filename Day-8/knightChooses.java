// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/nknights-combinations-2das1d-knight-chooses-official/ojquestion
import java.io.*;
import java.util.*;

public class knightChooses {

    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
        // write your code here
        int [] positionX = {-2, -1, +1, +2};
        int [] positionY = {-1, -2, -2, -1};
        for(int k = 0; k < 4; k++){
            if(i + positionY[k] >= 0 && j + positionX[k] >=0 && i + positionY[k] < chess.length && j + positionX[k] < chess.length)
            if(chess[i + positionY[k]][j + positionX[k]]) return false;
        }
        return true;
    }

    public static void nknights(int kpsf, int tk, boolean[][] chess, int lcno) {
        if (kpsf == tk) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "k	" : "-	");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsKnightSafe(chess, row, col)) {
                chess[row][col] = true;
                nknights(kpsf + 1, tk, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nknights(0, n, chess, -1);
    }
}