package macleetcode.day731;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

/**
 * 2快速幂1：
 * error：先把公式写出来，查看规律，发现可以变为二项式，转为"1个"幂运算，这个幂运算在用快速幂求解
 */
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n;
        int s;
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        n = in.nextInt();
        s = in.nextInt();
       int sum = pow(n+1,s);
        System.out.println(sum);
    }

    public static int pow(int small, int big) {
        int r = 1;
        int base = small;
        while (big != 0 ){
            if ((big&1) != 0) {
                r = r*base;
            }
            base *= base;
            big >>= 1;
        }

        return r;
    }

//    public static int pow(int small, int big) {
//        int r =1;
//        int base = small;
//        while (big!=0) {
//            if ((big&1) != 0) {
//                r = r*base;
//            }
//            base *= base;
//            big >>=1;
//        }
//        return r;
//    }
}
//}public class day806.Main {
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        int n;
//        int s;
//        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//        n = in.nextInt();
//        s = in.nextInt();
//
//        Long sum = 0l;
//
//        for (int i = 0; i <= n; i++) {
//            double pow = Math.pow(s, i);
//            int count;
//            if (i == 0||i==n) {
//                count =1;
//            }else {
//                count  = count(i, n);
//            }
//            sum = (long) (sum+pow*count);
//        }
//        System.out.println(sum);
//    }
//
//    public static int count(int small,int big){
//        int x1 = 1;
//        for (int k = 0;k<small;k++){
//            x1 = x1*big;
//            big--;
//        }
//        int x2 = 1;
//
//        for (int k = 0;small!=0;k++){
//            x2 = x2*small;
//            small--;
//            if (small == 0){
//                break;
//            }
//        }
//        if (x2 == 0) {
//            return 1;
//        }
//        return x1/x2;
//    }
//}