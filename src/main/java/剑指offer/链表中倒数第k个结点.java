package 剑指offer;

/**
 * 链表中倒数第k个结点
 *
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/4/3 01:08
 */
public class 链表中倒数第k个结点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        // 只需要找链表节点，不需要做删除，因此可以不用定义一个虚拟头节点
        // 使用快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 快指针先走k步
        for (int i = 1; i <= k; i++) {
            fast = fast.next;
        }
        // 然后快指针走一步，慢指针走一步，等到快指针走到链表的末尾时，慢指针刚好走到倒数第k个节点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
