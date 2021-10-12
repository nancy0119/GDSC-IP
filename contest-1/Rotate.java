import java.util.Scanner;

public class Rotate {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int d = s.nextInt();
        d %= size;
        int input [] = new int[size];
        for(int i = 0; i < size; i++){
            input[i] = s.nextInt();
        }
        int output[] = new int[size];
        for(int i = 0; i < size; i++){
            output[i] = input[(i + d) % size];
        }
        for(int i = 0; i < size; i++)System.out.print(output[i] + " ");
    }
}
