package macleetcode.day210313;

import java.util.*;

public class Main3 {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        char[] chars = next.toCharArray();
        int i = 0;
        int len = chars.length;
        while (i < len) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                int start = i;
                while (i < len && (chars[i] >= '0' && chars[i] <= '9')) {
                    i++;
                }
                String substring = next.substring(start, i);
                int i1 = Integer.parseInt(substring);
//                System.out.println(i1);
                list.add(i1);
            }
            i++;
        }
        int[] arr2 = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            arr2[j] = list.get(j);
        }
        Arrays.sort(arr2);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(arr2[j]);
        }
    }
}
