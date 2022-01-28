package macleetcode.code1.single;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: WYF
 * @Description: 饿汉单例，用静态代码块饿汉式，
 * 比起直接就new，它可以实现更复杂的功能，比如读取配置文件
 * @Create: 2020/3/30 15:28
 * @Version: 1.0
 */
public class SingleTon2 {
    public static final SingleTon2 INSTANCE;
    private String info;
    static {
        try {
            Properties properties = new Properties();
            properties.load(SingleTon2.class.getClassLoader().getResourceAsStream("singleton.properties"));
            INSTANCE = new SingleTon2(properties.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    private SingleTon2(String info){
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "SingleTon2{" +
                "info='" + info + '\'' +
                '}';
    }

}
