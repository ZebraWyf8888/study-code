package ahot;

import java.util.ArrayList;
import java.util.List;

public class 三数之和 {
    /**
     * 三数之和，难度在去重
     * 这个函数是一个用于解决三数之和问题的Java函数。三数之和问题是指在一个整数数组中，找出所有三个整数的和等于给定值的组合。该函数的实现思路如下：  1. 首先，创建一个空的List<List<Integer>>类型的结果变量ans用于存储符合条件的组合。 2. 对输入的整数数组nums进行快速排序，以保证后续的遍历更加高效。 3. 使用一个for循环遍历整个数组，依次以每个数作为第一个数。 4. 如果当前数和上一个枚举的数不相同，则将其加入到结果列表中。 5. 设置一个指针third指向数组的最后一个元素，设置一个目标值tar为当前数的相反数。 6. 使用另一个for循环遍历当前数之后的数组元素，依次以每个数作为第二个数。 7. 如果当前数和上一个枚举的数不相同，则将其加入到结果列表中。 8. 在内部循环中，使用while循环将指针third向左移动，直到找到第一个小于等于tar的目标值。 9. 如果第二个数和第三个数之和等于tar，则将这三个数加入到结果列表中。 10. 循环结束后，返回结果列表ans。  这个函数的时间复杂度为O(n^2)，其中n是输入数组的长度。
     *
     * 这个函数是解决三数之和问题的。函数使用快速排序对输入数组进行排序，然后使用双重循环来枚举数组中的三个数，找到所有满足三数之和为0的组合，并将结果存储在一个列表中返回。为了避免重复的组合，每次循环都会检查当前枚举的数是否和上一次枚举的数相同，并且保证在内层循环中的第二个数小于第三个数。在内层循环中，通过不断调整第三个指针来逼近满足条件的组合。最后，如果找到了满足条件的组合，则将其添加到结果列表中。
     * @param nums 输入数组
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {

            // 需要和上一次枚举的数不相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int third = nums.length - 1;
            int tar =  - nums[i];

            for (int second = i + 1; second < nums.length; second++) {
                if (second > i+1 && nums[second] == nums[second-1]) {
                    continue;
                }

                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > tar) {
                    --third;
                }
                
                if (second == third){
                    break;
                }

                if (nums[second] + nums[third] == tar) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }

            }

        }
        return ans;
    }

    // 判断一个字符串是不是回文字符串
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left)!= s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 写一个函数计算n的x词幂是多少
       /**
     * 计算指定数的指定次方值
     * 快速幂是一种优化幂运算的算法，可以将时间复杂度从O(x)优化为O(logx)。在这个函数中，使用了快速幂的思想来计算指定数的指定次方值。  具体实现过程如下： 1. 首先初始化result为1，即次方结果的初始值为1。 2. 判断指数x是否大于0，如果小于等于0，则直接返回结果为1。 3. 使用位运算将x右移，同时将底数n平方，不断重复这个步骤，直到x为0。 4. 在每次右移操作后，判断当前的x是否为奇数（即最右边的位为1），如果是奇数，则将result乘以底数n。 5. 返回最终的result值，即为指定数的指定次方值。  这种实现方式通过位运算和平方操作，大大减少了计算的次数，提高了幂运算的效率
     * @param n 基数
     * @param x 指数
     * @return 指定数的指定次方值
     */
    public static int power(int n, int x) {
        int result = 1;
        while (x > 0) {
            if ((x & 1) == 1) {
                result *= n;
            }
            x >>= 1;
            n *= n;
        }
        return result;
    }








    // 写一个快排函数
    public static void quickSortGEN(int[] arr, int left, int right) {
        if (left < right) {
            int i = left, j = right;
            int temp = arr[left];
            while (i < j) {
                while (i < j && arr[j] >= temp) {
                    j--;
                }
                arr[i] = arr[j];
                while (i < j && arr[i] <= temp) {
                    i++;
                }
                arr[j] = arr[i];
            }
        }
    }

    // 写一个在控制台打印爱心的函数
    public static void heart(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i!= j) {
                    System.out.print("❤️");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(ints);


    }
    public static void quickSort(int[] num,int low,int high){
        int i = low;
        int j = high;
        int temp;

        if (i > j) {
            return;
        }
        int k = num[low];

        while (i < j){
            while (num[j] >= k && i < j) {
                j--;
            }

            while (num[i] <= k && i < j) {
                i++;
            }

            if (i < j) {
                temp = num[j];
                num[j] = num[i];
                num[i] = temp;
            }
        }

        temp = num[low];
        num[low] = num[i];
        num[i] = temp;


        quickSort(num,low,i-1);
        quickSort(num,i+1,high);


    }
}
