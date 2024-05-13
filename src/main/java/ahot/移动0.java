package ahot;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class 移动0 {
    public void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
    }
    public void moveZeroesV2(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j ++;
            }
        }
      
    }

    @Test
    public void testmoveZeroesV2() {
        // 测试用例1: 空数组
        int[] input1 = new int[]{};
        int[] expectedOutput1 = new int[]{};
        moveZeroesV2(input1);
        assertArrayEquals(expectedOutput1, input1);

        // 测试用例2: 数组中没有零元素
        int[] input2 = new int[]{1, 2, 3, 4, 5};
        int[] expectedOutput2 = new int[]{1, 2, 3, 4, 5};
        moveZeroesV2(input2);
        assertArrayEquals(expectedOutput2, input2);

        // 测试用例3: 数组中只有零元素
        int[] input3 = new int[]{0, 0, 0, 0};
        int[] expectedOutput3 = new int[]{0, 0, 0, 0};
        moveZeroesV2(input3);
        assertArrayEquals(expectedOutput3, input3);

        // 测试用例4: 数组中混合有零和非零元素
        int[] input4 = new int[]{0, 1, 0, 3, 12, 0, 5};
        int[] expectedOutput4 = new int[]{1, 3, 12, 5, 0, 0, 0};
        moveZeroesV2(input4);
        assertArrayEquals(expectedOutput4, input4);

        // 测试用例5: 数组只有一个零元素在开头
        int[] input5 = new int[]{0, 2, 3, 4};
        int[] expectedOutput5 = new int[]{2, 3, 4, 0};
        moveZeroesV2(input5);
        assertArrayEquals(expectedOutput5, input5);

        // 测试用例6: 数组只有一个零元素在结尾
        int[] input6 = new int[]{1, 2, 3, 0};
        int[] expectedOutput6 = new int[]{1, 2, 3, 0};
        moveZeroesV2(input6);
        assertArrayEquals(expectedOutput6, input6);
    }
}
