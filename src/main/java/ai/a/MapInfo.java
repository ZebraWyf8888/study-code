package ai.a;

/**
* @Author: WYF
* @Description: A星算法输入的所有数据，封装在一起，传参方便。
* @Create: 2020/4/15 11:09
* @Version: 1.0
*/
public class MapInfo {
    public int[][] maps;
    /** 地图宽度 */
    public int width;
    /** 地图高度 */
    public int hight;
    public Node start;
    public Node end;

    public MapInfo(int[][] maps, int width, int hight, Node start, Node end) {
        this.maps = maps;
        this.width = width;
        this.hight = hight;
        this.start = start;
        this.end = end;
    }
}

