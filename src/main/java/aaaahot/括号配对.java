package aaaahot;

import java.util.Stack;

public class 括号配对 {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            // 碰到左括号，就把相应的右括号入栈
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
                // 如果是右括号判断是否和栈顶元素匹配
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        // 最后判断栈中元素是否匹配
        return stack.isEmpty();
    }

}
