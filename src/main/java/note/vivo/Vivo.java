package note.vivo;

import java.util.ArrayList;
import java.util.List;


/**
 * 数位之积
 * 现给定任意正整数n,请寻找并输出最小的正整数m(m>9),使得m的各位（个位、十位...）之乘积等于n,若不存在则输出-1.
 * 逆向思维，从高位开始考虑不行，就从地位开始
 */
public class Vivo {
    public static void main(String[] args) {
        int res = Solution(22);
        System.out.println(res);
    }
    public static int Solution(int n){
        int res = resolve(n);
        if(res>0)
        {
            return res;
        }
        return -1;
        /**
         * 没有这个的话，有可能负数的情况，用例22，返回-10+2
        */
    }
    public static int resolve(int n)
    {
        if(n<10)
        {
            return n;
        }
        for (int i = 9; i >1 ; --i) {
            if(n%i == 0)
            {
                return resolve(n/i)*10+i;
            }
        }
        return -1;
    }
}


