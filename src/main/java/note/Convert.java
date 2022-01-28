package note;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    /**
     * @Description:
     * @Param: [s, numRows] s为目标字符串，num为特殊处理字符串时候的一个参数
     * @Return: java.lang.String ：处理后的字符串
     * @Author: WYF
     * @Date: 2020/3/11 23:42
    */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int index = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(index).append(c);
            if (index == 0||index == numRows-1) {
                goingDown = !goingDown;
            }
            index = index+(goingDown?1:-1);
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row:
             rows) {
            ret.append(row);
        }

        return ret.toString();
    }
}
