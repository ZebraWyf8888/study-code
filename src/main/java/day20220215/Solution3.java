package day20220215;

/**
 * k个一组反转链表
 */
public class Solution3 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode pre = hair;
        while (head != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] rev = rev(head, tail);
            head = rev[0];
            tail = rev[1];
            pre.next = head;
            tail.next = nex;
            /**
             * tail 是上一个的结束，他的下一个就是head（头）了，同时也是下一个的开始
             * pre相当于是前驱节点，刚好也是末尾
             */
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    public ListNode[] rev(ListNode head , ListNode tail ){
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail){
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }

        return new ListNode[]{tail,head};
    }
}
