package macleetcode.day916;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[]{1,2,3,4,5,6,8,9,10,12,15,16,18,
                20,24,25,27,30,32,36,40,45,48};

        System.out.println(arr[n-1]);
    }
}