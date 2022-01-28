package java8.com.offer;

import java.util.ArrayList;

/**
 * @Author: WYF
 * @Description: 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @Create: 2020/1/13 17:09
 * @Version: 1.0
 */
public class Permutation {
    public ArrayList<String> permutationHelp(StringBuilder str) {
        ArrayList<String> result = new ArrayList<String>();
        if(str.length() == 1) {
            result.add(str.toString());
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (i == 0 || str.charAt(i) != str.charAt(0)) {
                    char temp = str.charAt(i);
                    str.setCharAt(i, str.charAt(0));
                    str.setCharAt(0, temp);
                    ArrayList<String> newResult =
                            permutationHelp(new StringBuilder(str.substring(1)));
                    for(int j = 0; j < newResult.size(); j++) {
                        result.add(str.substring(0, 1) + newResult.get(j));
                    }
                    //用完还是要放回去的
                    temp = str.charAt(0);
                    str.setCharAt(0, str.charAt(i));
                    str.setCharAt(i, temp);
                }
            }
            //需要在做一个排序操作
        }
        return result;
    }

    public ArrayList<String> permutation(String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        ArrayList<String> result = permutationHelp(strBuilder);
        return result;
    }
}
