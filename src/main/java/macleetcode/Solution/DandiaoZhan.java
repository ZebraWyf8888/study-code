package macleetcode.Solution;

import java.util.Stack;

//https://blog.csdn.net/lucky52529/article/details/89155694
public class DandiaoZhan {
    public void m1(int[] arr){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.size()==0||stack.peek()>= arr[i]) {
                stack.push(arr[i]);
            }else {
                while (stack.size()!=0&&stack.peek()<arr[i]){
                    Integer pop = stack.pop();

                }
                stack.push(arr[i]);
            }
        }
    }
}
