class MyQueue {
    Stack<Integer> main;
    Stack<Integer> helper;

    public MyQueue() {
        main = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        main.push(x);
    }

    public int pop() {
        while (main.size() > 1)
            helper.push(main.pop());
        int ans = main.pop();
        while (helper.size() != 0)
            main.push(helper.pop());
        return ans;
    }

    public int peek() {
        while (main.size() > 1)
            helper.push(main.pop());
        int ans = main.peek();
        while (helper.size() != 0)
            main.push(helper.pop());
        return ans;
    }

    public boolean empty() {
        return main.size() == 0;
    }
}