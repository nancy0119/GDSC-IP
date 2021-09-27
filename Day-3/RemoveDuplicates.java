// Link : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/submissions/
class Solution {
    public String removeDuplicates(String s) {
        Stack <Character> st = new Stack<>();
        int i = 0;
        while(i < s.length()){
            if(st.size() > 0 && st.peek().equals(s.charAt(i))) 
                st.pop();
            else st.push(s.charAt(i));
            i++;
        }
        String ans = "";
        while(st.size() > 0)ans = st.pop() + ans;
        return ans;
    }
}