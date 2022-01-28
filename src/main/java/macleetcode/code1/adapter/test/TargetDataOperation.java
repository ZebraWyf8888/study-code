package macleetcode.code1.adapter.test;

/**
 * @Author: WYF
 * @Description: 适配器接口
 */
public interface TargetDataOperation {
     /**
     * @Description: 快速排序
     * @Param: []
     * @Return: void
    */
    void sort(int[] arr);
    /**
     * @Description: 二分查找
     * @Param: [a, target]
     * @Return: int
     * @Author: WYF
     * @Date: 2020/5/24 21:10
    */
    int search(int[] a, int target);
}
