package macleetcode.day210313;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main4 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        Map<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        int i =0;
        for (i = 0; i < n; i++) {
            boolean b = integerIntegerHashMap.containsKey(arr[i]);
            if (b) {
                Integer integer = integerIntegerHashMap.get(arr[i]);
                integerIntegerHashMap.put(arr[i], integer+1);
            }else {
                integerIntegerHashMap.put(arr[i], 1);
            }
        }
        int maxmap = getMaxmap(integerIntegerHashMap);
        System.out.println(maxmap);
        while (i<len){
            boolean b = integerIntegerHashMap.containsKey(arr[i]);
            if (b) {
                Integer integer = integerIntegerHashMap.get(arr[i]);
                integerIntegerHashMap.put(arr[i], integer+1);
            }else {
                integerIntegerHashMap.put(arr[i], 1);
            }


            Integer integer = integerIntegerHashMap.get(arr[i-n]);
           integer--;
            if (integer <=0) {
                integerIntegerHashMap.remove(arr[i-n]);
            }else {
                integerIntegerHashMap.put(arr[i-n], integer);
            }
            int maxmap1 = getMaxmap(integerIntegerHashMap);
            System.out.println(maxmap1);
            i++;
        }
    }

    private static int getMaxmap(Map<Integer, Integer> integerIntegerHashMap) {
        int mapvalue = Integer.MIN_VALUE;
        int mapkey = 0;
        for (Map.Entry<Integer,Integer> map:
             integerIntegerHashMap.entrySet()) {
            if (map.getValue()>mapvalue) {
                mapkey = map.getKey();
                mapvalue = map.getValue();
            }else if (map.getValue() == mapvalue&&map.getKey()<mapkey) {
                mapkey = map.getKey();
            }
        }
        return mapkey;
    }
}
