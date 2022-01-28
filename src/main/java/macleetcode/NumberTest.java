package macleetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberTest {

    public static void main(String[] args) {
        //test6();
        //test5();
//        String[] phoneNum = getPhoneNum("你的验证码为6677：，在10分钟内有效");
//        String a= "你的验证码为6677：，在10分钟内有效";
//        String b = a.substring(0, 4);
//        System.out.println(b);
//        System.out.println(phoneNum[0]+"------"+phoneNum[1]);

        ArrayList<String> strings = new ArrayList<>();
//        new HashMap<>()
//        new HashSet<>()
        strings.add("12121");
        strings.add("212");
        strings.add("122");
//        Integer
        System.out.println(strings.toString());



    }
    private static void test6() {
        // 提取张三 去除数字
        String r_name3 = "张三 1359999你好8888 000000";
//		Pattern pattern = Pattern.compile("[\\d]");
//		Pattern pattern = Pattern.compile("\\d*");
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(r_name3);
        System.out.println(matcher.replaceAll("").trim());

    }

    private static void test5() {
        String phoneString = "哈哈,1388888额9999";
//		String phoneString = "MemTotal:         808964 kB";
        // 提取数字
        // 1
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(phoneString);
        String all = matcher.replaceAll("");// 不属于任何匹配的字符被直接添加到结果字符串
        System.out.println("phone:" + all);
        // 2
        Pattern.compile("[^0-9]").matcher(phoneString).replaceAll("");

    }

    /**
     * 返回验证码+时间。
     * eg .smsbody:您的验证码为 123，在5min内有效
     *    return:[123,5]
     * @param smsBody 短信内容
     * @return
     */
    private static String[] getPhoneNum(String smsBody) {
        String[] templateParams = new String[2];
        Pattern pattern = Pattern.compile("\\d{1,6}");
        Matcher matcher = pattern.matcher(smsBody);
        for (int i = 0; i < 2&&matcher.find(); i++) {
            templateParams[i] = matcher.group();
        }
        return templateParams;
    }
}
