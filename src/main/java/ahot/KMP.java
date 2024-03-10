package ahot;

public class KMP {
    public static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        lps[0] = 0;
        int i = 1;
        int j = 0;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static int kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int i = 0;
        int j = 0;
        int matches = 0;
        int[] lps = buildLPS(pattern);
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                matches++;
                j = lps[j - 1];
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        String text = "ABCABCABC";
        String pattern = "ABC";
        int matches = kmpSearch(text, pattern);
        System.out.println("Number of matches: " + matches);
    }
}
