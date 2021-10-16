// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/words-kselection-3-official/ojquestion

import java.io.*;
import java.util.*;

public class wordSel1 {

  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }
// selectionsReverse(unique, ustr, "", 0, k, 0);
// selections(unique, ustr, "", k, 0);
   selections2(unique, ustr, "", k, 0);
  }
//   public static void selectionsReverse(HashMap<Character, Integer> unique, String ustr, String asf, int cs, int ts, int idx){
//     if(cs > ts)return;
//     if(idx == ustr.length()){
//         if(cs == ts)System.out.println(asf);
//         return;
//     }
//     selections(unique, ustr, asf, cs, ts, idx + 1);
//     String add = "";
//     char ch = ustr.charAt(idx);
//     for(int i = 0; i <  unique.get(ch); i++){
//         add += ch;
//         if(cs < ts)selections(unique, ustr, asf + add, cs + i + 1, ts, idx + 1);
//     }
// }
    
public static void selections(HashMap<Character, Integer> unique, String ustr, String asf, int k, int idx){
    if(k < 0) return;
    if(idx == ustr.length()){
        if(k == 0)System.out.println(asf);
        return;
    }
    char ch = ustr.charAt(idx);
    for(int i = unique.get(ch); i >= 0; i--){
        String add = "";
        for(int iter = 0; iter < i; iter++)add += ch;
        selections(unique, ustr, asf + add, k - i, idx + 1);
    }
}
public static void selections2(HashMap<Character, Integer> unique, String ustr, String asf, int k, int idx){
    if(k < 0) return;
    if(idx == ustr.length()){
        if(k == 0)System.out.println(asf);
        return;
    }
    char ch = ustr.charAt(idx);
    int freq = unique.get(ch);
    if(freq > 0){
        unique.put(ch, freq - 1);
        selections2(unique, ustr, asf + ch, k  - 1, idx);
        unique.put(ch, freq);
    }
    selections2(unique, ustr, asf, k, idx + 1);
}
}