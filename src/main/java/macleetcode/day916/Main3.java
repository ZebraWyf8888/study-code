package macleetcode.day916;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        MyStack myStack = new MyStack();

        for (int i = 0; i < time; i++) {
            String next = scanner.next();
            if (next.equals("push")) {
                int i1 = scanner.nextInt();
                myStack.push(i1);
            }else if (next.equals("getMin")) {
                System.out.println(myStack.getMin());
            }else if (next.equals("pop")) {
                myStack.pop();
            }else if (next.equals("top")) {
                System.out.println(myStack.peek());
            }

        }
    }
}

class MyStack{
    Stack<Integer> stackValue = new Stack<>();
    Stack<Integer> stackCha = new Stack<>();


    public void  push(Integer integer){
        stackValue.push(integer);
        if (stackCha.empty()) {
            stackCha.push(integer);
        }else if (stackCha.peek()>=integer) {
            stackCha.push(integer);
        }else if (stackCha.peek()<integer) {
            stackCha.push(stackCha.peek());
        }

    }

    public void pop(){
        if (stackValue.isEmpty()) {
            return;
        }
        Integer pop = stackValue.pop();
        if (stackCha.isEmpty()) {
            return;
        } else if (pop.equals(stackCha.peek())) {
            stackCha.pop();
        }

        return ;
    }

    public Integer peek(){

        return stackValue.peek();
    }

    public Integer getMin(){
        return stackCha.pop();
    }
}
