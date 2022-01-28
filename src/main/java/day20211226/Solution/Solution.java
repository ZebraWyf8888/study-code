package day20211226.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] split = text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(first) && i+1<split.length && split[i+1].equals(second) && i+2<split.length) {
                ans.add(split[i+2]);
            }
        }
        return ans.toArray(new String[ans.size()]);

    }
}