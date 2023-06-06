package 腾讯音乐;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 256M，其他语言512M
 *
 * 给定一个只包含小写字母字符串，每次可以选择两个相同的字符删除，并在字符串结尾新增任意一个小写字母。
 * 请问最少多少次操作后，所有的字母都不相同？
 *
 * 输入例子1:
 * "abab"
 *
 * 输出例子1:
 * 2
 *
 * 例子说明1:
 * 第一次操作将两个'a'变成一个'f'，字符串变成"bbf"。
 * 第二次操作将两个'b'变成一个'b'，字符串变成"fb"。
 * 操作方式不是唯一的，但可以证明，最少操作次数为2。
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 00:05
 */
public class 字符串操作 {
    public int minOperations (String str) {
        // 1. 先统计每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        // 最少操作次数
        int res = 0;
        // 26个字母出现的次数
        int aa = 0;
        System.out.println(map);
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count == 1) {
                aa += 1;
            } else if (count % 2 == 0) {
                res += (count / 2); //消除n个字符，需要n/2次操作
                aa += (count / 2); //消耗n/2个字母
            } else {
                res += (count / 2); //消除n个字符，需要n/2次操作
                aa += (count / 2 + 1); //消耗n/2个字母加上余出的1个字母
            }
        }
        // 超出26个字母的部分，需要额外的操作
        // 每2个字母，需要1次额外操作
        if (aa > 26) {
            res += (aa - 26);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new 字符串操作().minOperations("aaaaabbc");
        System.out.println(res);
    }
}
