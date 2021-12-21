// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/min-xor-pairs-official/ojquestion
import java.io.*;
import java.util.*;

public class minXor {

    public static void solution(int[] arr) {
        //write your code here
        Arrays.sort(arr);
        ArrayList<Integer> idxAns = new ArrayList<>();
        int min  = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            if((arr[i] ^ arr[i + 1]) < min){
                min = (arr[i] ^ arr[i + 1]);
                idxAns = new ArrayList<Integer>();
                idxAns.add(i);
            }
            else if((arr[i] ^ arr[i + 1]) == min)idxAns.add(i);
        }
        for(int i = 0; i < idxAns.size(); i++){
            int idx = idxAns.get(i);
            System.out.println(arr[idx] + ", " + arr[idx + 1]);
        }
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
    
    
}