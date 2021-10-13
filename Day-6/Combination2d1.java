// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/queens-combinations-2das2d-box-chooses-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {
    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        if(row == tq){
            if(qpsf == tq)System.out.println(asf);
            return;
        }
        if(col == tq){
            queensCombinations(qpsf, tq, row + 1, 0, asf + "
");
        }
        else{
        queensCombinations(qpsf + 1, tq, row, col + 1, asf + "q");
        queensCombinations(qpsf, tq, row, col + 1, asf + "-");
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}