package java8.com.offer;


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class RandomListNodeOffer {
    public static RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode clone = new RandomListNode(pHead.label);
        RandomListNode temp = clone;
        while (pHead.next!=null) {
            temp.next = new RandomListNode(pHead.label);
            pHead = pHead.next;
            temp = temp.next;
        }
        return clone;
    }

    public static void main(String[] args) {

    }
}
