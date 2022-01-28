package macleetcode.day20210412;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().trim();

        int endIndexOfLength = line.indexOf(' ');
        int length = Integer.parseInt(line.substring(0, endIndexOfLength));

        int endIndexOfStart = line.indexOf(' ', endIndexOfLength + 1);
        int start = Integer.parseInt(line.substring(endIndexOfLength + 1, endIndexOfStart));

        int endIndexOfEnd = line.indexOf(' ', endIndexOfStart + 1);
        int end = Integer.parseInt(line.substring(endIndexOfStart + 1, endIndexOfEnd));

        String input = line.substring(endIndexOfEnd + 1);

        List<String> result = getAll(length, start, end, input);
        Collections.sort(result);
        for (int i = 0; i < result.size(); ++i) {
            if (i == result.size() - 1) {
                System.out.print(result.get(i));
            } else {
                System.out.println(result.get(i));
            }
        }
        System.out.flush();
    }

    static List<String> getAll(int length, int start, int end, String input) {
        List<String> l = new ArrayList<>();
        Set<String> sets = new HashSet<>();
        String substring1 = input.substring(0, start);
        if (substring1 == null) {
            substring1 = "";
        }
        String s = input.substring(start, end);
        String substring2 = input.substring(end, length);
        if (substring2 == null) {
            substring2 = "";
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i <Math.pow(2,s.length() ); i++) {
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                int bit = (i>>j)&1;
                if (bit == 1) {
                    stringBuilder.setCharAt(j,Character.toUpperCase(ch) );
                }else {
                    stringBuilder.setCharAt(j,Character.toLowerCase(ch) );
                }
            }

            if (!sets.contains(stringBuilder.toString())) {
                l.add(substring1+stringBuilder.toString()+substring2);
                sets.add(stringBuilder.toString());
            }
        }
        return l;
    }
    static int topK(int[] array, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        for(int num : array){
            Integer integer = map.get(num);
            if (integer != null) {
                map.put(num, integer+1);
            }else {
                map.put(num, 1);
            }

        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num = entry.getKey();
            int time = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < time ) {
                    queue.poll();
                    queue.offer(new int[]{num,time});
                }
            }else {
                queue.offer(new int[]{num,time});
            }
        }
        return queue.poll()[0];
    }
}
