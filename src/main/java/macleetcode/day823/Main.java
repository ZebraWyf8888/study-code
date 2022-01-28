package macleetcode.day823;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

class Interval {
    int shangxia, zuoyou;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return shangxia == interval.shangxia &&
                zuoyou == interval.zuoyou;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shangxia+Math.random()*22221234, zuoyou+Math.random()*22221234);

    }

    Interval(int shangxia, int zuoyou) {
        this.shangxia = shangxia;
        this.zuoyou = zuoyou;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String next = in.next();
        char[] chars = next.toCharArray();

        Interval interval = new Interval(0, 0);

        HashSet<Interval> objects = new HashSet<>();
        objects.add(interval);
        boolean a = true;
        int time = 0;
        for (int i = 0; i < chars.length; i++) {
            int shangxia = interval.shangxia;
            int zuoyou = interval.zuoyou;
            Interval interval1 = new Interval(shangxia, zuoyou);

            char aChar = chars[i];
            if (aChar == 'N') {
                interval1.shangxia++;
            } else if (aChar == 'S') {
                interval1.shangxia--;
            } else if (aChar == 'E') {
                interval1.zuoyou++;
            } else if (aChar == 'W') {
                interval1.zuoyou--;
            }

            if (objects.contains(interval1)) {
                System.out.println("False");
                a = false;
                break;
            }else {
                objects.add(interval);
            }
//            if (interval.zuoyou==0&&interval.shangxia==0) {
//
//            }
            time++;
        }
        if (time == chars.length&&a) {
            System.out.println("True");
        }
    }
}


//    public static void main(String[] args) {
//        System.out.println(26*27*28*29*30);
//        System.out.println(21*22*23*24*25);
//        System.out.println(16*17*18*19*20);
//        System.out.println(11*12*13*14*15);
//        System.out.println(6*7*8*9*10);
//        System.out.println(1*2*3*4*5);
//        Scanner in = new Scanner(System.in);
//        int i = in.nextInt();
//        int i1 = CountZero(i);
//        System.out.println(i1);
//    }
//    public static int CountZero(int n){
//        if (n <= 1) {
//            return 0;
//        }
//        int cnt = 0;
//        while (n>0) {
//            cnt+=n/5;
//            n /=5;
//        }
//        return cnt;
//    };


