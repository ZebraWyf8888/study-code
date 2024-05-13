package ahot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 定义一个入度表，比如课程1需要3和5，课程1的入度为2
        int[] indegrees = new int[numCourses];
        //  保存入度为0的队列了
        Queue<Integer> queue = new LinkedList<>();

        //邻接表所需额外空间
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        for (int[] cp : prerequisites) {
            //统计入度表
            indegrees[cp[0]]++;
            //List<List<Integer>> adjacency ，外面一层adjacency的index
            //（cp【1】）表示课程，
            //里面一层的数组，表示到达 课程 需要的前置学习课程
            adjacency.get(cp[1]).add(cp[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)){
                --indegrees[cur];
                if (indegrees[cur] == 0) {
                    queue.add(cur);
                }

            }

        }
        return numCourses == 0;

    }
}