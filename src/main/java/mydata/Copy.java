package mydata;

import java.util.Arrays;

public class Copy {
    public static void main(String[] args) {
        String string1 = new String("aaa");
        String string2 = new String("bbb");
        String string3 = new String("ccc");
        String[] strings = new String[]{string1,string2,string3};
        String[] stringsCopy = Arrays.copyOf(strings, 10);

        System.out.println(strings);
        System.out.println(stringsCopy);

        System.out.println(Arrays.toString(stringsCopy));
        stringsCopy[0] = "11111";
        System.out.println(Arrays.toString(stringsCopy));
        System.out.println(Arrays.toString(strings));
    }
}
