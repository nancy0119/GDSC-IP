// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/permutations-words-2-official/ojquestion

import java.io.*;
import java.util.*;

public class wordPerm2 {

  public static void generateWords(int cc, String str, Character[] spots, 
                                   HashMap<Character, Integer> lastOccurence) {
    // write your code here
    if(cc == str.length()){
        for(Character ch :spots)System.out.print(ch);
        System.out.println();
        return;
    }
    char ch = str.charAt(cc);
    int idx = lastOccurence.get(ch);
    for(int i = idx + 1; i < spots.length; i++){
        if(spots[i] == null){
            spots[i] = str.charAt(cc);
            lastOccurence.put(ch, i);
            generateWords(cc + 1, str, spots, lastOccurence);
            spots[i] = null;
            lastOccurence.put(ch, idx);
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Character[] spots = new Character[str.length()];
    HashMap<Character, Integer> lastOccurence = new HashMap<>();
    for(char ch: str.toCharArray()){
      lastOccurence.put(ch, -1);
    }

    generateWords(0, str, spots, lastOccurence);
  }

}
