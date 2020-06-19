package linkedlist;


public class AddLists {


    private static class Node {
        int val;
        Node next;

        Node(int x){
            val=x;
        }
        Node(){

        }
    }

    /**
     * Created by rahulchakraborty on 8/6/16.
     *
     * Sum Lists: You have two numbers represented by a linked list,where each node contains a single digit.
     * The digits are stored in reverse order,such that the 1's digit is at the head of the list.
     * Write a function that adds the two numbers and returns the sum as a linked list.
     EXAMPLE
     Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295. Output:2 -> 1 -> 9.Thatis,912.

     */

    public Node addList(Node list1, Node list2, int carry){
        if(list1 == null  && list2 ==null && carry==0){
            return null;
        }
        int val = carry;

        Node result = new Node();
        if(list1!=null){
            val+=list1.val;
        }
        if(list2!=null){
            val+=list1.val;
        }
        if(list1 !=null || list2!=null) {
            Node more = addList(list1==null?null:list1.next, list2==null?null:list2.next,val>=10?1:0);
            result.next=more;
        }

        return result;

    }

    public static Node mergeLists(Node headA, Node headB) {
        Node headC = null;
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }

        if (headA.val <= headB.val) {
            headC = headA;
            headC.next = mergeLists(headA.next, headB);
        } else {
            headC = headB;
            headC.next = mergeLists(headA, headB.next);
        }
        return headC;
    }
}
