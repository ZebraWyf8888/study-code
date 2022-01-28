package nkquestion;

import java.util.Scanner;
import java.util.Stack;

/**
* @Author: WYF
* @Description:
 * 链接：https://www.nowcoder.com/questionTerminal/e06d50b938d24a2b8a2c14edebee5478
来源：牛客网

给出一个布尔表达式的字符串，比如：true or false and false，表达式只包含true，false，and和or，现在要对这个表达式进行布尔求值，计算结果为真时输出true、为假时输出false，不合法的表达时输出error（比如：true true）。表达式求值是注意and 的优先级比 or 要高，比如：true or false and false，等价于 true or (false and false)，计算结果是 true。
* @Create: 2020/4/23 15:46
* @Version: 1.0
*/
public class MeiTuan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        MeiTuan1 meiTuan1 = new MeiTuan1();
        meiTuan1.boolString(split);
    }
    void boolString(String[] bool){
        //新建栈用于存放运算符
        Stack<String> stack = new Stack<>();
        int length = bool.length;//循环次数
        //新建栈用于存放运算符->简单判断
        if (bool[0].equals("or")||bool[length-1].equals("or")||bool[0].equals("and")||bool[length-1].equals("and")) {
            System.out.println("error");
            return;
        }

        //解题思路：
        //将字符串分割后分别压栈，若遇到顶层为and时候进行弹出对比，
        // 最后保证栈中只有true、false、or字符串，再对栈中符号进行判断

        //第一次循环string数组，对and弹出对比，其他入栈，注意error的情况
        for (int i = 0; i < length; i++) {
            String curr = bool[i];
            //当前值为true或false时
            if (curr.equals("true")||curr.equals("false")) {
                //如果栈为空，直接压入
                if (stack.isEmpty()) {
                    stack.push(curr);
                }else {
                    //如果不为空，

                    String peek = stack.peek();
                    //判断前一个是不是true或false。是，出错；
                    if (peek.equals("true")||peek.equals("false")) {
                        System.out.println("error");
                        return;
                    }else {// 不是的话，如果前一个为or，直接压入；如果为and，相与后再压入
                        if (peek.equals("or")) {
                            stack.push(curr);
                        }else {//前一个为and，处理
                            stack.pop();
                            String pre = stack.pop();
                            if (pre.equals("false")||curr.equals("false")) {
                                stack.push("false");
                            }else {
                                stack.push("true");
                            }
                        }
                    }
                }
                //当前值为and或or时
            }else {
                //and/or的隔壁没数据 出错
                if (stack.isEmpty()) {
                    System.out.println("error");
                    return;
                }else {//有数据 还是and/or 出错，其他情况入栈
                    String pre1 = stack.peek();
                    if (pre1.equals("or")||pre1.equals("and")) {
                        System.out.println("error");
                        return;
                    }else {
                        stack.push(curr);
                    }
                }
            }
        }

        //此时栈中都为true，false，or，有一个为真，立即为真
        while (!stack.isEmpty()){
            String end = stack.pop();
            if (end.equals("true")) {
                System.out.println("true");
                break;
            }
            if (stack.isEmpty()){
                System.out.println("false");
            }
        }
    }
}
