package macleetcode.day731;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

/**
 * 快速幂1：
 *
 * 作者：毫克迈斯
 * 链接：https://www.nowcoder.com/discuss/464062?source_id=profile_create&channel=666
 * 来源：牛客网
 *
 * 小强是一个农场主，农场里有n头牛，每头牛有着独一无二的体重，每一头牛的颜色可能跟是m种颜色其中的一种，小强带了一些牛（可能为0个）出来吃草。你需要回答出小强带出来的牛的组合一共有多少种可能？
 *
 * 注意：因为一头牛有自己的体重（没有两头牛体重相等），所以如果四头牛的体重分别是1,2,3,4，颜色分别是y1,y2,y3,y4和另一种方案：四头牛的体重分别是1,2,3,4颜色分别是y1,y3,y2,y4即使两个方案的颜色的种类对应的数量是相同的，但是因为颜色对应的体重不同，所以是两个不同的方案。
 * 由于方案书可能很大，请对1e9+7取模。
 * 输入描述：
 * 两个整数n,m(1≤n,m≤10^9)
 * 输入： 3,2
 *
 * 输出： 27
 * error：先把公式写出来，查看规律，发现可以变为二项式，转为"1个"幂运算，这个幂运算在用快速幂求解
 */
public class Main2 {
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
        int r =1;
        int base = small;
        while (big!=0) {
            if ((big&1) != 0) {
                r = r*base;
            }
            base *= base;
            big >>=1;
        }
        return r;
    }
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