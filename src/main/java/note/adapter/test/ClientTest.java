package note.adapter.test;

import java.util.Arrays;

public class ClientTest {
    public static void main(String[] args) {
        /**
         * @Description: 说明一下，我使用的是对象适配器，灵活一点
         * 以下是测试，objectAdapter已经适配了两种功能，可以二分查，可以快排
        */
        ObjectAdapter objectAdapter = new ObjectAdapter();
        int[] nums={2,3,5,7,-5,0,1};
        /**
         * @Description: 快排，升序输出
        */
        objectAdapter.sort(nums);
        System.out.println(Arrays.toString(nums));
        /**
         * @Description: 二分查找，两个条件：1.有序排列 2.顺序存储（可以随机访问）
         * 找数组里7对应的索引为6
         */
        int search = objectAdapter.search(nums, 7);
        System.out.println(search);
    }
}
