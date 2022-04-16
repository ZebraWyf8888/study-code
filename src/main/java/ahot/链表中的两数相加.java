package ahot;

import leetcode20220116.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 链表中的两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
    public ListNode addTwoNumbers2(ListNode list1, ListNode list2) {
        // 倒着访问链表就是栈啦(≖ᴗ≖)✧
        List<Integer> num1 = new ArrayList<>(100);
        ListNode node = list1;
        while (node != null) {
            num1.add(node.val);
            node = node.next;
        }
        List<Integer> num2 = new ArrayList<>(100);
        node = list2;
        while (node != null) {
            num2.add(node.val);
            node = node.next;
        }

        ListNode head = null;

        int index1 = num1.size() - 1, index2 = num2.size() - 1;
        boolean carry = false;
        while (index1 >= 0 || index2 >= 0) {
            int n1 = index1 >= 0 ? num1.get(index1) : 0;
            int n2 = index2 >= 0 ? num2.get(index2) : 0;
            int sum = (n1 + n2) + (carry ? 1 : 0);
            if (head == null) {
                head = new ListNode(sum % 10);
            }else {
                ListNode newTail = new ListNode(sum % 10);
                newTail.next = head;
                head = newTail;
            }

            carry = sum >= 10;

            index1--;
            index2--;
        }
        // 别忘了最后一次进位哦(´･ᴗ･`)
        if (carry) {
            ListNode newTail = new ListNode(1);
            newTail.next = head;
            head = newTail;
        }
        return head;
    }

}
