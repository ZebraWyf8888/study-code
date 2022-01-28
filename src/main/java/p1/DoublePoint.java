package p1;

/**
* @Author: WYF
* @Description: https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
* @Create: 2020/5/3 15:34
* @Version: 1.0
*/
public class DoublePoint {
    /**
     * @Description: 暴力破解
     * @Param: [height]
     * @Return: int
     * @Author: WYF
     * @Date: 2020/5/3 15:35
    */
    public int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                int s = (j-i)*Math.min(height[i], height[j]);
                max = Math.max(max, s);
            }
        }
        return max;
    }

    public int maxArea1(int[] height) {
        int max = 0;
        int right = height.length-1;
        int left = 0;
        while (left<right){
            int s = (right-left)*Math.min(height[right], height[left]);
            max = Math.max(max, s);
            if (height[right] >= height[left]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

    /**
     * @Description: Main
     * @Param: [args]
     * @Return: void
     * @Author: WYF
     * @Date: 2020/5/3 15:35
    */
    public static void main(String[] args) {
        DoublePoint doublePoint = new DoublePoint();
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        int i = doublePoint.maxArea1(arr);
        System.out.println(i);
    }
}
