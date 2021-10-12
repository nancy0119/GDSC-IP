import java.util.*;
public class height {
    public static void main(String []  args){
        Scanner s = new Scanner(System.in);
        int size[] = new int[3];
        for(int i = 0; i < 3; i++){
            size[i] = s.nextInt();
        }
        int s1 [] = new int[size[0]]; 
        int s2 [] = new int[size[1]];
        int s3 [] = new int[size[2]];
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        HashMap <Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < size[0]; i++) {
            s1[i] = s.nextInt();
            sum1 += s1[i];
        }
        for(int i = 0; i < size[0]; i++){
            int add = hm.getOrDefault(sum1, 0);
            hm.put(sum1, add + 1);
            sum1 -= s1[i];
        }
        for(int i = 0; i < size[1]; i++) {
            s2[i] = s.nextInt();
            sum2 += s2[i];
        }
        for(int i = 0; i < size[1]; i++){
            int add = hm.getOrDefault(sum2, 0);
            hm.put(sum2, add + 1);
            sum2 -= s2[i];
        }
        for(int i = 0; i < size[2]; i++) {
            s3[i] = s.nextInt();
            sum3 += s3[i];
        }
        for(int i = 0; i < size[2]; i++){
            int add = hm.getOrDefault(sum3, 0);
            hm.put(sum3, add + 1);
            sum3 -= s3[i];
        }
        Set <Integer> keys = hm.keySet();
        int currmax = Integer.MIN_VALUE;
        for(int key : keys){
            if(hm.get(key) == 3 && key < currmax)currmax = key;
        }
        System.out.println(currmax);
        s.close();
    }
}
