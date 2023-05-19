package work;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import okhttp3.*;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

class ApiDemo {
    private static final String IMAGE = "image";
    private static final String IMAGEURI = "/r1/image/scan";
    private static final String IMAGEURL = "https://solar-api.baichuanshuan.com/r1/image/scan";

    private static final String TEXT = "text";
    private static final String TEXTURI = "/r1/text/scan";
    private static final String TEXTURL = "https://solar-api.baichuanshuan.com/r1/text/scan";

    public static void main(String[] args) {
        String appId = "2lgInGsq6Y";
        String bizType = "WJ-QY2bdMY";
        String secret = "IQ2Spko9i-Y2pTR3QOjFWg==";
        String text = "这是测试用例";
        String url = "http://audit-commercial.oss-cn-shanghai.aliyuncs.com/test/2022-04-06/19_58/004.jpg";
        boolean mockTime = false;
        // 匹配命令行参数
//        for (int idx = 0; idx < args.length; idx++) {
//            if ("--appId".equals(args[idx]) || "-appId".equals(args[idx])) {
//                appId = args[++idx];
//            } else if ("--bizType".equals(args[idx]) || "-bizType".equals(args[idx])) {
//                bizType = args[++idx];
//            } else if ("--secret".equals(args[idx]) || "-secret".equals(args[idx])) {
//                secret = args[++idx];
//            } else if ("--mocktime".equals(args[idx]) || "-mocktime".equals(args[idx])) {
//                mockTime = Boolean.parseBoolean(args[++idx]);
//            } else if ("--text".equals(args[idx]) || "-text".equals(args[idx])) {
//                text = args[++idx];
//            }
//        }
        // 判断参数是否合规
        if (isBlank(bizType) || isBlank(appId) || isBlank(secret)) {
            System.out.println("参数错误");
            return;
        }
        LocalDateTime time = LocalDateTime.now();
        //GMT时间格式
        DateTimeFormatter gmt = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH).withZone(ZoneId.of("GMT"));
        if (mockTime) {
            System.out.println("文本接口示例:");
            System.out.println("appId: " + appId);
            System.out.println("bizType: " + bizType);
            System.out.println("secret: " + secret);
            //固定时间
            time = LocalDate.of(2022, 1, 2).atTime(13, 14, 15, 789000000);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println("测试固定时间为: " + time.format(dateTimeFormatter));
            System.out.println("格式化为GMT时间格式后为: " + time.format(gmt));
            System.out.println("---------------------------------\n");
        }
        //调用测试用例
        runExample(appId, bizType, secret, text, time.format(gmt), TEXT);
//        runExample(appId, bizType, secret, url, time.format(gmt), IMAGE);
    }

    /**
     * 基于GSON以及okhttp3
     */
    private static void runExample(String appId, String bizType, String secret, String content, String gmt, String type) {
        String url = "";
        String uri = "";
        Task[] task = null;
        if (IMAGE.equals(type)) {
            url = IMAGEURL;
            uri = IMAGEURI;
            task = new Task[]{new ImageTask(content)};
        } else if (TEXT.equals(type)){
            url = TEXTURL;
            uri = TEXTURI;
            task = new Task[]{new TextTask(content)};
        }
        Gson gson = new Gson();
        CheckInfo body = new CheckInfo(appId, bizType, task);
        String bodyJson = gson.toJson(body);
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        //List<String> params = new ArrayList<>();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("x-bc-date", gmt).addHeader("x-bc-appId", appId)
                .addHeader("x-bc-bizType", bizType)
                .addHeader("x-bc-signature", signing(secret, generateSigningString(appId, bizType, gmt, uri)))
                .addHeader("x-bc-body-digest", signing(secret, bodyJson))
                .post(RequestBody.create(mediaType, bodyJson))
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
//        try {
//            Response response = okHttpClient.newCall(request).execute();
//            System.out.println("status_code: " + response.code());
//            System.out.println("headers: " + response.headers());
//            System.out.println("resp: " + (response.body() != null ? "" : response.body().string()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("status_code: " + response.code());
                System.out.println("headers: " + response.headers());
                System.out.println("resp: " + (response.body() == null ? "" : response.body().string()));
            }
        });
    }

    /**
     * 判断字符串是否为空
     */
    private static boolean isBlank(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 生成对应登录需要相关信息，后续需要家里（params暂且没信息）
     */
    private static String generateSigningString(String appId, String bizType, String gmt, String uri) {
        return "POST\n" +
                uri +
                "\n" +
                //add params
                "\n" +
                appId +
                "\n" +
                gmt +
                "\n" +
                "x-bc-bizType:" +
                bizType +
                "\n";
    }

    /**
     * 加密
     */
    private static String signing(String secret, String message) {
        try {
            String encryptionAlgorithm = "HmacSHA256";
            byte[] key = secret.getBytes(StandardCharsets.UTF_8);
            SecretKey secretKey = new SecretKeySpec(key, encryptionAlgorithm);
            Mac mac = Mac.getInstance(encryptionAlgorithm);
            mac.init(secretKey);
            byte[] textByte = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
            byte[] base = Base64.getEncoder().encode(textByte);
            return new String(base, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}


/**
 * 简易请求实体类
 */
class CheckInfo {
    @SerializedName("appId")
    private String appId;
    @SerializedName("bizType")
    private String bizType;
    @SerializedName("tasks")
    private Task[] tasks;

    public CheckInfo(String appId, String bizType, Task[] tasks) {
        this.appId = appId;
        this.bizType = bizType;
        this.tasks = tasks;
    }

    public CheckInfo() {
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }
}

/**
 * 简易任务实体类-抽象
 */
abstract class Task {
}

/**
 * 简易任务实体类-文本
 */
class TextTask extends Task {
    @SerializedName("text")
    private String text;

    public TextTask(String text) {
        this.text = text;
    }

    public TextTask() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

/**
 * 简易任务实体类-图片
 */
class ImageTask extends Task {
    @SerializedName("url")
    private String url;

    public ImageTask(String url) {
        this.url = url;
    }

    public ImageTask() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}