package macleetcode.code1.vivo;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static int solution (int n) {
        // write code here
        List<Integer> m = new ArrayList<>();
        if (n < 10){
            return 10 + n;
        }

        while (n >= 10){
            for (int i = 9; i >= 2; i--) {
                if (0 == n % i){
                    m.add(i);
                    n = n / i;
                    break;
                }
                if (2 == i) {return -1;}
            }
        }

        m.add(n);
        int ans = 0;
        System.out.println(m);
        for (int i = 0; i < m.size(); i++) {
            ans += m.get(i) * Math.pow(10, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(108));
    }
}
