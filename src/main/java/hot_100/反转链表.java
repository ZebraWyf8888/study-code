package hot_100;

/**
 * 反转链表
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/4/7 00:33
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null; // 指向当前节点的前一个节点
        ListNode cur = head; // 指向当前节点
        ListNode next = null; // 指向当前节点的后一个节点
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
