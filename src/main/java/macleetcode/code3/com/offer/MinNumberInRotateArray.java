package macleetcode.code3.com.offer;
import java.util.ArrayList;

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array ==null||array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end){
            mid = start + (end - start) / 2;
            if (array[mid+1] < array[mid]) {
                return array[mid+1];
            }
            //前半部分有序,注意此处用小于等于
            if (array[start] <= array[mid]) {
                start = mid-1;
            } else {
                end = mid+1;
            }
        }
        return -1;
    }
}
//        int i = 0, j = array.length - 1;
//        while (i < j) {
//        if (array[i] < array[j]) {
//        return array[i];
//        }
//        int mid = (i + j) >> 1;
//        if (array[mid] > array[i]) {
//        i = mid + 1;
//        } else if (array[mid] < array[j]) {
//        j = mid; // 如果是mid-1，则可能会错过最小值，因为找的就是最小值
//        } else i++;  // 巧妙避免了offer书上说的坑点（1 0 1 1 1）
//        }
//        return array[i];