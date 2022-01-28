package macleetcode.day1004;


 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode now = null ;
        int temp = 0;
        while (l1!=null || l2 !=null){
            int a = l1 != null ? l1.val:0;
            int b = l2 != null ? l2.val:0;
            ListNode listNode1 = new ListNode((a + b + temp) % 10);

            if (head == null) {
                head = now = listNode1;
            }else {
                now.next = listNode1;
                now = now.next;
            }
            temp = (a+b+temp)/10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        /**
         * 处理 最后可能有一位1
         */
        if (temp > 0 ) {
            now.next = new ListNode(temp);
        }

        return head;
    }
    

}