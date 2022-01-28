package macleetcode.day210313;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    static PriorityQueue<Long> queue = new PriorityQueue<Long>(new Comparator<Long>() {
        @Override
        public int compare(Long num1, Long num2) {
            return num1.intValue() - num2.intValue();
        }
    });

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        char[] chars = next.toCharArray();
        int i = 0;
        int len = chars.length;
        while (i < len) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                int start = i;
                while ( i < len&&(chars[i] >= '0' && chars[i] <= '9') ) {
                    i++;
                }
                String substring = next.substring(start, i);
                Long i1 = Long.parseLong(substring);
//                System.out.println(i1);
                queue.offer(i1);
            }
            i++;
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
