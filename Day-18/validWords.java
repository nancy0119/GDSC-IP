// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/number-of-valid-words-official/ojquestion

import java.io.*;
import java.util.*;

public class validWords {

  public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    //write your code here
    HashMap<Character, ArrayList<Integer>> hasChar = new HashMap<>();
    for(int i = 0; i < 26; i++)hasChar.put((char)(i + 'a'), new ArrayList<Integer>());
    for(String word : words){
        HashSet<Character> unique = new HashSet<>();
        for(Character ch : word.toCharArray()){
            if(!unique.contains(ch)){
            hasChar.get(ch).add(getMask(word));
            unique.add(ch);
            }
        }
    }
    
    ArrayList<Integer> count = new ArrayList<>();
    for(String puzzle : puzzles){
        int currCount = 0;
        int puzzleMask = getMask(puzzle);
        for(Integer wordMask : hasChar.get(puzzle.charAt(0))){
            if((puzzleMask & wordMask) == wordMask)currCount++;
        }
        count.add(currCount);
    }
    return count;
  }
  public static int getMask(String word){
      int ans = 0;
      for(int i = 0; i < word.length(); i++){
          int shift = word.charAt(i) - 97;
          ans = ans | (1 << shift);
      }
      return ans;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i < words.length; i++) {
      words[i] = scn.next();
    }
    int m = scn.nextInt();
    String[] puzzles = new String[m];
    for (int i = 0 ; i < m ; i++) {
      puzzles[i] = scn.next();
    }
    ArrayList<Integer> ans = findNumOfValidWords(words, puzzles);
    for (int i = 0 ; i < m ; i++) {
      System.out.println(puzzles[i] + " -> " + ans.get(i));
    }
  }

}