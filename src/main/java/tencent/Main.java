package tencent;

import java.util.Scanner;
import java.util.Stack;

/**
* @Author: WYF
* @Description: 单调栈
 * 用单调栈实现，开辟一个数组rightLook 保留往右看得到的数量，从右往左遍历，
 * 利用单调栈将看得到的数量保留在数组 rightLook 中 ，再从左往右遍历，获取往左看的计数。
* @Create: 2020/4/26 16:48
* @Version: 1.0
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0 ; i < len ; i++){
            arr[i] = sc.nextInt();
        }
        // stack中要保存的是 能看见的楼的 index
        int[] rightLook = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = len-1; i >= 0 ; i--) {
            rightLook[i] = stack.size();
            while ((!stack.isEmpty())&&(arr[i]>=arr[stack.peek()])){
                stack.pop();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < len; i++) {
            int total = rightLook[i]+1+stack.size();
            while ((!stack.isEmpty())&&(arr[i]>=arr[stack.peek()])){
                stack.pop();
            }
            System.out.println(total+" ");
            stack.push(i);
        }
    }

}
