package day912;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String next1 = scanner.nextLine();
        String next = scanner.nextLine();
        int index = 0;
        int length = next.length();
        while (index<length){
            if (index+i >length) {
                String substring1 = next.substring(index, length);
                String s1 = re1(substring1);
                System.out.print(s1);
                break;
            }
            String substring = next.substring(index, index + i);
            String s = re1(substring);
            System.out.print(s);
            index = index +i;
            if (index+i>length) {
                String substring1 = next.substring(index, length);
                String s1 = re1(substring1);
                System.out.print(s1);
                break;
            }
        }
    }
    public static String re1(String string){
        return new StringBuffer(string).reverse().toString();
    }
}
