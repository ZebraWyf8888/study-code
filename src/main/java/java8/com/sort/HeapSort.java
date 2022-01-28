package java8.com.sort;
//
//import java.util.Arrays;
//
///**
// * @Author: WYF
// * @Description: 构造小根堆（注意：小根堆就要先初始化大根堆，这样沉底出来才是小根堆）
// * @Create: 2020/4/2 21:02
// * @Version: 1.0
// */
//public class HeapSort {
//    public static void main(String[] args) {
//        int[] arr =  {9,8,7,6,5,4,3,2,1};
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
//    }
//
//
//    private static void sort(int[] arr) {
//        /** 1.构造大根堆
//         *  为什么是arr.len/2-1?废话，只有arr.len/2-1才能保证他是非叶子节点
//         *  注意：索引从0开始
//         */
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            adjustHeap(arr, i, arr.length);
//        }
//
//        System.out.println(Arrays.toString(arr));
//        /**
//         * 2.大根堆的堆顶沉底，重新调整结构
//         * i不断减小，确定的元素不断增多
//         */
//        for (int i = arr.length - 1; i > 0; i--) {
//            swap(arr, 0, i);
//            /**
//             * 此处为何是0，次大的数字一定在堆顶的俩边
//             */
//            adjustHeap(arr, 0, i);
//        }
//    }
//
//
//    public static void swap(int[] arr, int i, int i1) {
//        int temp = arr[i];
//        arr[i] = arr[i1];
//        arr[i1] = temp;
//    }
//
//    /**
//     * @Description: 对该节点调整，以保证该节点：根>左>右
//     * 最优：取根节点为保存在temp，左右找一个大的来和temp比较，比较成功就交换，否则不变
//     * @Param: [arr, i, length]
//     * @Return: void
//     * @Author: WYF
//     * @Date: 2020/4/2 21:32
//     */
//    private static void adjustHeap(int[] arr, int i, int length) {
//        /**这里我发现数组存放的二叉树的节点可以从0开始，也可以从1
//         * 这两种对应的子节点不一样的，有个是i/2+1和i/2+2（从0开始），有个是i/2和i/2+1（从一开始）
//         * 先取出当前元素i
//         */
//        int temp = arr[i];
//        /**
//         * 从i结点的左子结点开始，也就是2i+1处开始
//         * 这个循环很有意义，是标志着重新调整结构，因为有可能被这么一整，顺序乱了
//         */
//        //多此比较 直到把temp找到一合适的位置，即调整堆结构，让它还是一个堆，不会因为头尾交换改变结构
//        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
//            if (k + 1 < length && arr[k] < arr[k + 1]) {
//                k++;
//            }
//            /**
//             * 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
//             */
//            if (arr[k] > temp) {
//                arr[i] = arr[k];
//                i = k;
//            } else {
//                break;
//            }
//        }
//        /**
//         * 放回去
//         */
//        arr[i] = temp;
//    }
//
//}
//


import java.util.Arrays;

/**
 * @Author: WYF
 * @Description: 构造小根堆（注意：小根堆就要先初始化大根堆，这样沉底出来才是小根堆）
 * @Create: 2020/4/2 21:02
 * @Version: 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr =  {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void sort(int[] arr) {
        /** 1.构造大根堆
         *  为什么是arr.len/2-1?废话，只有arr.len/2-1才能保证他是非叶子节点
         *  注意：索引从0开始
         */
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //System.out.println(Arrays.toString(arr));
        /**
         * 2.大根堆的堆顶沉底，重新调整结构
         * i不断减小，确定的元素不断增多
         */
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            /**
             * 此处为何是0，次大的数字一定在堆顶的俩边
             */
            adjustHeap(arr, 0, i);
        }
    }


    public static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    /**
     * @Description: 对该节点调整，以保证该节点：根>左>右
     * 最优：取根节点为保存在temp，左右找一个大的来和temp比较，比较成功就交换，否则不变
     * @Param: [arr, i, length]
     * @Return: void
     * @Author: WYF
     * @Date: 2020/4/2 21:32
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        /**这里我发现数组存放的二叉树的节点可以从0开始，也可以从1
         * 这两种对应的子节点不一样的，有个是i/2+1和i/2+2（从0开始），有个是i/2和i/2+1（从一开始）
         * 先取出当前元素i
         */
        int temp = arr[i];
        /**
         * 从i结点的左子结点开始，也就是2i+1处开始
         * 这个循环很有意义，是标志着重新调整结构，因为有可能被这么一整，顺序乱了
         */
        //多此比较 直到把temp找到一合适的位置，即调整堆结构，让它还是一个堆，不会因为头尾交换改变结构
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            /**
             * 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
             */
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        /**
         * 放回去
         */
        arr[i] = temp;
    }

}


