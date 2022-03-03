package aaaahot;

public class 第k大的数字 {
    /**
     * 快排寻找第k大大数字，不交换节点
     *
     * @param args
     */
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        int[] arr = new int[]{3, 5, 1, 6, 4, 7, 8, 2};
        System.out.println(findKthNum(arr, 3));
    }

    /**
     * 快排，第k大的数字
     *
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        // write code here
        return findKthNum(a, K);
    }

    public static int findKthNum(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        k -= 1;
        while (l < r) {
            int idx = partition(nums, l, r);
            if (idx == k) {
                break;
            } else if (idx > k) {
                r = idx - 1;
            } else if (idx < k) {
                l = idx + 1;
            }
        }
        return nums[k];
    }

    public static int partition(int[] nums, int l, int r) {
        int key = nums[l];
        while (l < r) {
            while (l < r && nums[r] <= key) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] >= key) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = key;
        return l;
    }

    public int quickSort(int[] a, int low, int high, int K) {
        if (low > high) {
            return -1;
        }
        int i = low;
        int j = high;
        int temp;

        while (i < j) {
            while (i < j && a[j] <= a[low]) {
                j--;
            }
            while (i < j && a[i] >= a[low]) {
                i++;
            }
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;

        }
        temp = a[i];
        a[i] = a[low];
        a[low] = temp;
        if (i == K - 1) {
            return a[i];
        } else if (i > K - 1) {
            return quickSort(a, low, i - 1, K);
        } else {
            return quickSort(a, j + 1, high, K);
        }
    }

}