package day20220213;

import java.util.Arrays;
import java.util.HashMap;


class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[5];
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (ch == 'b') {
                cnt[0]++;
            } else if (ch == 'a') {
                cnt[1]++;
            } else if (ch == 'l') {
                cnt[2]++;
            } else if (ch == 'o') {
                cnt[3]++;
            } else if (ch == 'n') {
                cnt[4]++;
            }
        }
        cnt[2] /= 2;
        cnt[3] /= 2;
        return Arrays.stream(cnt).min().getAsInt();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int anabolic = solution.maxNumberOfBalloons("anabolicaaa");
        System.out.println(anabolic);

    }
}