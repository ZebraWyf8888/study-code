package macleetcode.code1.vivo;

public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int solution = solution4.solution(11);

        System.out.println(solution);
        System.out.println("-----------");
    }
    /**
     *
     * @param n int整型 第n天
     * @return int整型
     */
    public int solution (int n) {
        // write code here
        int temp = 0;

        System.out.println();
        for (int i = 1; i <=n ; i++) {
            temp  = temp+ask(i);
            System.out.println(temp);
            System.out.println();
        }
        return temp;
    }

    private static int ask(int n) {
        int a = 0;
        for (int i = 1; ; i++) {
            a++;
            n = n-i;
            if (n <= 0) {
                break;
            }
        }
        return a;
    }
}