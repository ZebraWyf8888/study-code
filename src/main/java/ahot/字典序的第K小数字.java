package ahot;

/**
 * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 */
public class 字典序的第K小数字 {
    public int findKthNumber(int n, int k) {
        int curr = 1;//初始化为cur = 1，k需要自减1
        //那么这就是先序遍历十叉树的问题，难点就变成了如何计算出每个节点的子节点的个数，
        k--;
        while (k > 0) {
            /**
             本质是一个10叉树的先序遍历,找到按照先序遍历的第k个节点
             为什么是先序遍历?这个由字典序的性质决定:[1,10,100,1000,1001]
             假设相同位数的数字在10叉树的同一层上,那么就是先序遍历就是字典序排列
             从cur=1开始进行遍历,先计算的以cur为根的且<=n的节点个数nodes
             */
            int steps = getSteps(curr, n);
            if (steps <= k) {
                //说明以cur开头的合格节点数不够,cur应该向右走:cur++
                k -= steps;
                curr++;
            } else {
                /**
                 在子树内，10倍
                 */
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    /**
     * /*
     * 计算[1,n]内以cur为根(开头)的节点个数
     */
    public int getSteps(int curr, long n) {
        int steps = 0;
        //最左边
        long first = curr;
        //最右边
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }

    public static void main(String[] args) {
        字典序的第K小数字 a = new 字典序的第K小数字();

        a.findKthNumber(109,108);
    }
}