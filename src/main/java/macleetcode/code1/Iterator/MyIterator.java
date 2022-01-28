package macleetcode.code1.Iterator;

import java.util.List;

/**
* @Author: WYF
* @Description: 迭代器
* @Create: 2020/6/7 18:32
* @Version: 1.0
*/
public class MyIterator implements Iterator {
    int head;
    Character[] charlist;

    public MyIterator(Character[] charlist) {
        this.charlist = charlist;
    }

    @Override
    public Character getBefore() {
        head--;
        if (head<0||head>charlist.length-1) {
            return null;
        }
        return charlist[head];
    }

    @Override
    public Character getAfter() {
        head++;
        if (head<0||head>charlist.length-1) {
            return null;
        }
        return charlist[head];
    }
}
