// Link : https://leetcode.com/problems/implement-stack-using-queues/
class MyStack {
    Queue<Integer> main;
    Queue<Integer> helper;

    public MyStack() {
        main = new ArrayDeque<Integer>();
        helper = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        main.add(x);
    }

    public int pop() {
        while (main.size() > 1)
            helper.add(main.remove());
        int ans = main.remove();
        while (helper.size() != 0)
            main.add(helper.remove());
        return ans;
    }

    public int top() {
        while (main.size() > 1)
            helper.add(main.remove());
        int ans = main.remove();
        while (helper.size() != 0)
            main.add(helper.remove());
        main.add(ans);
        return ans;
    }

    public boolean empty() {
        return (main.size() == 0);
    }
}
