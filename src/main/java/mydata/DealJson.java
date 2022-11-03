package mydata;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

public class DealJson {
    public static void main(String[] args) {
        String str = "{\"bussDatas\":[{\"fieldDesc\":\"string\",\"isSelected\":0,\"optionType\":0,\"optionValue\":\"string\",\"orderNum\":0,\"placeHolder\":\"string\"}],\"moduleName\":\"string\",\"packageId\":\"string\",\"techDatas\":{\"fieldDesc\":\"string\",\"isSelected\":0,\"optionType\":0,\"optionValue\":\"string\",\"orderNum\":0,\"placeHolder\":\"string\"}}\n";
        JSONObject jsonObject = JSONObject.parseObject(str);
        // 获取JSON第一层所有的keys
        Set<String> keys = jsonObject.keySet();
        // 获取第一层每个key对应的值 的类型
        for (String key : keys) {
            System.out.printf("%s(key)：%s(值类型)%n", key, jsonObject.get(key).getClass().getSimpleName());
        }
    }

}
