// Link - https://nados.io/question/convert-binary-search-tree-to-doubly-linked-list?zen=true
import java.util.*;

public class bToDLL {
  public static Scanner scn = new Scanner(System.in);

  public static class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    Node(int val) {
      this.val = val;
    }
  }
  public static void insertAllLeft(LinkedList<Node> st, Node curr){
    while(curr != null){
      st.addFirst(curr);
      curr = curr.left;
    }
  }
  public static Node getRightMost(Node curr, Node cleft){
    while(cleft.right != null && cleft.right != curr){
      cleft = cleft.right;
    }
    return cleft;
  }
  public static Node bToDLL(Node root) {
    Node head = new Node(-1);
    Node prev = head;
    
    // M1
    // LinkedList<Node> st = new LinkedList<>();
    // insertAllLeft(st, root);
    // while(st.size() != 0){
    //   Node tmp = st.removeFirst();
    //   prev.right = tmp;
    //   tmp.left = prev;
    //   prev = tmp;
    //   insertAllLeft(st, tmp.right);
    // }

    // M2
    Node curr = root;
    while(curr != null){
      if(curr.left == null){

        prev.right = curr;
        curr.left = prev;
        prev = prev.right;

        curr = curr.right;
      }
      else{
        Node rm = getRightMost(curr, curr.left);
        if(rm.right == null){
          rm.right = curr;
          curr = curr.left;
        }
        else{
          rm.right = null;

          prev.right = curr;
          curr.left = prev;
          prev = prev.right;

          curr = curr.right;
        }
      }
    }
    Node tmp = head.right;
    tmp.left = null;
    head.right = null;

    // for circular LL
    // tmp.left = prev;
    // prev.right = tmp;

    return tmp;
  }

  // input_section=================================================

  public static void display(Node node) {
    Node head = node;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.right;
      if (node == head)
        break;
    }

  }

  public static Node constructFromInOrder_(int[] in, int si, int ei) {
    if (si > ei)
      return null;

    int mid = (si + ei) / 2;
    Node node = new Node(in[mid]);

    node.left = constructFromInOrder_(in, si, mid - 1);
    node.right = constructFromInOrder_(in, mid + 1, ei);

    return node;
  }

  public static Node constructFromInOrder(int[] inOrder) {
    int n = inOrder.length;
    return constructFromInOrder_(inOrder, 0, n - 1);
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] in = new int[n];
    for (int i = 0; i < n; i++)
      in[i] = scn.nextInt();

    Node root = constructFromInOrder(in);
    root = bToDLL(root);
    display(root);
  }

  public static void main(String[] args) {
    solve();
  }
}