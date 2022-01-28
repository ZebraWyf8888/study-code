package java8.com.offer;

public class NumberOf1 {
    //这是初级版本
    public static int NumberOf1(int n) {
        int x = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((x&n) != 0) {
                count++;
            }
            x = x<<1;
        }
        return count;
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

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 2001; i++) {
            sum +=NumberOf12(i);
        }
        System.out.println(sum);
    }
}
