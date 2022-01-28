package macleetcode.code3.question;

import java.util.Scanner;

/**
* @Author: WYF
* @Description:  假设今日是2015年3月1日，星期日，请算出13个月零6天后是星期几，距离现在多少天？
* @Create: 2020/4/24 0:31
* @Version: 1.0
*/

public class Demo4 {
    public static String[] week = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
    public static int i = 0;
    public static int[] monthday1 = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static int[] monthday2 = {0,31,29,31,30,31,30,31,31,30,31,30,31};

    //查看距离当前天数的差值
    public static String distance(int year,int month,int day,int newMonth,int newDay) {
        int sum = 0; //设定初始距离天数
        //多一个判断，去除一种今年是润年,并且在二月前的情况的情况
        if ((((year) % 4 == 0 && (year) % 100 != 0)||(year) % 400 == 0)
                &&(month<3)) {
            if (newMonth >= 12) {
                sum += 366 + newDay;
                for(int i = 0;i < newMonth - 12;i++) {
                    sum += monthday1[month + i];
                }
            }else {
                for(int i = 0;i < newMonth;i++) {
                    sum += monthday1[month + i];
                }
                sum += newDay;
            }
        }
        if (newMonth >= 12) {
            if (((year + 1) % 4 == 0 && (year + 1) % 100 != 0)||(year + 1) % 400 == 0) {//是
                sum += 366 + newDay;
                for(int i = 0;i < newMonth - 12;i++) {
                    sum += monthday1[month + i];
                }
            } else {//不是
                sum += 365 + newDay;
                for(int i = 0;i < newMonth - 12;i++) {
                    sum += monthday1[month + i];
                }
            }
        } else {
            for(int i = 0;i < newMonth;i++) {
                sum += monthday1[month + i];
            }
            sum += newDay;
        }
        return week[(sum+day)%7];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入当前年份");
        int year = scanner.nextInt();
        System.out.println("请输入当前月份");
        int month = scanner.nextInt();
        System.out.println("请输入当前天数");
        int day = scanner.nextInt();
        System.out.println("请输入当前是星期几：以数字表示，如：星期天 为 0");
        int index = scanner.nextInt();
        System.out.println("今天是：" + year + "-" + month + "-" + day + "  " + week[index]);

        System.err.println("请输入相隔月份");
        int newMonth = scanner.nextInt();
        System.out.println("请输入剩余天数");
        int newDay = scanner.nextInt();

        System.out.println("经过" + newMonth + "月" + newDay + "天后，是" + distance(year,month,day,newMonth,newDay));
    }
}
