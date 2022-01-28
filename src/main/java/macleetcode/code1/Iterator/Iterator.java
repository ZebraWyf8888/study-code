package macleetcode.code1.Iterator;

/**
 * @Author: WYF
 * @Description: 接口
 * @Create: 2020-06-07 18:02
 * @Version: 1.0
 */
public interface Iterator {
    /**
     * @Description: 向前访问
     * @Param: []
     * @Return: Character
     * @Author: WYF
     * @Date: 2020/6/7 18:28
    */
    Character getBefore();

    /**
     * @Description: 向后访问
     * @Param: []
     * @Return: Character
     * @Author: WYF
     * @Date: 2020/6/7 18:28
    */
    Character getAfter();
}
