import java.util.*;
public class Queue{
    static class MyQueue{
        Stack<Integer> main;
        Stack<Integer> helper;
        public MyQueue(){
            main = new Stack<Integer>();
            helper = new Stack<Integer>();
        }
        public void add(int val){
            main.push(val);
        }
        public void pop(){
            while(main.size() > 1)helper.push(main.pop());
            main.pop();
            while(helper.size() >  0)main.push(helper.pop());
        }
        public int top(){
            while(main.size() > 1)helper.push(main.pop());
            int ans = main.peek();
            while(helper.size() > 0)main.push(helper.pop());
            return ans;
        }
    } 
    
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        MyQueue q = new MyQueue();
        for(int i = 0; i < n; i++){
            String input = s.nextLine();
            if(input.charAt(0) == ('1')){
                q.add(Integer.parseInt(input.substring(2)));
            }
            else if(input.charAt(0) == ('2')){
                q.pop();
            }
            else{
                System.out.println(q.top());
            }
        }
        s.close();
    }
}