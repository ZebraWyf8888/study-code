package leetcode.链表;

/**
 * 链表的中间节点
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/4/4 00:23
 */
public class 链表的中间节点 {

    /**
     * 使用快慢指针，注意循环结束的条件
     * 注意：如果题目是要求当链表的节点数为偶数，返回第一个中间节点，那么循环结束的条件应该改成快指针的下一节点和下下节点都不为空
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 快节点走两步，慢节点走一步，当快节点走到链表末尾时，慢节点刚好处于链表的中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
