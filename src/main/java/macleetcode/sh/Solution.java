package macleetcode.sh;


import java.util.*;

  class Interval {
    int start;
    int end;
  }

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回Interval类，start代表汪仔最少做对了多少道题，end代表汪仔最多做对了多少道题。
     * @param n int整型 选择题总数
     * @param k int整型 朋友做对的题数
     * @param str1 string字符串 长度为n只包含ABCD的字符串，其中第i个代表汪仔第i题做出的选择
     * @param str2 string字符串 长度为n只包含ABCD的字符串，其中第i个代表朋友第i题做出的选择
     * @return Interval类
     */
    public Interval solve (int n, int k, String str1, String str2) {
        char[] chars = str1.toCharArray();
        char[] chars1 = str2.toCharArray();
        int same = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (chars[i] == chars1[i]) {
                same++;
            }
        }
        int maxRight = 0;
        int minRight = 0;
        if (same > k) {
            maxRight = (n-same)+k;
            minRight = same - (n-k);
            if (minRight <0) {
                minRight = 0;
            }
        }else {
            maxRight = same + (n-k);
            minRight = same-(n-k);
            if (minRight <0) {
                minRight = 0;
            }
        }

        Interval interval = new Interval();
        interval.end = maxRight;
        interval.start = minRight;

        return interval;
    }

    public static void main(String[] args) {
       Solution solution = new Solution();
//        Interval solve = solution.solve(3, 3, "ABC", "ABC");
//        System.out.println(solve.start+" "+solve.end);
//
//        Interval solve2 = solution.solve(4, 0, "ABC", "ABC");
//        System.out.println(solve2.start+" "+solve2.end);
        String s = "1101,1010,1111,1110";
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < split[i].length(); j++) {
                System.out.print(split[i].charAt(j));
            }
            System.out.println();
        }
        String[] split2 = solution.change(split);
        for (int i = 0; i < split2.length; i++) {
            for (int j = 0; j < split2[i].length(); j++) {
                System.out.print(split2[i].charAt(j));
            }
            System.out.println();
        }

        String s2 = "ABCD,EFGH,IJKL,MNPQ";
        String[] split1 = s2.split(",");
        String s1 = solution.rotatePassword(split1, split);
        System.out.println(s1);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回一行字符串，表示原文。
     * @param s1 string字符串一维数组 N*N的01矩阵，表示解密纸，0表示透明，1表示涂黑
     * @param s2 string字符串一维数组 字符矩阵，表示密文
     * @return string字符串
     */
    public String rotatePassword (String[] s1, String[] s2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int time = 0; time < 4; time++) {
            for (int i = 0; i < s1.length; i++) {
                for (int j = 0; j < s1[i].length(); j++) {
                    System.out.println(s2[i].charAt(j));
                    if (s2[i].charAt(j) == '0') {
                        stringBuilder.append(s1[i].charAt(j));
                    }
                }
            }
            s2 = change(s2);
        }
        return stringBuilder.toString();
    }

    private String[] change(String[] s2) {
        char[][] strings = new char[s2.length][s2.length];
        for (int i = 0; i < s2.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                char c = s2[i].charAt(j);
                strings[j][s2.length-1-i] = c;
            }
        }
        String[] s3 = new String[s2.length];

        for (int i = 0; i < s2.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < s2.length; j++) {
               stringBuilder.append(strings[i][j]);
            }
            s3[i] = stringBuilder.toString();
        }
        return s3;
    }
}