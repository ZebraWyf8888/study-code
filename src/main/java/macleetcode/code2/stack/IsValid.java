package macleetcode.code2.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: WYF
 * @Description: https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/
 * @Create: 2020/4/25 1:26
 * @Version: 1.0
 */
public class IsValid {
    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public IsValid() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char c1 = stack.empty() ? '#' : stack.pop();
                if (c1 != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

//优化：
class Solution {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else if (!map.get(stack.removeLast()).equals(c)) {
                return false;
            }
        }
        return stack.size() == 1;
    }
}
//可以不用map
//
//public boolean isValid(String s) {
//        if(s.isEmpty())
//        return true;
//        Stack<Character> stack=new Stack<Character>();
//        for(char c:s.toCharArray()){
//        if(c=='(')
//        stack.push(')');
//        else if(c=='{')
//        stack.push('}');
//        else if(c=='[')
//        stack.push(']');
//        else if(stack.empty()||c!=stack.pop())
//        return false;
//        }
//        if(stack.empty())
//        return true;
//        return false;
//        }