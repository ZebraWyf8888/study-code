package macleetcode.code2.tencent;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        scanner.close();
        System.out.println(decode(next));
    }

    public static String decode(String words) {
        while (words.contains("]")) {
            int right = words.indexOf("]");
            int left = words.lastIndexOf("[", right);
            String repeatStr = words.substring(left + 1, right);
            String[] split = repeatStr.split("\\|");
            List<String> strings = Collections.nCopies(Integer.parseInt(split[0]), split[1]);
            String join = String.join("", strings);
            words = words.replace("[" + repeatStr + "]",join);
        }
        return words;
    }
}
