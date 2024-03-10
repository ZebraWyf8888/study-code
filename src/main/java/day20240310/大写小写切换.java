package day20240310;

public class 大写小写切换 {

    public String capitalizeTitle(String title) {
        String[] s = title.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            stringBuilder.append(toggleCase(s[i]));
            if (i != s.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static StringBuilder toggleCase(String input) {
        StringBuilder result = new StringBuilder();
        if (input == null) {
            return result;
        }
        if (input.length() <= 2) {
            for (char c : input.toCharArray()) {
                result.append(Character.toLowerCase(c));
            }
        } else {
            boolean fist = Boolean.TRUE;
            for (char c : input.toCharArray()) {
                if (fist) {
                    result.append(Character.toUpperCase(c));
                    fist = Boolean.FALSE;
                } else {
                    result.append(Character.toLowerCase(c));
                }
            }
        }

        return result;
    }


}
