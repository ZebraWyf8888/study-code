package reverse;

import dfsandbfs.Node;

import java.util.Stack;

/**
 * https://blog.nowcoder.net/n/2780b6c0e59d4b96bf74c96da823ed19
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class re {
    public static void main(String[] args) {

    }

    /**
     * 递归实现
     *
     * @param head
     * @return
     */
    public static ListNode re1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = re1(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 双指针实现
     *
     * @param head
     * @return
     */
    public static ListNode re2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = null;
        ListNode right = head.next;
        while (right != null){
            ListNode t = right.next;
            right.next = left;
            left = right;
            right = t;
        }
        return left;
    }

    public ListNode reverseList3(ListNode head) {
        // 使用栈进行链表的反转
        Stack<ListNode> stack = new Stack<>();
        // 存入栈中
        while (head!= null){
            stack.push(head);
            head = head.next;
        }
        // 弹出栈中
        ListNode node = stack.pop();
        while (!stack.isEmpty()){
            // 交换，为了弹出前面k个值
            ListNode tmp = stack.pop();
            node.next = tmp;
            node = node.next;
        }
        node.next = null;
        return node;
    }
    public ListNode reverseList4(ListNode head) {
        // 使用双链表进行更新反转链表
        ListNode newNode = null;
        while (head != null){
            // 存储下一个节点的位置，进行遍历
            ListNode tmp = head.next;
            //            // 将头节点赋值新链表值
            head.next = newNode;
            // 将节点赋值到新链表上
            newNode = head;
            // 重新赋值遍历
            head = tmp;
        }
        return newNode;
    }

}
