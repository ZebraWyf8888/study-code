package day20220215;

public class Solution4 {
    /**
     * 删除链表的倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode empty= new ListNode(-1);
        empty.next = head;
        ListNode now = empty;
        int len = 0;
        while(now != null){
            len++;
            now = now.next;
        }

        now = empty;
        for(int i = 0;i < len-1-n;i++){
            now = now.next;
        }
        if(now.next != null){
            now.next = now.next.next;
        }

        return empty.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        removeNthFromEnd(listNode1,2);
    }
}
