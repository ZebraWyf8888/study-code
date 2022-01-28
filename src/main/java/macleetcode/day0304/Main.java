package macleetcode.day0304;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       while (scanner.hasNextLine()){
           String next = scanner.nextLine();
           Stack<Integer> stack = new Stack<>();
           char[] chars = next.toCharArray();
//           for (int i = 0; i < chars.length; i++) {
//               if ("+".equals(chars[i])) {
//                   stack.add(chars[i]);
//               }else if ("-".equals(chars[i])) {
//                   stack.add(chars[i]);
//               }else if (")".equals(chars[i])) {//shuzi
////                   stack.add(chars[i]);
//                   char oper ;
//                   int num1;
//                   int num2;
//                   int[] num3;
//                   while (!stack.peek().equals("(") ){
//                       Character pop = stack.pop();
//                       if ("+".equals(chars[i])) {
//
//                       }else if ("-".equals(chars[i])) {
//                           stack.add(chars[i]);
//                       }
//                   }
//                    stack.pop();
//                   stack
//               }else if ("(".equals(chars[i])) {//zuokuohao
//                   stack.add(chars[i]);
//               }else if (" ".equals(chars[i])) {//
//                   stack.add(chars[i]);
//               }else if(chars[i]>='0'&&chars[i]<='9'){//
////                   Integer num = chars[i] - '0';
////                   while (chars[i+1]>='0'&&chars[i+1]<='9'){
////                       num = num*10 + (chars[i+1]-'0');
////                   }
//                   stack.add(chars[i]);
//               }
//           }
           for (int i = next.length()-1; i >0 ; i--) {
               if (chars[i] == '+') {
                   Integer pop = stack.pop();
                   Integer pop1 = stack.pop();
                   stack.push(pop+pop1);
               }else if (chars[i] == '*') {
                   Integer pop = stack.pop();
                   Integer pop1 = stack.pop();
                   stack.push(pop*pop1);
               }else if (chars[i] == '-') {

                   Integer pop = stack.pop();
                   while (!stack.isEmpty()){
                       pop = pop - stack.pop();
                   }
                   stack.push(pop);
               }else if (chars[i] == ')') {//shuzi
                   continue;
               }else if (chars[i] == '(') {//zuokuohdd(chars[i]);
                   continue;
               }else if (chars[i] == ' ') {//
                 continue;
               }else if(chars[i]>='0'&&chars[i]<='9'){//
                   Integer num = 0;
                   int beishu = 1;
                   while (chars[i]>='0'&&chars[i]<='9'){
                       num = num+ (chars[i]-'0')*beishu;
                       i--;
                       beishu = beishu*10;
                   }
                   stack.add(num);
                   i++;
               }
           }
           Integer pop = stack.pop();
           System.out.println(pop);
       }


    }
}
