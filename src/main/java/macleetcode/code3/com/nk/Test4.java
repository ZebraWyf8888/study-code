package macleetcode.code3.com.nk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test4 {
    public static void main(String args[]){
        List<Object> objects = new ArrayList<>();
        objects.add("1");
        objects.add("2");
        objects.add("3");
        objects.add("4");
        objects.add("5");
        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
            if (next=="3") {
                iterator.remove();
            }
        }
        System.out.println("----------");
        Iterator<Object> iterator2 = objects.iterator();
        while (iterator2.hasNext()){
            Object next = iterator2.next();
            System.out.println(next);
        }

    }
}