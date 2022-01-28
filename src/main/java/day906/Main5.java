package day906;

import java.util.LinkedList;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Long> objects = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Long i1 = scanner.nextLong();
            if (objects.contains(i1)) {
                objects.remove(i1);
                objects.add(0, i1);
            }else {
                objects.add(0, i1);
            }
        }
        for (Long integer:
             objects) {
            System.out.println(integer);
        }

    }
}
