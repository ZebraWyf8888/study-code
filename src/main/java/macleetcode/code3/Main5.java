package macleetcode.code3;

/**
* @Author: WYF
* @Description: 辗转相除法
* @Create: 2020/2/13 19:44
* @Version: 1.0
*/
public class Main5 {
    public static void main(String[] args) {
        int a = 40;
        int b = 15;

        while (true){
            if (a>b){
                a = a % b;
                if (a == 0){
                    System.out.println(b);
                    break;
                }
            }else {
                b = b % a;
                if (b == 0){
                    System.out.println(a);
                    break;
                }
            }
        }
    }
}
