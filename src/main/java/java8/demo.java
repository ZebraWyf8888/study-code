package java8;

public class demo {
    public static void main(String[] args) {
//        int count = 0;
//        for (int i = 1; i < 1200000; i++) {
//            if (1200000%i==0) {
//                count++;
//            }
//        }
//        System.out.println(count);
        int a = 0;
    int count = 0;
        for (int i = 1; i < 2020; i++) {
        a = i;
        if (i%10 == 9) {
        count++;
        }else if (i%100 > 89){
        count++;
        }else if (i%1000 > 899){
        count++;
        }
        }
        System.out.println(count);
    }
}
//