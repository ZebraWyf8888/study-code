package macleetcode.code2.p1;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end =dummy;
        ListNode rNode = dummy;

        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        while (end.next != null){
            end = end.next;
            rNode = rNode.next;
        }
        ListNode temp = rNode.next.next;
        rNode.next = temp;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);

    }
}
