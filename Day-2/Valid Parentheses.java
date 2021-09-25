// Link:https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put(')', '(');
        hm.put(']', '[');
        hm.put('}', '{');
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            // If a closing bracket is encountered:
            if (hm.containsKey(current)) {
                // // Get the top element of the stack. If the stack is empty, set a dummy value
                // of '#'
                char topElement = st.empty() ? '#' : st.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return
                // false.
                if (topElement != hm.get(current)) {
                    return false;
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        return st.isEmpty();
    }
}