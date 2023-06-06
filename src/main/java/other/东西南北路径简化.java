package other;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * todo {这里必须加注释}
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/5/21 15:13
 */
public class 东西南北路径简化 {

    public static String[] dirReduc(String[] arr) {
        if (arr == null || arr.length == 0) {
            return new String[] {};
        }
        if (arr.length == 1) {
            return arr;
        }
        // 借助队列，队列存放的是下标
        LinkedList<Integer> queue = new LinkedList<>();
        // 双指针法
        int left = 0;
        int right = 1;
        while (right >= arr.length) {
            if ((arr[left].equals("NORTH") && arr[right].equals("SOUTH")) || (arr[left].equals("SOUTH") && arr[right].equals("NORTH")) || (arr[left].equals("EAST") && arr[right].equals("WEST")) || (arr[left].equals("WEST") && arr[right].equals("EAST"))) {
                if (queue.isEmpty()) {
                    // 队列为空，left指针不需要回退，直接前进
                    left += 2;
                    right += 2;
                } else {
                    // 队列不为空，则left回退到队列头部的下标，right前进一步
                    // 这里直接用poll而不是peek，是因为如果比较不匹配的话，后面会再offer
                    left = queue.poll();
                    right++;
                }
            } else {
                // 两个元素没有合并，则left入队，right继续往后比较
                queue.offer(left);
                left = right;
                right++;
            }
        }
        // 最后一个元素不要忘了加
        if (left == arr.length - 2) {
            queue.offer(left);
        }
        String[] res = new String[queue.size()];
        // 这里需要注意，for循环不能用queue.size()，因为一有元素出队，队列的长度就变更
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            res[i] = arr[queue.poll()];
        }
        return res;
    }

    public static void main(String[] args) {
        //String[] str = new String[] {"NORTH", "SOUTH", "WEST", "EAST"};
        String[] str = new String[] {"NORTH", "SOUTH", "WEST", "NORTH"};
        // String[] str = new String[] {"NORTH", "WEST", "EAST", "SOUTH", "NORTH", "EAST"};
        String[] res = dirReduc(str);
        System.out.println(Arrays.toString(res));
    }
}
