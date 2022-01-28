package macleetcode.code3.com.offer;

import java.util.ArrayList;
import java.util.List;


/**
 * 题目：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */



public class ListToArrayList {
    //方法一，用栈实现
    //涉及知识点：Java集合中，List接口的add方法：
    //    List接口中的add方法有如下两种重载方式：
    //            ① boolean add(E e);
    //        ② void add(int index, E element);
    // 方法①用于向列表的末尾插入新元素，这也是List接口中最常用的插入方法；
    // 方法②则可以在插入操作过程中指定插入的位置，此时，会自动将当前位置及只有的元素后移进行插入，
    // 需要注意的是，参数index的值不可大于当前list的容量，即在使用此方法填充一个list时，必须以0开始依次填充。
    //      补充：List中的set方法就是设置位置了 list.set(1,"abc") 就相当于把第二个位置的值替换为"abc"
    //
    //
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> integers = new ArrayList<>();
        ListNode temp = listNode;
        while (temp!=null){
            integers.add(0,temp.val);
            temp = temp.next;
        }
        return integers;
    }

    //方法二：递归
    //this代表当前对象，创建Solution对象调用printListFromTailToHead方法，this指向Solution对象
    // 在这段代码中可用可不用。递归代码执行顺序是遍历到最后一个ListNode，ArrayList再从最后一个ListNodeadd它的val.
    //例如7————>8————>9————>10，先用遍历到10，再把10add进list，再add9,所以实现了从尾到头打印链表。
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList list = new ArrayList();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        for(int i:printListFromTailToHead2(l1)){
            System.out.print(i+ " ");
        }
    }
}
