package java8.com.jvm_test;

import java.util.ArrayList;

//-XX:+PrintGCDetail
//-Xms1m -Xms8m -XX:+HeapDumpOnOutOfMemoryError
public class Demo03 {

    byte[] array = new byte[1*1024*1024];//1m

    public static void main(String[] args) {
        ArrayList<Demo03> list = new ArrayList<>();
        int count = 0;

        try {
            while (true){
                list.add(new Demo03());
                count = count+1;
            }
        }
        catch (Error error){
            System.out.println("count:" + count);
            error.printStackTrace();
        }
    }
}
