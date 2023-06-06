package 剑指offer;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 19:09
 */
public class 从尾到头打印链表 {

    // 借助ArrayList
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(0, temp.val);
            temp = temp.next;
        }
        int len = list.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // 反向插入，不需要借助ArrayList
    public int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        // 统计链表的节点数，便于创建数组
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        int[] result = new int[length];
        // 反向插入
        for (int i = length - 1; i >= 0; i--) {
            result[i] = head.val;
            head = head.next;
        }
        return result;
    }
}
