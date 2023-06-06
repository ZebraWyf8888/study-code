package 剑指offer;

/**
 * 合并两个排序的链表
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 19:22
 */
public class 合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 定义一个结果链表
        ListNode head = new ListNode(0);
        // 用于指向结果链表的最后一个节点
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        // 退出循环，有可能是l1或者l2已经遍历结束，或者是二者都遍历结束了
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        // 由于结果链表使用了虚拟头节点，这里需要返回next
        return head.next;
    }
}
