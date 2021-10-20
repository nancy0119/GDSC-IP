// Link -  https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/lexicographical-numbers-official/ojquestion

import java.util.*;

public class lexicographical {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int i = 1; i <= 9; i++) order(n, i);
        scn.close();
	}
	public static void order(int n, int i){
	    System.out.println(i);
	    for(int unit = 0; unit <= 9; unit++){
	        if(i * 10 + unit <= n) order(n, i * 10 + unit);
	        else return ;
	    }
	}
	
}
