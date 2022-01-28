package macleetcode.day920;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String next1 = scanner.next();
//        String next2 = scanner.next();
//        char[] chars1 = next1.toCharArray();
//        char[] chars2 = next2.toCharArray();//yaotu
//        int length1 = next1.length();
//        int length2 = next2.length();
//        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
//        for (int i = 0; i < length2; i++) {
//            Integer integer = characterIntegerHashMap.get(chars2[i]);
//            if (integer == null) {
//                characterIntegerHashMap.put(chars2[i],1);
//            }else {
//                integer = integer+1;
//                characterIntegerHashMap.put(chars2[i],integer);
//            }
//        }
//
//        int count = 0;
//        for (int i = 0; i < length1; i++) {
//            Integer integer = characterIntegerHashMap.get(chars1[i]);
//            if (integer == null||integer.equals(0)) {
//                continue;
//            }else {
//                integer = integer-1;
//                characterIntegerHashMap.put(chars1[i],integer);
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        for (int i = 0; i < time; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            Character[][] a = new Character[N][M];
            for (int j = 0; j <N ; j++) {
                String next = scanner.next();
                for (int k = 0; k < M; k++) {
                    Character i1 = next.charAt(k);
                    a[j][k] = i1;
                }
            }
            Random random = new Random();
            int i1 = random.nextInt(100);
            System.out.println(i1);
        }
    }
}
