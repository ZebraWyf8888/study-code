package note;

import java.util.HashMap;
import java.util.Map;

//

/**
 * @Author: WYF
 * @Description:
 * @Create: 2020/3/6 22:30
 * @Version: 1.0
 */
public class TwoAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode index = pre;
        int count = 0;
        while (l1 != null || l2 != null){
            int i1 = l1 != null ? l1.val : 0;
            int i2 = l2 != null ? l2.val : 0;
            int i = i1 + i2 + count;
            count = 0;
            if (i > 9){
                count = 1;
            }
            // carry = sum / 10;
            index.next = new ListNode(i%10);
            index = index.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
//        检查 carry = 1carry=1 是否成立，如果成立，则向返回列表追加一个含有数字 11 的新结点。
        if (count > 0) {
            index.next = new ListNode(count);
        }
        return pre.next;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


