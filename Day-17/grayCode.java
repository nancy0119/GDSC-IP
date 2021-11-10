// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/gray-code/ojquestion

import java.util.*;
 
 public class grayCode {
 
     public static List<String> grayCodeHelper(int n) {
 	 //Write your code here
 	 if(n == 0){
 	     List<String> ans = new ArrayList<String>();
 	     ans.add("0");
 	     return ans;
 	 }
 	 if(n == 1){
 	     List<String> ans = new ArrayList<String>();
 	     ans.add("0");
 	     ans.add("1");
 	     return ans;
 	 }
 	 List<String> prev = grayCodeHelper(n - 1);
 	 List<String> ans = new ArrayList<>();
 	 for(int i = 0; i < prev.size(); i++)
 	     ans.add("0" + prev.get(i));
 	 for(int i = prev.size() - 1; i >= 0; i--)
 	     ans.add("1" + prev.get(i));
 	 return ans;
     }
    public static List<Integer> grayCode(int n){
            List<String> ans = grayCodeHelper(n);
            List<Integer> finalAns = new ArrayList<Integer>();
            for(String item : ans){
                finalAns.add(Integer.parseInt(item, 2));
            }
            return finalAns;
    }
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         List<Integer> ans=grayCode(scn.nextInt());
         Collections.sort(ans);
         System.out.println(ans);
		 scn.close();
     }
 }