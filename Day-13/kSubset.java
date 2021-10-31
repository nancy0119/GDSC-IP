// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/k-subsets-with-equal-sum-official/ojquestion

import java.io.*;
import java.util.*;

public class kSubset {

    public static boolean isEqual(int [] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i - 1])return false;
        }
        return true;
    }
	public static void solution(int[] arr, int vidx,int n , int k,int[] subsetSum,int ssssf, ArrayList<ArrayList<Integer>> ans) {
		//write your code here
		if(vidx == n){
		    if(k == ssssf && isEqual(subsetSum)){
		        for(ArrayList<Integer> list : ans)System.out.print(list + " ");
		        System.out.println();
		        return;
		  } 
		  return;
		}
		for(int idx = 0; idx < k; idx++){
		    if(ans.get(idx).size() > 0){
		        ans.get(idx).add(arr[vidx]);
		        subsetSum[idx] += arr[vidx];
		        solution(arr, vidx + 1, n, k, subsetSum, ssssf, ans);
		        subsetSum[idx] -= arr[vidx];
		        ans.get(idx).remove(new Integer (arr[vidx]));
		    }
		    else{
		        ans.get(idx).add(arr[vidx]);
		        subsetSum[idx] += arr[vidx];
		        solution(arr, vidx + 1, n, k, subsetSum, ssssf + 1, ans);
		        subsetSum[idx] -= arr[vidx];
		        ans.get(idx).remove(new Integer (arr[vidx]));
		      //  Important
		        break;
		    }
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k > n || sum % k != 0) {
			System.out.println("-1");
			return;
		}
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(arr,0,n,k,subsetSum,0,ans);
	}
	
	

}