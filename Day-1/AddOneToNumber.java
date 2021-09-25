// Link to the question: https://www.interviewbit.com/problems/add-one-to-number/
public class Solution {
    public int[] plusOne(int[] A) {
        int carry = 1;
        for(int i = A.length - 1; i >= 0; i--){
            if(carry == 0)break;
            int upd = A[i] + carry;
            A[i] =  upd % 10;
            carry = upd / 10;
        }
        if(carry != 0){
            int update [] = new int[A.length + 1];
            for(int i = A.length; i >= 0; i--){
                if(i == 0)update[i] = carry;
                else update[i] = A[i - 1];
            }
            return update;
        }
        int idx = NonzeroIdx(A);
        if(idx != -1){
            int update [] = new int[A.length  - idx];
            for(int i = 0; i < A.length - idx; i++){
                update[i] = A[i + idx];
            }
            return update;
        }
        return A;
    }
    public static int NonzeroIdx(int A[]){
        for(int i = 0; i < A.length; i++){
            if(A[i] != 0) return i;
        }
        return -1;
    }
}
