package macleetcode.day0204;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    private ListNode mg2(ListNode a,ListNode b){
        if (a == null||b==null) {
            return a!=null?a:b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head,aPtr = a,bPtr = b;

        while (aPtr != null && bPtr != null){
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null?aPtr:bPtr);
        return head.next;
    }
}
