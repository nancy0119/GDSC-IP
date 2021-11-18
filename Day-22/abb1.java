// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/abrreviation1-using-bits-official/ojquestion


import java.io.*;
import java.util.*;

public class abb1 {

    public static void solve(String str){
        // write your code here
        int length = str.length();
        for(int i = 0; i < (1 << length); i++){
            StringBuilder ans = new StringBuilder();
            int count = 0;
            for(int idx = 0; idx < length; idx++){
                int mask = (1 << (length - 1 - idx));
                if((i & mask) != 0)count++;
                else{
                    if(count != 0)ans.append(count);
                    ans.append(str.charAt(idx));
                    count = 0;
                }
            }
            if(count != 0)ans.append(count);
            System.out.println(ans);
        }
    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str);
    }
}