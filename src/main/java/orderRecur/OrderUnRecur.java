package orderRecur;

import java.util.Stack;

/**
 * @author wangyifan
 */
public class OrderUnRecur {
    public static void main(String[] args) {
        System.out.print("aaa");
    }

    /**
     * 先顺
     *
     * @param head
     */
    public void preOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.val + ">");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param head
     */
    public void inOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.val + ">");
                head = head.right;
            }
        }
    }

    /**
     * 后续遍历
     *
     * @param head
     */
    public void terOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty() ) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.println(stack2.pop()+">");
        }
    }
    /**
     * 后续遍历2:一个栈实现
     *
     * @param head
     */
    public void terOrderUnRecur2(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        stack1.push(head);
        Node c;
        while (!stack1.isEmpty() ) {
            c = stack1.peek();
            if (c.left != null && head != c.left && head != c.right) {
                stack1.push(c.left);
            }else if (c.right != null && head != c.right){
                stack1.push(c.right);
            }else {
                System.out.println(stack1.pop().val + ">");
                head =c;
            }
        }
        
    }

}
