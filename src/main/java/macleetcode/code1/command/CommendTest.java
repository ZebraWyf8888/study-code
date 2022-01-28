package macleetcode.code1.command;

/**
* @Author: WYF
* @Description: 测试类
* @Create: 2020/3/30 17:45
* @Version: 1.0
*/
public class CommendTest {
    public static void main(String[] args) {
        ProcessArray processArray = new ProcessArray();
        int[] arr = {3,4,5,6,7};
        Command c2 = new PrintfCommend();
        /*processArray.process(arr, (int[] target) ->{

            for (int a:
                 target) {
                System.out.println(a);
            }
                System.out.println("哈哈哈哈哈哈");

        });*/
        System.out.println("--------");
        processArray.process(arr, c2);
    }
}
