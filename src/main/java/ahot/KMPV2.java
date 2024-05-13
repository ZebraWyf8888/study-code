package ahot;

import java.util.ArrayList;
import java.util.List;

public class KMPV2 {

    public int[] getNextV2(String p) {
        int[] next = new int[p.length()];
        int now = 0;
        // 与search方法类似，这两个循环都使用了一种"记忆化搜索"的技巧，但它们在KMP算法的上下文中有稍微不同的作用。
        // 这个循环是在生成部分匹配表时使用的。它用于找到模式字符串中的每个位置 i 的最长前缀后缀的匹配长度 now。
        // 通过在字符比较过程中逐步向前回退，直到找到一个位置，使得模式的前缀与后缀匹配，从而记录每个位置的最长匹配长度。
        // aabaabx,
        // 1、在计算的时候，i=5,当刚刚进入循环当时候，now=2,index为5 和index为2的值是一样的 都是b，跳转到3，now=3
        // 2、i=6，now=3,index为6 和index为3的值是不一样的 ，index为6是x，index为3是a，now=next[3-1]=0
        for (int i = 1; i < p.length(); i++) {
            while (now > 0 && p.charAt(i) != p.charAt(now)) {
                now = next[now - 1];
            }
            if (p.charAt(i) == p.charAt(now)) {
                now++;
            }
            next[i] = now;
        }
        return next;
    }

    public int[] getNext(String p) {
        int[] next = new int[p.length()];
        for (int i = 0; i < p.length(); i++) {
            next[i] = getNextNum(p, i);
        }
        return next;
    }

    public int getNextNum(String p , int x) {
        for (int i = x; i > 0; i--) {
            // 注意 substring 会是左闭右开，所以末尾是x + 1，
            // 这个函数的含义是 x + 1（末尾）向后移动几位 ，然后0（起始位置）向前移动几位，从而计算是next数组的下标
            if (p.substring(0, i).equals(p.substring(x+ 1 - i , x + 1))) {
                return i;
            }
        }
        return 0;
    }

    public List<Integer> search(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] next = getNextV2(p);
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            // 匹配失败的时候，需要回退到之前匹配的位置，但是回退的时候，需要使用next数组，实现跳转
            // 这里使用while的原因在于：有可能回退的位置并不理想，所以需要使用while，找到一个合适的位置
            // ps：这个循环是KMP算法中主要的字符串匹配过程的一部分。它负责根据存储在 next 数组中的信息，调整模式字符串 (p) 中的索引 idx。如果文本字符串 (s) 中的字符与模式字符串 (p) 中的当前字符不匹配，这个循环会有效地将 idx 移回到一个位置，其中模式的前缀与到目前为止的后缀匹配，从而跳过不必要的比较。
            while (idx > 0 && s.charAt(i) != p.charAt(idx)) {
                idx = next[idx - 1];
            }
            if (s.charAt(i) == p.charAt(idx)) {
                idx++;
            }
            if (idx == p.length()) {
                ans.add(i - p.length() + 1);
                idx = next[idx - 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        KMPV2 kmp = new KMPV2();
        System.out.println(kmp.search("aabaabaabaabx", "aabaabx"));

    }
}


