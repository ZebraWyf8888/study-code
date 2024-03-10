package day20240310;

import java.util.HashMap;

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                if (map2.getOrDefault(secret.charAt(i), 0) != 0) {
                    map2.put(secret.charAt(i), map2.get(secret.charAt(i)) - 1);
                    cows++;
                } else {
                    map1.put(secret.charAt(i), map1.getOrDefault(secret.charAt(i), 0) + 1);
                }
                if (map1.getOrDefault(guess.charAt(i), 0) != 0) {
                    map1.put(guess.charAt(i), map1.get(guess.charAt(i)) - 1);
                    cows++;
                } else {
                    map2.put(guess.charAt(i), map2.getOrDefault(guess.charAt(i), 0) + 1);
                }
            }
        }


        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";

    }
}
