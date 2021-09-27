// Link - https://leetcode.com/problems/min-stack/
class MinStack {
    class Pair{
        int value;
        int min;
        Pair(int value, int min){
            this.value = value;
            this.min = min;
        }
    }
    /** initialize your data structure here. */
    Stack <Pair> st;
    public MinStack() {
        st = new Stack<Pair>();
    }
    
    public void push(int val) {
        if(st.size() != 0){
            Pair top = st.peek();
            if(top.min > val)st.push(new Pair(val, val));
            else st.push(new Pair(val, top.min));
        }
        else st.push(new Pair(val, val));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().value;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}