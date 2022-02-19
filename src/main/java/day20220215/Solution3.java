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



    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode empty = new ListNode();
        empty.next = head;
        ListNode pre = empty;
        while (head != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return head.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] listNodes = myRev2(head, tail);
            head = listNodes[0];
            tail = listNodes[1];
            pre.next = head;
            tail.next = next;

            pre = tail;
            head = tail.next;
        }
        return empty.next;
    }

    public ListNode[] myRev2(ListNode head,ListNode tail){
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail,head};
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        ListNode listNode = new Solution3().reverseKGroup3(listNode1, 2);
        System.out.println(listNode.val);
    }

    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode empty = new ListNode(-1);
        empty.next = head;
        ListNode pre = empty;
        while (head != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail.next == null) {
                    return empty.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] rev3 = rev3(head, tail);
            head = rev3[0];
            tail = rev3[1];

            pre.next = head;
            tail.next= next;


            pre = tail;
            head = tail.next;
        }
        return empty.next;
    }

    private ListNode[] rev3(ListNode head,ListNode tail){
        ListNode pre = tail.next;
        ListNode now = head;
        while (pre != tail){
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }

        return new ListNode[]{tail,head};
    }
}
