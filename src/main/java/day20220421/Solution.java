package day20220421;


class Solution {
    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            builder.append(dealWith(s[i]));
            for (int j = 0; j < i+1; j++) {
                builder.append("a");
            }
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    private String dealWith(String s1) {
        if (s1 == null) {
            return "";
        }
        int length = s1.length();
        if (s1.startsWith("a") ||
                s1.startsWith("e") ||
                s1.startsWith("i") ||
                s1.startsWith("o") ||
                s1.startsWith("u") ||
                s1.startsWith("A") ||
                s1.startsWith("E") ||
                s1.startsWith("I") ||
                s1.startsWith("O") ||
                s1.startsWith("U") || length <=1) {
                return s1 +"ma";
        }else {
            return s1.substring(1)+s1.charAt(0)+"ma";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.toGoatLatin("The quick brown fox jumped over the lazy dog");
        System.out.println(s);

        boolean equals = "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa".equals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa");
        System.out.println(equals);
    }
}