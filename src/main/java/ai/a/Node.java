package ai.a;

/**
* @Author: WYF
* @Description: 封装更完整的节点，包括本身坐标数据，G和H和父节点。
* @Create: 2020/4/15 10:59
* @Version: 1.0
*/
public class Node implements Comparable<Node> {
    /** 坐标*/
    public Coord coord;
    /** 父结点*/
    public Node parent;
    /** G：是个准确的值，是起点到当前结点的代价*/
    public int G;
    /** H：是个估值，当前结点到目的结点的估计代价*/
    public int H;

    public Node(int x,int y) {
        this.coord = new Coord(x,y);
    }

    public Node(Coord coord, Node parent, int g, int h) {
        this.coord = coord;
        this.parent = parent;
        G = g;
        H = h;
    }

    /**
     * @Description: 比较的是G+H，H是曼哈顿距离，G是节点本身到起始位置的距离
     * @Param: [node]
     * @Return: int
     * @Author: WYF
     * @Date: 2020/4/15 11:06
    */
    @Override
    public int compareTo(Node node) {
        if (node == null) {
            return -1;
        }
        if (G+H > node.G+node.H) {
            return 1;
        }else if (G+H < node.G+node.H) {
            return -1;
        }
        return 0;
    }
}
