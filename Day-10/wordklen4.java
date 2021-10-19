// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/words-klength-words-4-official/ojquestion

import java.io.*;
import java.util.*;

public class wordklen4 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
    HashMap<Character, Integer> freq = new HashMap<>();
    String ustr = "";
    for(int i = 0; i < str.length(); i++){
        char ch = str.charAt(i);
        int pfreq = freq.getOrDefault(ch, 0);
        freq.put(ch, pfreq + 1);
        if(pfreq == 0)ustr += ch;
    }
    selection(ustr, "", freq, k);
  
  }
    public static void selection(String ustr, String asf, HashMap<Character, Integer> freq, int k){
        if(k < 0)return;
        if(k == 0){
            System.out.println(asf);
            return;
        }
        for(int i = 0; i < ustr.length(); i++){
            char ch = ustr.charAt(i);
            int no = freq.get(ch);
            if(no != 0){
                freq.put(ch, no - 1);
                selection(ustr, asf + ch, freq, k - 1);
                freq.put(ch, no);
            }
        }
    }
}