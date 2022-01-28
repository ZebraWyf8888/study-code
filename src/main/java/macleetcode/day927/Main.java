package macleetcode.day927;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int time = scanner.nextInt();
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = scanner.nextInt();
        }
        Arrays.sort(ints);
        for (int p = 0; p < time; p++) {
            int temp = scanner.nextInt();

            if (temp > ints[length-1]) {
                System.out.println(ints[length-1]);
                continue;
            }
            if (temp < ints[0]) {
                System.out.println(ints[0]);
                continue;
            }

            int search = search(ints, 0, length - 1, temp);


            System.out.println(ints[search]);
        }
    }

    public static int search(int[] num,int low,int high,int targer){
        if (low>high ||
                num.length == 0 || targer > num[high]|| targer < num[low]) {
            return low;
        }
        /**
         * 两个优化：1.从 （high + low）/2改为low + （high-low）/2
         * 2.改为 low+（high-low）*（index - arr[low]）/（arr[high]-arr[low]）
         */
        int mid = (high-low)/2 + low;
        if (num[mid] > targer){
            return search(num, low, mid-1, targer);
        }else if (num[mid] < targer){
            return search(num, mid+1, high, targer);
        }else {
            return mid;
        }

    }
}
