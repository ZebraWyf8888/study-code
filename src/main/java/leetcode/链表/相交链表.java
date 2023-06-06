package leetcode.链表;

/**
 * 相交链表
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 19:42
 */
public class 相交链表 {

    /***
     * 使用快慢指针法
     * 1. 先求出两个链表各自的长度
     * 2. 计算出两个链表的长度差n
     * 3. 长度较长的链表先走n步
     * 4. 然后两个链表再同时一步步走
     * 5. 如果走的过程有遇到节点相等的情况，说明是相交节点
     */
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
