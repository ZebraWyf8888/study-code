package macleetcode.code3; /**
 资源限制
 时间限制：1.0s   内存限制：512.0MB
 问题描述
 　　给定n个十六进制正整数，输出它们对应的八进制数。

 输入格式
 　　输入的第一行为一个正整数n （1<=n<=10）。
 　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。

 输出格式
 　　输出n行，每行为输入对应的八进制正整数。

 　　【注意】
 　　输入的十六进制数不会有前导0，比如012A。
 　　输出的八进制数也不能有前导0。

 样例输入
 　　2
 　　39
 　　123ABC

 样例输出
 　　71
 　　4435274

 　　【提示】
 　　先将十六进制数转换成某进制数，再由某进制数转换成八进制。

 */
import java.util.*;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < n ; i++) {
            String s = sc.next();
            Integer integer = Integer.valueOf(s, 16);

            String s1 = Integer.toString(Integer.parseInt(s), 16);


            int i1 = Integer.parseInt(s1);
            arrayList.add(i1);
        }
        for (int a:arrayList) {
            System.out.println(a);
        }
    }

    //升级版本的解法
    //把一个是数字-1都是把原来那个数字的最右边的1变成0
    //基于上面这句话再让 原来那个数字与他减去一之后的数字做与运算，得到的结果就是
    //最左边的1变0，其他数字不变
    public static int NumberOf12(int n) {
        int count = 0;
        while (n!=0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}