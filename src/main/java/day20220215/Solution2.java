package day20220215;

import java.util.ArrayList;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Solution2 {

    /**
     * 反转链表2
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode empty = new ListNode(-1);
        empty.next = head;

        ListNode pre = empty;
        for (int i = 0; i < left-1; i++) {
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
        preNext.next =lastNext;


        return empty.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode now = head;
        while (now != null){
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
        while (curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }


    /**
     * 方法一的缺点是：如果 left 和 right 的区域很大，恰好是链表的头节点和尾节点时，找到 left 和 right 需要遍历一次，反转它们之间的链表还需要遍历一次，虽然总的时间复杂度为 O(N)O(N)，但遍历了链表 22 次
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
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
