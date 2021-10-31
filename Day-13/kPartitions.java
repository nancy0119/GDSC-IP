// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/k-partitions-official/ojquestion

import java.io.*;
import java.util.*;

public class kPartitions {
    static int counter = 1;
	public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
		//write your code here
		if(i > n){
		    if(rssf == k){
		        System.out.print(counter  + ". ");
		        for(ArrayList item : ans)System.out.print(item +" ");
		        System.out.println();
		        counter++;
		    }
		    return;
		}
		for(int idx = 0; idx < ans.size(); idx++){
		    if(ans.get(idx).size() != 0){
    		    ans.get(idx).add(i);
    		    solution(i + 1, n, k, rssf, ans);
    		    ans.get(idx).remove(new Integer(i));
		    }
		    else{
		        ans.get(idx).add(i);
        		solution(i + 1, n, k, rssf + 1, ans);
        		ans.get(idx).remove(new Integer (i));
        		break;
		    }
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);

	}

}