// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/permutation-i-official/ojquestion
import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int ci, int ti){
    // write your code here
    if(ci == ti + 1){
        for(int item : boxes){
            System.out.print(item);
        }
        System.out.println();
        return;
    }
    for(int i = 0; i < boxes.length; i++){
        if(boxes[i] == 0){
            boxes[i] = ci;
            permutations(boxes, ci + 1, ti);
            boxes[i] = 0;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems);
  }

}