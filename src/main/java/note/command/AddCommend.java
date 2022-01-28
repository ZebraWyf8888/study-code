package note.command;

/**
* @Author: WYF
* @Description: 实现command接口的连续加
* @Create: 2020/3/30 17:53
* @Version: 1.0
*/
public class AddCommend implements Command {
    @Override
    public void process(int[] targer) {
        int sum = 0;
        for (int i = 0; i < targer.length; i++) {
            sum += targer[i];
        }
        System.out.println(sum);
    }
}
