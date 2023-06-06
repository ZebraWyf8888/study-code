package 腾讯音乐;

/**
 * 给定一个只包含'0'和'1'两种字符的字符串，每次操作可以选择相邻的两个字符，将它们同时变成'0'或者同时变成'1'。
 * 请问最少多少次操作后，所有的字符都相同？
 *
 * 字符串长度不超过1000。
 * 时间限制：C/C++ 1秒，其他语言2秒
 * 空间限制：C/C++ 256M，其他语言512M
 * 示例1
 * 输入例子：
 * "1001101"
 * 输出例子：
 * 2
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 01:19
 */
public class 串修改 {
    // 无非就是转为全0或者转为全1，分别求转为全0或者全1的最少操作次数
    public int minOperations (String str) {
        int allzero = 0; // 转为全0的操作次数
        int allone = 0; // 转为全1的操作次数
        // 求转为全0的操作次数
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                // 遇到字符1，allzero加1
                allzero++;
                // 不管下一个字符是0还是1，都需要使用i++跳过下一个字符不处理，因为下一个字符都会和当前的1同时变为0
                i++;
            }
        }
        // 求转为全1的操作次数
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                // 遇到字符0，allone加1
                allone++;
                // 不管下一个字符是0还是1，都需要使用i++跳过下一个字符不处理，因为下一个字符都会和当前的0同时变为1
                i++;
            }
        }
        return Math.min(allone, allzero);
    }

    public static void main(String[] args) {
        System.out.println(new 串修改().minOperations("1111111"));
    }
}
