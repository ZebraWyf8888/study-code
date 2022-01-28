package macleetcode.day210320;

import java.util.*;

public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int time = scanner.nextInt();
//        for (int p = 0; p < time; p++) {
//            int N = scanner.nextInt();//救援点和居民点的数量
//            int M = scanner.nextInt();
//            UnionFind unionFind = new UnionFind(N+1);
//            int[] ints = new int[N+1];
//            for (int i = 0; i < M; i++) {
//                int a = scanner.nextInt();
//                int b = scanner.nextInt();
//                ints[a]++;
//                ints[b]++;
//                unionFind.union(a, b);
//            }
//            boolean flag = true;
//            for (int i = 1; i < N+1; i++) {
//                boolean connected = unionFind.connected(1, i);
//                if (!connected) {
//                    flag = false;
//                    break;
//                }
//            }
//
//            for (int i = 1; i < N+1; i++) {
//                if (ints[i] < 2) {
//                    System.out.println("No");
//                    flag = false;
//                    break;
//                }
//            }
//
//            if (flag) {
//                System.out.println("Yes");
//            }
//
//        }
//    }
//
//   static class UnionFind {
//       private int[] id;
//       private int count;
//
//       public UnionFind(int N) {
//           count = N;
//           id = new int[N];
//           for (int i = 0; i < N; i++) {
//               id[i] = i;
//           }
//       }
//
//       public int getCount() {
//           return count;
//       }
//
//       public boolean connected(int p, int q) {
//           return find(p) == find(q);
//       }
//
//       public int find(int p) {
//           return id[p];
//       }
//
//       public void union(int p, int q) {
//           int pRoot = find(p);
//           int qRoot = find(q);
//
//           if (pRoot == qRoot) {
//               return;
//           }
//
//           for (int i = 0; i < id.length; i++) {
//               if (id[i] == pRoot) {
//                   id[i] = qRoot;
//               }
//           }
//
//           count--;
//       }
//   }}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String next = scanner.next();
        char[] chars = next.toCharArray();
        String ans = null;
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') {
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = i+1; j<chars.length; j--) {

                if (min < chars[j] - chars[i]) {
                    min  = chars[j] - chars[i];
                    String swap = swap(next, i, j);
                    ans =swap;
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(ans);

    }

    private static String swap(String next, int i, int j) {
        char[] chars = next.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }}
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String next = scanner.next();
//        String[] split = next.split(";");
//        int length1 = split.length;
//        int[][] arr = new int[length1][];
//        int length2 = 0;
//        for (int i = 1; i < length1; i++) {
//            String s = split[i];
//            String[] split1 = s.split(",");
//            length2 = split1.length;
//            for (int j = 0; j < length2; j++) {
//                arr[i][j] = Integer.parseInt(split1[j]);
//            }
//        }
//
//        if (arr[0][0]==0||arr[length1-1][length2] == 0) {
//            System.out.println(0);
//        }else {
//            int[][] ans  = new int[length1][length2];
//
//            for (int i = 0; i < length1; i++) {
//                for (int j = 0; j < length2; j++) {
////                    arr[]
//                }
//            }
//            System.out.println(ans);
//        }
//
//
//
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int len = scanner.nextInt();
//        long[][] arr = new long[len][];
//        for (int i = 0; i < len; i++) {
//            String s = scanner.next();
//            String[] split = s.split(",");
//            arr[i] = new long[]{Long.parseLong(split[0]),Long.parseLong(split[1])};
//        }
//        long ans = arr[0][1];
//        long nowtime =arr[0][1] +arr[0][0];
//        for (int i = 1; i < len; i++) {
//            long arriveTime= arr[i][0], payDuration =arr[i][1];
//            if (arriveTime < nowtime) {
//                ans += (nowtime-arriveTime);
//                ans += payDuration;
//                nowtime += payDuration;
//            }else {
//                nowtime = arriveTime;
//                ans += payDuration;
//                nowtime += payDuration;
//            }
//        }
//
//        System.out.println(ans);
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line1 = scanner.nextLine();
//        String line2 = scanner.nextLine();
//        String[] split1 = line1.split(",");
//        String[] split2 = line2.split(",");
//        Map<String, String> ans = new TreeMap<>();
//        Map<String, String> sp1Map = new HashMap<>();
//        for (int i = 0; i < split1.length; i++) {
//            String[] temp = split1[i].split("-");
//            ans.put(temp[0],"delete");
//            sp1Map.put(temp[0], temp[1]);
//        }
//
//        for (int i = 0; i < split2.length; i++) {
//            String[] temp = split2[i].split("-");
//            if (sp1Map.containsKey(temp[0])) {
//                String s = sp1Map.get(temp[0]);
//                if (s.equals(temp[1])) {
//                    ans.remove(temp[0]);
//                }else {
//                    ans.put(temp[0],"modify" );
//                }
//            }else {
//                ans.put(temp[0],"add");
//            }
//        }
//        Iterator<Map.Entry<String, String>> iterator = ans.entrySet().iterator();
//        StringBuilder ansString = new StringBuilder();
//        while (iterator.hasNext()){
//            Map.Entry<String, String> next = iterator.next();
//            ansString.append(next.getValue()+"-"+next.getKey()+",");
//        }
//        String substring = ansString.substring(0, ansString.length() - 1);
//        System.out.println(substring);
//
//
//    }
//}
