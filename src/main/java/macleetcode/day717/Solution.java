package macleetcode.day717;


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
/**
 * @author wangyifan
 */
public  class Solution {
    public void deleteNode(ListNode node) {
       //1-2-3-4-5,给你3 你没办法直接删除3，因为你需要他知道2.next，怎么办？  ====》换值

        //第一步：1-2-3-3-5
        node.val = node.next.val;
       //第二部，把第二个三去掉 ,1-2-3-5
        node.next = node.next.next;
    }
}