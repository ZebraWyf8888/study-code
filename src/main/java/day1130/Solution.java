package day1130;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        String vvvlo = reorganizeString("zhmyo");
        System.out.println(vvvlo);
    }

    public static String reorganizeString(String S) {
        //先过滤返回空字符串（不可能重构成功）的情况
        if(S.length()<2){
            return S;
        }
        int[] count = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            count[c-'a']++;
            maxCount = Math.max(maxCount, count[c-'a']);
        }
        if (maxCount > (length+1)/2) {
            return "";
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count[o2 - 'a'] - count[o1 - 'a'];
            }
        });

        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c-'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (queue.size()>1){
            char l1 = queue.poll();
            char l2 = queue.poll();
            stringBuffer.append(l1);
            stringBuffer.append(l2);

            int index1 = l1-'a';
            int index2 = l2-'a';
            count[index1]--;
            count[index2]--;

            if (count[index1] > 0 ) {
                queue.offer(l1);
            }
            if (count[index2] > 0) {
                queue.offer(l2);
            }
        }
        if (queue.size() > 0) {
            stringBuffer.append(queue.poll());
        }


        return stringBuffer.toString();
    }
}
