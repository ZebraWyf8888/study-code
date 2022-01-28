package macleetcode.code3.question;

import java.util.Scanner;

/**
 * @Author: WYF
 * @Description: 输入年月日，计算该日期是这一年的第几天。
 * @Create: 2020/4/23 23:38
 * @Version: 1.0
 */
public class TheDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入年月日(1980 11 28): ");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int date = sc.nextInt();
        int[] data;
        //判断是不是润年
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {//是
            data = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        } else {
            data = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }
        int sum = date;
        for (int i = 0; i < month - 1; i++) {
            sum += data[i];
        }
        System.out.println(sum);
    }
}
