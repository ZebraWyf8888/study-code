package 剑指offer;

/**
 * 两个链表的第一个公共节点
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 19:40
 */
public class 两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 求链表A和链表B的长度
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        ListNode curB = headB;
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        // 得到两个链表的长度差
        int count = Math.abs(lenA - lenB);
        // 判断哪个链表长，让长的链表先走count步
        curA = headA;
        curB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < count; i++) {
                curA = curA.next;
            }
        } else if (lenA < lenB) {
            for (int i = 0; i < count; i++) {
                curB = curB.next;
            }
        }
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            } else {
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }
}
