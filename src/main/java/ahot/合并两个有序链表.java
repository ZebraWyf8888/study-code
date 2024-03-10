package ahot;

import org.junit.Test;

import static org.junit.Assert.*;


class MergeTwoSortedListsTest {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    public ListNode me2(ListNode a, ListNode b) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;

        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }

        if (a != null) {
            cur.next = a;
        } else {
            cur.next = b;
        }


        return dum.next;
    }

}


public class 合并两个有序链表{

    @Test
    public void testMergeTwoLists() {
        // Test case 1
        ListNode l1_1 = new ListNode(1);
        l1_1.next = new ListNode(2);
        l1_1.next.next = new ListNode(4);
        ListNode l2_1 = new ListNode(1);
        l2_1.next = new ListNode(3);
//        l2_1.next.next = new ListNode(4);
        ListNode expected1 = new ListNode(1);
        expected1.next = new ListNode(1);
        expected1.next.next = new ListNode(2);
        expected1.next.next.next = new ListNode(3);
        expected1.next.next.next.next = new ListNode(4);
        ListNode text = mergeTwoLists(l1_1, l2_1);
        assertEquals(expected1, text);

        // Test case 2
        ListNode l1_2 = new ListNode(1);
        ListNode l2_2 = new ListNode(1);
        ListNode expected2 = new ListNode(1);
        expected2.next = new ListNode(1);
        assertEquals(expected2, mergeTwoLists(l1_2, l2_2));

        // Test case 3
        ListNode l1_3 = new ListNode(1);
        ListNode l2_3 = new ListNode(3);
        ListNode expected3 = new ListNode(1);
        expected3.next = new ListNode(3);
        assertEquals(expected3, mergeTwoLists(l1_3, l2_3));

        // Test case 4
        ListNode l1_4 = new ListNode(1);
        ListNode l2_4 = new ListNode(2);
        ListNode expected4 = new ListNode(1);
        expected4.next = new ListNode(2);
        assertEquals(expected4, mergeTwoLists(l1_4, l2_4));

        // Test case 5
        ListNode l1_5 = new ListNode(1);
        ListNode l2_5 = new ListNode(0);
        ListNode expected5 = new ListNode(1);
        expected5.next = new ListNode(0);
        assertEquals(expected5, mergeTwoLists(l1_5, l2_5));

        // Test case 6
        ListNode l1_6 = new ListNode(0);
        ListNode l2_6 = new ListNode(0);
        ListNode expected6 = new ListNode(0);
        expected6.next = new ListNode(0);
        assertEquals(expected6, mergeTwoLists(l1_6, l2_6));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}

