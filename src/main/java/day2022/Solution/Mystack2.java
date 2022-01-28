package day2022.Solution;

import java.util.Stack;

public class Mystack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    private int min;

    public Mystack2(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int n) {

        if (this.stackData.isEmpty()) {
            this.stackMin.push(n);
        } else if (n < this.getMin()) {
            this.stackMin.push(n);
        }
        this.stackData.push(n);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("stask null");
        }
        Integer pop = this.stackMin.pop();
        if (!stackData.isEmpty() && pop.equals(stackData.peek())) {
            stackMin.pop();
        }
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("stask null");
        }
        return min;
    }
}
