// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/wors-klength-words-3-official/ojquestion

import java.io.*;
import java.util.*;

public class wordklen3 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
    HashMap<Character, Integer> lastOcc = new HashMap<>();
    for(int i = 0; i < str.length(); i++) lastOcc.put(str.charAt(i), -1);
    selection(str, k, 0, new char[k], lastOcc);
   
  }
  public static void selection(String str, int k, int idx, char[] asf, HashMap<Character, Integer> lastOcc){
      if(idx == str.length()){
          if(k == 0)System.out.println(asf);
          return;
      }
      char ch = str.charAt(idx);
      int no = lastOcc.get(ch);
      for(int i = no + 1; i < asf.length; i++){
          if(asf[i] == '\u0000'){
              asf[i] = ch;
              lastOcc.put(ch, i);
              selection(str, k - 1, idx + 1, asf, lastOcc);
              asf[i] = '\u0000';
              lastOcc.put(ch, no);
          }
      }
      if(no == -1)selection(str, k, idx + 1, asf, lastOcc);
  }

}