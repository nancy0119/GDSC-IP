// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/combinations-2-official/ojquestion
import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(int[] boxes, int ci, int ti, int lb){
    // write your code here
    // ci - current item
    // ti - total item
    // lb - last box
    
    // M - from permutations
        if(ci == ti + 1){
            for(int item : boxes){
                if(item == 1)System.out.print("i");
                else System.out.print("-");
            }
            System.out.println();
            return;
        }
    for(int i = lb + 1; i < boxes.length; i++){
        if(boxes[i] == 0){
            boxes[i] = 1;
            combinations(boxes, ci + 1, ti, i);
            boxes[i] = 0;
        }
    }
    
    // M - from combinations
    // if(lb == boxes.length - 1){
    //     if(ci == ti + 1){
    //         for(int item : boxes){
    //             if(item == 1)System.out.print("i");
    //             else System.out.print("-");
    //         }
    //         System.out.println();
    //     }
    //     return;
    // }
    // boxes[lb + 1] = 1;
    // combinations(boxes, ci + 1, ti, lb + 1);
    // boxes[lb + 1] = 0;
    // combinations(boxes, ci, ti, lb + 1);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, -1);
  }

}