// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/crossword-puzzle-official/ojquestion

// Error 

import java.io.*;
import java.util.*;

public class crossword {

    public static void solution(char[][] arr, String[] words, int widx) {
    //write your code here
    if(widx == words.length){
        print(arr);
        return;
    }
    String curr = words[widx];
    for(int r = 0; r < arr.length; r++){
       for(int c = 0; c < arr[0].length; c++){
           if(arr[r][c] == '-' || arr[r][c] == curr.charAt(0)){
               if(canPlaceHori(arr, r, c, curr)){
                   boolean [] wePlace = placeHori(arr, r, c, curr);
                   solution(arr, words, widx + 1);
                   unplaceHori(arr, r, c, wePlace);
               }
               if(canPlaceVeri(arr, r, c, curr)){
                   boolean [] wePlace = placeVeri(arr, r, c, curr);
                   solution(arr, words, widx + 1);
                   unplaceVeri(arr, r, c, wePlace);
               }
           }
       } 
    }
  }

    public static boolean canPlaceHori(char [][] arr, int r, int c, String curr){
    if(c > 0 && arr[r][c - 1] != '+')return false;
    if(c + curr.length() < arr[0].length && arr[r][c + curr.length()] != '+')return false;
    if(c + curr.length() >= arr[0].length)return false; 
    for(int i = 0; i < curr.length(); i++){
        if(arr[r][c + i] != '-' || arr[r][c + i] != curr.charAt(i))
        return false;
    }
    return true;
}
    public static boolean[] placeHori(char[][]arr, int r, int c, String curr){
    boolean wePlace[] = new boolean[curr.length()];
    for(int i = 0; i < curr.length(); i++){
        if(arr[r][c + i] == '-'){
            arr[r][c + i] = curr.charAt(i);
            wePlace[i] = true;
        }
    }
    return wePlace;
}
    public static void unplaceHori(char[][]arr, int r, int c, boolean [] wePlace){
    for(int i = 0; i < wePlace.length; i++){
        if(wePlace[i])arr[r][c + i] = '-';
    }
}
    public static boolean canPlaceVeri(char [][] arr, int r, int c, String curr){
    if(r > 0 && arr[r - 1][c] != '+')return false;
    if(r + curr.length() < arr.length && arr[r + curr.length()][c] != '+')return false;
    if(r + curr.length() >= arr.length)return false; 
    for(int i = 0; i < curr.length(); i++){
        if(arr[r + i][c] != '-' || arr[r + i][c] != curr.charAt(i))
        return false;
    }
    return true;
}
    public static boolean[] placeVeri(char[][]arr, int r, int c, String curr){
    boolean wePlace[] = new boolean[curr.length()];
    for(int i = 0; i < curr.length(); i++){
        if(arr[r + i][c] == '-'){
            arr[r + i][c] = curr.charAt(i);
            wePlace[i] = true;
        }
    }
    return wePlace;
}
    public static void unplaceVeri(char[][]arr, int r, int c, boolean [] wePlace){
    for(int i = 0; i < wePlace.length; i++){
        if(wePlace[i])arr[r + i][c] = '-';
    }
}
  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}