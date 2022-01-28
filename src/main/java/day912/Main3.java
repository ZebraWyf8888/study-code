package day912;

import java.util.HashSet;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        HashSet<Integer> objects = new HashSet<>();
        Integer integer1 = new Integer(128);
        Integer integer2 = 128;
        Integer integer3 = new Integer(128);
        objects.add(integer1);
        objects.add(integer2);
        objects.add(integer3);
        System.out.println(objects.size());
    }

}
