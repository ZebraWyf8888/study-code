package macleetcode.day210313;


import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main5 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quan = scanner.nextInt();
        int dian = scanner.nextInt();
        int[] arr = new int[quan];
        int a = 0;
        for (int i = 0; i < quan; i++) {


            arr[i] = scanner.nextInt();
            if (i%2==0) {
                a +=arr[i];
            }
        }
        for (int i = 0; i < dian; i++) {

        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(a+" "+arr[0]);
    }


}
