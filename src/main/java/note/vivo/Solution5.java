package note.vivo;

public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.solution(11));
    }
    /**
     *
     * @param n int整型 第n天
     * @return int整型
     */
    public int solution (int n) {
        // write code here
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            temp = temp + ask(i);
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
