// Link - https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1/
class kthlargestBST{
    public void insertAllRight(LinkedList<Node> st, Node curr){
        while(curr != null){
            st.addFirst(curr);
            curr = curr.right;
        }
    }
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int K)
    {
        //Your code here
        int ans = 0;
        LinkedList<Node> st = new LinkedList<>();
        Node curr = root;
        insertAllRight(st, curr);
        while(st.size() > 0){
            Node temp = st.removeFirst();
            if(--K == 0)ans = temp.data;
            insertAllRight(st, temp.left);
        }
        return ans;
    }
}