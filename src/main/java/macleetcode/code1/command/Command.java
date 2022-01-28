package macleetcode.code1.command;

/**
 * @Author: WYF
 * @Description: 接口 封装处理行为
 * @Create: 2020-03-30 17:36
 * @Version: 1.0
 */
@FunctionalInterface
public interface Command {

    /**
     * 抽象方法
     *
     * @Param targer 数组，要处理的
     * @Return void
    */
    void process(int[] targer);


}
