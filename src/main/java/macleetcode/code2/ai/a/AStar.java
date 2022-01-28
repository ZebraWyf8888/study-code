package macleetcode.code2.ai.a;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: WYF
 * @Description: 核心，基于前三个类数据结构，实现A*算法
 * @Create: 2020/4/15 11:14
 * @Version: 1.0
 */
public class AStar {
    public final static int BAR = 1; // 障碍值
    public final static int PATH = 2; // 路径
    /**
     * G值需要的横纵移动代价和斜移动代价。10就说1.0，14就说1.4
     */
    public final static int DIRECT_VALUE = 10; // 横竖移动代价
    public final static int OBLIQUE_VALUE = 14; // 斜移动代价

    Queue<Node> openList = new PriorityQueue<Node>(); // 优先队列(升序)
    List<Node> closeList = new ArrayList<Node>();

    /**
     * 判断结点是否是最终结点
     */
    private boolean isEndNode(Coord end, Coord coord) {
        return coord != null && end.equals(coord);
    }

    /**
     * 判断结点能否放入Open列表（优先队列）
     */
    private boolean canAddNodeToOpen(MapInfo mapInfo, int x, int y) {
        // 是否在地图中，超过地图大小
        if (x < 0 || x >= mapInfo.width || y < 0 || y >= mapInfo.hight) {
            return false;
        }
        // 判断是否是不可通过的结点，该节点是障碍，不能用
        if (mapInfo.maps[y][x] == BAR) {
            return false;
        }
        // 判断结点是否存在close表，
        if (isCoordInClose(x, y)) {//如果坐标已经在close中，不能再放入open
            return false;
        }

        return true;
    }

    /**
     * 判断坐标是否在close表中，调用与自己重载的方法，多了应该非空判断
     */
    private boolean isCoordInClose(Coord coord) {
        return coord != null && isCoordInClose(coord.x, coord.y);
    }

    /**
     * 判断坐标是否在close表中，close的list，查看有没有一样的数据
     */
    private boolean isCoordInClose(int x, int y) {
        if (closeList.isEmpty()) {
            return false;
        }
        for (Node node : closeList) {
            if (node.coord.x == x && node.coord.y == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 计算H值，坐标分别取差值相加
     */
    private int calcH(Coord end, Coord coord) {
        return Math.abs(end.x - coord.x) + Math.abs(end.y - coord.y);
    }

    /**
     * @Description: 从Open列表中查找结点
     */
    private Node findNodeInOpen(Coord coord) {
        if (coord == null || openList.isEmpty()) {
            return null;
        }
        for (Node node : openList) {
            if (node.coord.equals(coord)) {
                return node;
            }
        }
        return null;
    }

    /**
     * 添加所有邻结点到open表
     */
    private void addNeighborNodeInOpen(MapInfo mapInfo, Node current) {
        int x = current.coord.x;
        int y = current.coord.y;
        // 左
        addNeighborNodeInOpen(mapInfo, current, x - 1, y, DIRECT_VALUE);
        // 上
        addNeighborNodeInOpen(mapInfo, current, x, y - 1, DIRECT_VALUE);
        // 右
        addNeighborNodeInOpen(mapInfo, current, x + 1, y, DIRECT_VALUE);
        // 下
        addNeighborNodeInOpen(mapInfo, current, x, y + 1, DIRECT_VALUE);
        // 左上
        addNeighborNodeInOpen(mapInfo, current, x - 1, y - 1, OBLIQUE_VALUE);
        // 右上
        addNeighborNodeInOpen(mapInfo, current, x + 1, y - 1, OBLIQUE_VALUE);
        // 右下
        addNeighborNodeInOpen(mapInfo, current, x + 1, y + 1, OBLIQUE_VALUE);
        // 左下
        addNeighborNodeInOpen(mapInfo, current, x - 1, y + 1, OBLIQUE_VALUE);
    }

    /**
     * 添加一个邻结点到open表
     */
    private void addNeighborNodeInOpen(MapInfo mapInfo, Node current, int x, int y, int value) {
        if (canAddNodeToOpen(mapInfo, x, y)) {
            Node end = mapInfo.end;
            Coord coord = new Coord(x, y);
            int G = current.G + value; // 计算邻结点的G值
            Node child = findNodeInOpen(coord);
            if (child == null) {
                int H = calcH(end.coord, coord); // 计算H值
                if (isEndNode(end.coord, coord)) {
                    child = end;
                    child.parent = current;
                    child.G = G;
                    child.H = H;
                } else {
                    child = new Node(coord, current, G, H);
                }
                openList.add(child);
            } else if (child.G > G) {
                child.G = G;
                child.parent = current;
                // 重新调整堆
                openList.add(child);
            }
        }
    }

    /**回溯法绘制路径*/
    private void drawPath(int[][] maps, Node end) {
        if (end == null || maps == null) {
            return;
        }
        System.out.println("总代价：" + end.G);
        /** 修改矩阵，把一路上经过的节点赋值为2，表示为路径，是从后往前推的*/
        while (end != null) {
            Coord c = end.coord;
            maps[c.y][c.x] = PATH;
            end = end.parent;
        }
    }

    /**  开始算法，循环移动结点寻找路径，设定循环结束条件，Open表为空或者最终结点在Close表*/
    public void start(MapInfo mapInfo) {
        if (mapInfo == null) {
            return;
        }
        // clean
        openList.clear();
        closeList.clear();
        // 开始搜索
        openList.add(mapInfo.start);
        moveNodes(mapInfo);
    }

    /**
     * 移动当前结点
     */
    private void moveNodes(MapInfo mapInfo) {
        while (!openList.isEmpty()) {
            Node current = openList.poll();//每次都从优先队列里面去一个最小的值，加入到open中
            closeList.add(current);
            addNeighborNodeInOpen(mapInfo, current);
            if (isCoordInClose(mapInfo.end.coord)) // 是不是终点，是就提出
            {
                drawPath(mapInfo.maps, mapInfo.end);
                break;
            }
        }
    }

}
