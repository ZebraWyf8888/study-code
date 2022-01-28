package macleetcode.code3.com.sort;



/**
* @Author: WYF
* @Description: 利用快速排序查第n大的数字：
 * 基本思想：快速排序结合上二分查找
* @Create: 2020/5/24 18:37
* @Version: 1.0
*/
public class UseQucikSort {


    public static void main(String[] args) {
        int[] arr = new int[]{9,4,3,7,6,2,8,5};
        int target = 3;
        int num = findTarget(arr, target);
        System.out.println(num);
    }

    private static int findTarget(int[] arr, int target) {
        int num;
        int length = arr.length;
        if (target<=length) {
            /**
             * @Description: eg 在长度为8的数组里，第一大的数字对应索引为7，第二大对应为 6，处理target
            */
            target = length - target;
            num = quickSortFind(arr,0 ,arr.length-1, target);
            return num;
        }else {
            throw new RuntimeException("请输入正确目标数字");
        }
    }

    private static int quickSortFind(int[] arr, int low, int high,int target) {
        int i = low;
        int j = high;
        int temp;

        while (i < j) {
            while (arr[j] >= arr[low] && i < j) {
                j--;
            }
            while (arr[i] <= arr[low] && i < j) {
                i++;
            }

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }

        temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        if (target == j) {
            return arr[j];
        } else if (target < j) {
            return quickSortFind(arr, low, j-1, target);
        } else {
            return quickSortFind(arr, j+1, high, target);
        }
    }
}
