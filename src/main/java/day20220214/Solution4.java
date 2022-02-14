package day20220214;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Solution4 {


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode now = head;
        while (now != null){
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;

        }
        return pre;
    }
}
