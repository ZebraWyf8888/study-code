package note.command;

/**
 * @Author: WYF
 * @Description: 实现command接口的连续打印
 * @Create: 2020/3/30 17:53
 * @Version: 1.0
 */
public class PrintfCommend implements Command{
    @Override
    public void process(int[] targer) {
        for (int a:targer) {
            System.out.print(a + "\t ");
        }
        System.out.println("");
    }
}
