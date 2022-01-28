package p1;


import java.util.ListIterator;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class RemoveNthFromEnd {
    public void delteListNode(ListNode first){
        if (first == null) {
            return;
        }

        int minValue = Integer.MAX_VALUE;
        ListNode head = new ListNode(0);
        head.next = first;

        ListNode now = head;
        ListNode nowBefore = null;

        ListNode minNode = null;//最小节点的头一个节点
        while (now.next != null){
            if (now.next.val < minValue) {
                minValue = now.val;
                minNode = nowBefore;
            }
            nowBefore = now;
            now = now.next;

        }


        minNode.next =  minNode.next.next;


    }

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

        ListNode listNode1 = new ListNode(-2);
        ListNode listNode2 = new ListNode(-1);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        new RemoveNthFromEnd().delteListNode(listNode);


        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
