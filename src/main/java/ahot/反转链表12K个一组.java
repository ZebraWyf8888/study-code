package ahot;

public class 反转链表12K个一组 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(-1);
        hair.next = head;
        /**
         * 四个核心：pre、next；head、tail
         */
        ListNode pre = hair;
        while (head != null) {
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

    public ListNode[] rev(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }


    /**
     * 反转链表2
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode empty = new ListNode(-1);
        empty.next = head;

        ListNode pre = empty;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode last = pre;
        for (int i = 0; i < right - left + 1; i++) {
            last = last.next;
        }

        ListNode preNext = pre.next;
        ListNode lastNext = last.next;

        pre.next = null;
        last.next = null;

        reverseList2(preNext);

        pre.next = last;
        preNext.next = lastNext;


        return empty.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode now = head;
        while (now != null) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;

        }
        return pre;
    }

    public void reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = dummyNode.next;
        }
        ListNode curr = pre.next;
        ListNode next = pre.next.next;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}


