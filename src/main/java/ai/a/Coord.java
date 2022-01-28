package ai.a;

import java.util.Objects;

/**
 * @Author: WYF
 * @Description: 坐标，实现了比较方法
 * @Create: 2020/4/15 10:55
 * @Version: 1.0
 */
public class Coord {
    public int x;
    public int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @Description: 重写equel和hashCode方法，可以实现比较
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coord coord = (Coord) o;
        return x == coord.x &&
                y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
