package macleetcode.day1201;

import java.math.BigDecimal;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a= new int[]{2,3,4};

//        System.out.println(solution.Answerofjudge(a));
        System.out.println(solution.Maximumlength("abcdefghijklmn"));
        System.out.println(solution.Maximumlength("ynp"));
        System.out.println(solution.Maximumlength("ypknnbpiyc"));
        System.out.println(solution.Maximumlength("ypknnbpiyc"));

    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 给定一个后缀表达式，返回它的结果
     * @param str string字符串
     * @return long长整型
     */
    public long solve (String str) {
        Stack<Long> stack = new Stack<>();
        String num = "";
        long x1,x2;
        for(int i = 0;i < str.length();++i)
        {
            char c = str.charAt(i);
            if(c == '#')
                continue;
            if(c == '+')
            {
                x1 = stack.pop();
                x2 = stack.pop();
                stack.push(x1 + x2);
            }
            else if(c == '-')
            {

                x1 = stack.pop();
                x2 = stack.pop();
                stack.push(x2 - x1);

            }
            else if(c == '*')
            {
                x1 = stack.pop();
                x2 = stack.pop();
                stack.push(x1 * x2);
            }
            else
            {
                num = "";
                while(c != '#')
                {
                    num += c;
                    i++;
                    c = str.charAt(i);
                }
                stack.push(Long.parseLong(num));
            }
        }
        return stack.pop();
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回符合题意的最长的子串长度
     * @param x string字符串
     * @return int整型
     */
    public int Maximumlength (String x) {
        // write code here
        int ans = 0;
        int count = 0;//当前最大符合题意子串
        char[] chars = x.toCharArray();

        int n = -1;//n出现的索引
        int p = -1;//p出现的索引
        int y = -1;//y出现的索引
        for (int i = 0; i < chars.length; i++) {
            //分情况记录
            if (chars[i] == 'n') {
                n = i;
            } else if (chars[i] == 'p'){
                p = i;
            }else if (chars[i] == 'y'){
                y = i;
            }

            //npy同时出现，把最小的index（i）替换，重置count
            if (n != -1&& p!= -1 &&y!=-1) {
                int min = -1;
                if (n<p&&n<y) {
                    min =n;
                    n = -1;

                }else if (p<y&&p<n) {
                    min = p;
                    p = -1;

                }else {
                    min =y;
                    y = -1;

                }

                ans = Math.max(ans,count );
                count = i-min;
            } else {
                count ++;
                ans = Math.max(ans,count );

            }

        }
        return ans;
    }




    /**
     *
     * @param arr int整型一维数组
     * @return int整型
     */
    public int Answerofjudge (int[] arr) {
        // write code here
        //先求平均数
        double count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = count + arr[i];
        }

        double avg = count/arr.length;
        double mid = 0;


        BigDecimal b1 = new BigDecimal(Double.toString(avg));

        if (arr.length%2 != 0) {
            mid = quickSortFind(arr, 0, arr.length-1, arr.length/2);
        }else {
            double m1 = quickSortFind(arr, 0, arr.length-1, arr.length/2);
            double m2 = quickSortFind(arr, 0, arr.length-1, arr.length/2-1);
            mid = (m1+m2)/2;
        }

        BigDecimal b2 = new BigDecimal(Double.toString(mid));

        return b2.compareTo(b1);
    }

    /**
     *
     * @param arr
     * @param low
     * @param high
     * @param target 第n大数字的索引
     * @return 第n大数字
     */
    private static int quickSortFind(int[] arr, int low, int high,int target) {
        int i = low;
        int j = high;
        int temp;

        while (i < j) {
            while (arr[j] >= arr[low] && i < j) {
                j--;
            }
            while (arr[i] <= arr[low] && i < j) {
                i++;
            }

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }

        temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        if (target == j) {
            return arr[j];
        } else if (target < j) {
            return quickSortFind(arr, low, j-1, target);
        } else {
            return quickSortFind(arr, j+1, high, target);
        }
    }


}
