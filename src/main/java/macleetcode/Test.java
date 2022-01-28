package macleetcode;

import java.io.IOException;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws IOException {
//        String smsContent = "https://apk.lizhifm.com/pro/2058_android_toutiao_zyhl_dx17_34760_7647.apk";
//        String text = "^https.*$";
//        System.out.println(smsContent.matches("^https.*$"));
//
//        String a = null;
//        text = a+text;
//        System.out.println(text);
////        boolean https = smsContent.startsWith("https");
////        System.out.println(https);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 5, 20, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
////        threadPoolExecutor.execute();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);

        StringBuffer stringBuffer = new StringBuffer();
        int value = 18;
        do {
            int temp = value&0x07;
            stringBuffer.append(temp);
        }while ((value>>>= 3 )!=0);
        System.out.println(stringBuffer.reverse());
    }
}
