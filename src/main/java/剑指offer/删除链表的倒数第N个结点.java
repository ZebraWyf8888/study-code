package 剑指offer;

/**
 * 删除链表的倒数第N个结点
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/4/3 01:08
 */
public class 删除链表的倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        // 删除链表中的元素，一般定义一个虚拟头节点，使得删除第一个节点和其他节点的操作是一样的
        ListNode node = new ListNode(0);
        node.next = head;
        // 使用快慢指针
        ListNode fast = node;
        ListNode slow = node;
        // 快指针先走n+1步
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        // 然后快指针走一步，慢指针走一步，等到快指针走到链表的末尾时，慢指针刚好走到待删除节点的前一个节点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除节点
        slow.next = slow.next.next;
        // 由于使用了虚拟头节点，所以最终返回链表头节点，应该是返回虚拟头节点的next域
        return node.next;
    }
}
