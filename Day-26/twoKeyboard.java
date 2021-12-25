// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/2-key-keyboard-official/ojquestion
import java.io.*;
import java.util.*;

public class twoKeyboard {

	public static int solution(int n) {
		//write your code here
		int ans = 0;
		for(int i = 2; i * i <= n;){
		    if(n % i == 0){
		        ans += i;
		        n /= i;
		    }
		    else i++;
		}
		if(n != 1)ans += n;
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}