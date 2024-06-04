package ahot;

// 可以引⼊的库和版本相关请参考 “环境说明”
// Please refer to the "Environmental Notes" for the libraries and versions that can be introduced.

import java.util.*;

public class ShowMeBug {
    public static void main(String[] args) {
//        System.out.println("Talk is cheap. Show me the code.");
        int tar = 3;
        int[] num = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

//        int len = num.length;

        int left = 0;
        int right = num.length - 1;

        int temp = (left + right) / 2;
        while (left < right) {
            if (num[temp] > tar) {
                right = temp - 1;
            } else if (num[temp] < tar) {
                left = temp + 1;
            } else {
                System.out.print(temp);
                break;
            }
            temp = (left + right) / 2;
        }

    }

}

