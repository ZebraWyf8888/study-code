package ai.a;

/**
* @Author: WYF
* @Description: 测试类
* @Create: 2020/4/15 11:13
* @Version: 1.0
*/
public class Test {
    public static void main(String[] args)
    {
        int[][] maps = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }
        };
        MapInfo info=new MapInfo(maps,maps[0].length, maps.length,new Node(1, 1), new Node(10, 4));
        new AStar().start(info);
        printMap(maps);
    }

    /**
     * @Description: 打印地图
     * @Param: [maps]
     * @Return: void
     * @Author: WYF
     * @Date: 2020/4/15 11:13
    */
    public static void printMap(int[][] maps)
    {
        for (int i = 0; i < maps.length; i++)
        {
            for (int j = 0; j < maps[i].length; j++)
            {
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }
    }
}
