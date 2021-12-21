// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/nth-palindromic-binary-official/ojquestion
import java.io.*;
import java.util.*;

public class nPalindrome {

    public static int NthPalindromicBinary(int n) {
        //write your code here
        int count = 0;
        int len = 0;
        while(count < n){
            len++;
            int groupLen = (1 << ((len - 1) / 2)); 
            count += groupLen;
        }
        count -= (1 << ((len - 1) / 2));
        int offset = n - count - 1;
        int ans = (1 << (len - 1));
        ans |= (offset << (len / 2));
        int toReverse = (ans >> (len / 2));
        return (ans | getReverse(toReverse));
    }
    public static int getReverse(int n){
        int rev = 0;
        while(n != 0){
            int lsb = (1 & n);
            n = n >> 1;
            rev |= lsb;
            rev = rev << 1;
        }
        rev = rev >> 1;
        return rev;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NthPalindromicBinary(n));
    }

}