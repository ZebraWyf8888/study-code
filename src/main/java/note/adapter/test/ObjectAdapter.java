package note.adapter.test;



/**
* @Author: WYF
* @Description: 适配器，适配快排+二分查找
* @Create: 2020/4/13 16:34
* @Version: 1.0
*/
public class ObjectAdapter implements TargetDataOperation {
    private QuickSort quickSort;
    private MidFind midFind;
    @Override
    public void sort(int[] arr) {
        quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length-1);
    }

    @Override
    public int search(int[] a, int target) {
        midFind = new MidFind();
        return midFind.search(a, 0, a.length-1, target);
    }
}
