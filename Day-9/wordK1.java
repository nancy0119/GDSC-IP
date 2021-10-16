// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/words-klength-words-1-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {

 

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
    selection(ustr, 0, k, 0, new char[k]);
    
  }
    public static void selection(String ustr, int idx, int ts, int cs, char [] asf){
        if(idx == ustr.length()){
            if(cs == ts)System.out.println(asf);
            return;
        }
        char ch = ustr.charAt(idx);
        for(int i = 0; i < ts; i++){
            if(asf[i] == '\u0000'){
                asf[i] = ch;
                selection(ustr, idx + 1, ts, cs + 1, asf);
                asf[i] = '\u0000';
            }
        }
        selection(ustr, idx + 1, ts, cs, asf);
    }
}