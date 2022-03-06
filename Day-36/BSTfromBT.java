// No link - Code is bit incorrect but approach is correct
import java.util.*;

class BSTfromBT {
  public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
        this.val = val;
        }
    }
    public static Node getRightmost(Node curr, Node currL){
        if(currL.right != null && currL.right != curr)currL = currL.right;
        return currL;
    }
    public static Node BTtoDLL(Node root){
            Node curr = root;
            Node head= new Node(-1);
            Node prev = head;
            while(curr != null){
                if(curr.left == null){
                    // ans add
                    prev.right = curr;
                    curr.left = prev;
                    prev = prev.right;

                    curr = curr.right;
                }
                else{
                    Node rightMost = getRightmost(curr, curr.left);
                    if(rightMost.right == null){
                        rightMost.right = curr;
                        curr = curr.left;
                    }
                    else{
                        rightMost.right = null;

                        prev.right = curr;
                        curr.left = prev;
                        prev = prev.right;

                        curr = curr.left;
                    }
                }
            }
            Node temp = head.right;
            temp.left = null;
            head.right = null;
            return temp;
    }
    public static Node getMid(Node head){
        if(head == null || head.right == null)return head;
        Node slow = head; 
        Node fast = head;
        while(fast.right != null && fast.right.right != null){
            fast = fast.right.right;
            slow = slow.right;
        }
        return slow;
    }
    public static Node mergeSort(Node head){
        if(head == null || head.right == null)return head;
        Node mid = getMid(head);
        Node frwd = mid.right;
        frwd.left = null;
        mid.right = null;
        
        head = mergeSort(head);
        frwd = mergeSort(frwd);

        return merge2SortedArrays(head, frwd);
    }
    public static Node merge2SortedArrays(Node leftHead, Node rightHead){
        if(leftHead == null || rightHead == null)return (leftHead == null) ? rightHead : leftHead;
        Node head = new Node(-1);
        Node prev = head;
        while(leftHead != null && rightHead != null){
            if(leftHead.val <= rightHead.val){
                prev.right = leftHead;
                leftHead.left = prev;
                leftHead = leftHead.right;
                prev = prev.right;
            }
            else{
                prev.right = rightHead;
                rightHead.left = prev;
                rightHead = rightHead.right;
                prev = prev.right;
            }
        }
        if(leftHead != null){
            prev.right = leftHead;
            leftHead.left = prev;
        }
        else{
            prev.right = rightHead;
            rightHead.left = prev;
        }
        Node temp = head.right;
        temp.left = null;
        head.right = null;
        return temp;
    }
  // left : prev, right : next
  public static Node SortedDLLToBST(Node head) {
        if(head == null || head.right == null)return head;
        Node mid = getMid(head);
        Node prev = mid.left;
        Node frwd = mid.right;
        mid.left = null;
        mid.right = null;
        frwd.left = null;
        if(prev != null)prev.right = null;
        
        mid.left = SortedDLLToBST((prev != null) ? head : null);
        mid.right = SortedDLLToBST((frwd != null) ? frwd : null);
    return mid;
  }
public Node BTtoBST(Node root){
    if(root == null)return root;
    if(root.left == null && root.right == null)return root;
    root = BTtoDLL(root);
    root = mergeSort(root);
    root = SortedDLLToBST(root);
    display(root);
    return root;
}

  // Input_code===================================================

  public static void display(Node node) {
    if (node == null)
      return;

    StringBuilder sb = new StringBuilder();
    sb.append((node.left != null ? node.left.val : "."));
    sb.append(" -> " + node.val + " <- ");
    sb.append((node.right != null ? node.right.val : "."));

    System.out.println(sb.toString());

    display(node.left);
    display(node.right);

  }

  public static Node makeList(int n) {
    Node dummy = new Node(-1);
    Node prev = dummy;
    while (n-- > 0) {
      Node node = new Node(scn.nextInt());
      prev.right = node;
      node.left = prev;
      prev = prev.right;
    }

    Node head = dummy.right;
    head.left = dummy.right = null;

    return head;
  }

  public static void main(String[] args) {
    Node head = makeList(scn.nextInt());
    head = BTtoDLL(head);
    head = mergeSort(head);
    head = SortedDLLToBST(head);
    display(head);
  }

}