// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/words-klength-words-2-official/ojquestion

import java.io.*;
import java.util.*;

public class wordklen2 {

 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    // selection1(ustr, k, new char[ustr.length()]);
    selection(ustr, "", new boolean[ustr.length()], k);
  }
    public static void selection(String ustr, String asf, boolean [] isFilled, int k){
        if(k == 0){
            System.out.println(asf);
            return;
        }
        for(int i = 0; i < ustr.length(); i++){
            if(!isFilled[i]){
                isFilled[i] = true;
                selection(ustr, asf + ustr.charAt(i), isFilled, k - 1);
                isFilled[i] = false;
            }
        }
    }
    public static void selection1(String ustr, int k, char[] asf){
        if(k < 0)return;
        if(k == 0){
            System.out.println(asf);
            return;
        }
        for(int i = 0; i < ustr.length(); i++){
            if(asf[i] == '\u0000'){
                asf[i] = ustr.charAt(i);
                selection1(ustr, k - 1, asf);
                asf[i] = '\u0000';
            }
        }
    }
}