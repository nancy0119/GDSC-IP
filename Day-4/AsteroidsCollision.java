// Link : https://leetcode.com/problems/asteroid-collision/
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> st = new Stack<Integer>();
        for(int i = 0; i < asteroids.length; i++){
            if(st.size() == 0 || asteroids[i] > 0)st.push(asteroids[i]);
            else{
                while(true){
                    int top = st.peek();
                    if(top < 0){
                        st.push(asteroids[i]);
                        break;
                    }
                    else if(top == -asteroids[i]){
                        st.pop();
                        break;
                    }
                    else if(top > -asteroids[i])break;
                    else{
                        st.pop();
                        if(st.isEmpty()){
                            st.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }
        int ans[] = new int[st.size()];
        int i = st.size() - 1;
        while(i >= 0){
            ans[i] = st.pop();
            i--;
        }
        return ans;
    }
    
}