package 剑指offer;

/**
 * 删除链表的节点
 *
 * 移除链表元素需要通过定位目标节点的上一个节点，通过操作上一个节点的指针域实现节点删除
 * 注意：如果要删除的是链表的第一个节点，需要做特殊处理，因为链表的第一个节点没有前驱节点
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 18:52
 */
public class 删除链表的节点 {

    public ListNode deleteNode(ListNode head, int val) {
        // 链表为空的情况
        if (head == null) {
            return head;
        }
        // 要删除的是链表的第一个节点的情况（注意这里需要用while循环，因为链表的第一个元素删除之后，有可能新的第一个元素又是需要被删除的）
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 定义一个辅助节点
        ListNode cur = head;
        // 注意：这里必须加上 cur!= null 的限制；因为前面对链表的第一个节点特殊处理后，有可能此时链表已经为空了
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                // 删除节点
                cur.next = cur.next.next;
                // 注意这里不能执行 cur = cur.next; 因为删除了一个节点后，cur指向了新的节点，有可能cur节点的新后续节点还是需要被删除的
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    // 使用虚拟头节点，避免对第一个节点做特殊处理
    public ListNode deleteNode2(ListNode head, int val) {
        // 链表为空的情况
        if (head == null) {
            return head;
        }
        // 定义虚拟头节点（这里不理解的话可以画出栈和堆的内存示意图）
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        // 定义一个辅助节点
        ListNode cur = newHead;
        // 注意：这里可以不加上 cur!= null 的限制；因为可以明确newHead不为null
        while (cur.next != null) {
            if (cur.next.val == val) {
                // 删除节点
                cur.next = cur.next.next;
                // 注意这里不能执行 cur = cur.next; 因为删除了一个节点后，cur指向了新的节点，有可能cur节点的新后续节点还是需要被删除的
            } else {
                cur = cur.next;
            }
        }
        // 注意这里应该返回虚拟头节点的next（不能直接返回head）
        return newHead.next;
    }
}
