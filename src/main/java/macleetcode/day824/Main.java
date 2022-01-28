package macleetcode.day824;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while ( scanner.hasNext()){
//            String next = scanner.next();
//            char[] chars = next.toCharArray();
//            int start  = 0;
//            int end  = chars.length-1;
//            boolean flag = true;
//            while (start<=end){
//                if (!(isre(chars[start])&&isre(chars[end])&&chars[start] == chars[end])) {
//                    System.out.println("NO");
//                    flag = false;
//                    break;
//                }
//                start++;
//                end--;
//            }
//            if (flag == true) {
//                System.out.println("YES");
//            }
//        }
//
//    }
//
//    private static boolean isre(char aChar) {
//        if (
//                aChar == 'A'||
//                aChar == 'W'||
//                aChar == 'T'||
//                aChar == 'Y'||
//                aChar == 'U'||
//                aChar == 'I'||
//                aChar == 'O'||
//                aChar == 'H'||
//                aChar == 'X'||
//                aChar == 'V'||
//                aChar == 'M'
//        ) {
//            return true;
//        }else {
//            return false;
//        }
//
//    }

    /**
     * 魔塔是一款时尚经典小游戏，我们将魔塔简化后的规则描述如下：
     *
     * 魔塔有n关，而你可以自由选择前往攻略哪一关，每一关只能获得一次分数。第i关攻略完成后，你将会获得ai的分数。某些关有一个特殊的宝物，你只能在攻略完这一关的时候使用这个宝物（也可以不使用，额外的宝物并不能留到其他关卡使用），这个宝物将使得这一关不得分，但是将你现有的总得分乘以2作为新的得分。
     *
     * 你现在知道了所有关卡的通关方法，也知道了每一关的得分和是否有宝物，你现在想知道，怎么选择攻略的顺序和使用宝物的方法才能让自己的得分最大化？
     *
     * 5
     * 1 1
     * 3 1
     * 5 1
     * 2 0
     * 2 0
     *
     * 36
     *
     *
     * n≤100,1≤a_i≤10^7,0≤b_i≤1，数据保证最多不超过30个宝物。
     * 攻略顺序如下：
     * 5,4,3,2(用宝物),1(用宝物)
     *
     * @param args
     */
    public static void main(String[] args) {
        //思路，没有宝物的全部直接加
        //有宝物分两种情况：1、比当下的count大，就不使用宝物
        //2、比当下小，使用宝物
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[][] res = new int[count][2];
        Long temp = 0l;
        TreeSet<Integer> objects = new TreeSet<>();
        for (int i = 0; i < count; i++) {
            int i1 = scanner.nextInt();
            res[i][0] = i1;

            int i2 = scanner.nextInt();
            res[i][1] = i2;
            if (i2 == 0) {
                temp = temp+i1;
                res[i][0] = -1;
            }else {
                objects.add(i1);
            }
        }

        while (!(objects.size() == 0)) {
            if (objects.last()> temp) {
                temp = temp +objects.last();
            }else {
                temp = temp*2;
            }
            objects.remove(objects.last());
        }
        System.out.println(temp);


       // System.out.println(36);

    }
}
