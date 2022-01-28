package macleetcode.day813;

import java.util.*;

///**
// * @author wangyifan
// */
//public class Main {
//    public static String[] doLinux(String linux){
//        String[] split = linux.split(" ");
//        for(int i = 0;i<split.length;i++){
//            String a = split[i];
//            if(a.startsWith("\"") && a.endsWith("\"")){
//                split[i] = a.substring(1,a.length()-1);
//            }
//        }
//        return split;
//    }
//public static StringBuilder RLE(String in) {
//        HashSet<Object> objects = new HashSet<>();
//        Object o = ;
//        boolean aa = objects.contains("aa");
//
//        //转为字符串数组
//        char[] chars = in.toCharArray();
//        StringBuilder out = new StringBuilder();
//        //拼接
//        for (int i = 0; i < chars.length; i = i + 2) {
//            //第一个字符为单词个数，第二个字符为单词
//            int time = chars[i] - '0';
//            for (int j = 0; j < time; j++) {
//                out.append(chars[i + 1]);
//            }
//        }
//        return out;
//    }
//public static Boolean BloomFilter(String in,char c) {
//        //转为字符串数组
//        char[] chars = in.toCharArray();
//        Set<Character> set = new HashSet<>();
//        //利用set结构
//        for (int i = 0; i < chars.length; i++) {
//
//            set.add(new Character(chars[i]));
//        }
//        if(set.contains(c)){
//            return true;
//        }else{
//            return false;
//        }
//    }
//}
class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/**
 * @author wangyifan
 */
public class Main {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals.size() == 0) {
            return intervals;
        }

        //思路1：先将左半边的数据进行从小到大，排序。
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (intervals.get(i).start > intervals.get(j).start) {
                    Interval tem = intervals.get(i);
                    intervals.set(i, intervals.get(j));
                    intervals.set(j, tem);
                }
            }
        }

        //从小到大遍历，从最前面开始
        int min = intervals.get(0).start;
        int max = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            //intervals.get(i).start <= max，就进行区间，重叠即合并区间
            if (intervals.get(i).start <= max) {
                //取大
                max = Math.max(intervals.get(i).end, max);
            } else {
                //否则标识此区间结束，新建立一个区间
                ans.add(new Interval(min, max));
                min = intervals.get(i).start;
                max = intervals.get(i).end;
            }
        }
        ans.add(new Interval(min, max));
        return ans;
    }
}
