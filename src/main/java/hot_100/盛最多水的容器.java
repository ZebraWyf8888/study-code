package hot_100;

/**
 * 盛最多水的容器
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/4/28 00:29
 */
public class 盛最多水的容器 {
    /***
     * 暴力破解，O(n^2)
     */
//    public int maxArea(int[] height) {
//        int sum = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int temp = (j - i) * Math.min(height[i], height[j]);
//                sum = Math.max(sum, temp);
//            }
//        }
//        return sum;
//    }

    /***
     * 双指针，O(n)
     */
    public int maxArea(int[] height) {
        int sum = 0;
        //左指针指向第一个元素，右指针指向最后一个元素（注意指针存的都是数组的下标）
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            // 左指针和右指针形成的容器乘水量为：两者之前下标差为宽，高为两者之间的最小值
            int temp = (right - left) * Math.min(height[left], height[right]);
            sum = Math.max(sum, temp);
            if (height[left] < height[right]) {
                // 左指针小于右指针，左指针向右走，才有增大sum值的可能性，因为left值有可能变大，对应高度就可能增加
                // 而如果是右指针向左走，那么不论右指针怎么移，sum值都不会增大，因为高度最大就为left值，而宽不断在缩小，sum值只会缩小
                left ++;
            } else {
                // 右指针小于左指针，右指针向左走，才有增大sum值的可能性，因为right值有可能变大，对应高度就可能增加
                // 而如果是左指针向右走，那么不论左指针怎么移，sum值都不会增大，因为高度最大就为right值，而宽不断在缩小，sum值只会缩小
                // 注意：这里还包含left==right的情形，如果是相等，左指针向右移或右指针向左移都一样
                right --;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,18,17,6};
        int res = new 盛最多水的容器().maxArea(arr);
        System.out.println(res);
    }
}
