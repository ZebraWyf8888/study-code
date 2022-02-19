package day20220219;


import leetcode20220116.ListNode;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
public class MergeTwo {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

}
