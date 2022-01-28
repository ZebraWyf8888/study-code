package day20220127;

import com.sun.deploy.util.StringUtils;

class Solution {
    /**
     * 1 <= sentence.length <= 1000
     * sentence 由小写英文字母、数字（0-9）、以及字符（' '、'-'、'!'、'.' 和 ','）组成
     * 句子中至少有 1 个 token
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
     * <p>
     * 仅由小写字母、连字符和/或标点（不含数字）。
     * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
     * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
     * <p>
     * sentence 由小写英文字母、数字（0-9）、以及字符（' '、'-'、'!'、'.' 和 ','）组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param sentence
     * @return
     */
    public int countValidWords(String sentence) {
        String[] s = sentence.split(" ");
        int count = 0;
        for (String s1 : s) {
            if (isValid(s1)) {
                count++;
            }
        }
        return count;
    }

    private boolean containNumber(String s1) {
        boolean matches = s1.matches(".*[0-9]{1,}.*");
        return matches;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


        int i = solution.countValidWords("cat and  dog");
        System.out.println(i);


    }

    public boolean isValid(String word) {
        int n = word.length();
        boolean hasHyphens = false;
        if (n > 0 && word.trim().length()>0) {
            for (int i = 0; i < n; i++) {
                if (Character.isDigit(word.charAt(i))) {
                    return false;
                } else if (word.charAt(i) == '-') {
                    if (hasHyphens == true || i == 0 || i == n - 1 || !Character.isLetter(word.charAt(i - 1)) || !Character.isLetter(word.charAt(i + 1))) {
                        return false;
                    }
                    hasHyphens = true;
                } else if (word.charAt(i) == '!' || word.charAt(i) == '.' || word.charAt(i) == ',') {
                    if (i != n - 1) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;

    }

}