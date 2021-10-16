// Link -  https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/word-kselection-2-official/ojquestion

import java.io.*;
import java.util.*;

public class wordSel2{

  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    String str = s.nextLine();
    int k = s.nextInt();
    String ustr = "";
    HashSet <Character> unique = new HashSet<>();
    for(Character ch : str.toCharArray()){
        if(!unique.contains(ch)){
            unique.add(ch);
            ustr += ch;
        }
    }
    combination(ustr, 0, 0, k, "");
  }
  public static void combination(String ustr, int idx, int iter, int k, String asf){
    if(iter == k){
        System.out.println(asf);
        return;
    }
    for(int i = idx; i < ustr.length(); i++){
            combination(ustr, i + 1, iter + 1, k, asf + ustr.charAt(i));
    }
  }

}
