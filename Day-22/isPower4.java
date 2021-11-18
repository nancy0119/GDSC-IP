// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/is-a-power-of-4/ojquestion

class Solution {
    public boolean isPowerOfFour(int n) {
//         M-1
        // return (n > 0 && getSetBits(n - 1) % 2 == 0 && getSetBits(n) == 1);
        
// M - 2
        int mask = 0b01010101010101010101010101010101;
        return(n > 0 && (n & (n - 1)) == 0 && (mask & n) != 0);
    }
    public static int getSetBits(int no){
        int count = 0;
        while(no != 0){
            int rsbm = (no & -no);
            no -= rsbm;
            count++;
        }
        return count;
    }
}