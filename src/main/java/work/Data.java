package work;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author X09380
 */
public class Data {

    public static void main(String[] args) throws IOException {
        String aadasdsa = "";
        String[] arr = new String[]{
                "5f8570baea8ceed36e64aa8a",
                "5f856afa3e3d042cf5c61151",
                "5f856afa3e3d042cf5c61151",
                "5f856afa3e3d042cf5c61151",
                "5f8425c4fa4b9629a41e43c9",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5ee9d653bfefe792d5c6d137",
                "5f856afa3e3d042cf5c61151",
                "5f857068e2c2fb7ab0cc0b70",
                "5f8425c4fa4b9629a41e43c9",
                "5f8425c4fa4b9629a41e43c9",
                "5f8425c4fa4b9629a41e43c9",
                "5f8425c4fa4b9629a41e43c9",
                "5f8425c4fa4b9629a41e43c9",
                "61711a9c7e88fdceab193fdd",
                "5f856afa3e3d042cf5c61151",
                "5f856afa3e3d042cf5c61151",
                "5f856afa3e3d042cf5c61151",
                "5f843cecfa4b9629a41ec0b7",
                "5f8425c4fa4b9629a41e43c9",
                "5f8425c4fa4b9629a41e43c9",
                "5ee9d653bfefe792d5c6d137",
                "5f856afa3e3d042cf5c61151",
                "5f8424c9b58d297e8b318a77",
                "5f857068e2c2fb7ab0cc0b70",
                "5f857068e2c2fb7ab0cc0b70",
                "5f843cecfa4b9629a41ec0b7",
                "5f843cecfa4b9629a41ec0b7",
                "5f8424c9b58d297e8b318a77",
                "5ee9d653bfefe792d5c6d137",
                "5f856c263e3d042cf5c61774",
                "5f8570baea8ceed36e64aa8a",
                "5f843cecfa4b9629a41ec0b7",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f856c263e3d042cf5c61774",
                "5f8424c9b58d297e8b318a77",
                "5f856afa3e3d042cf5c61151",
                "5f843cecfa4b9629a41ec0b7",
                "5f856afa3e3d042cf5c61151",
                "5ee9d653bfefe792d5c6d137",
                "5f856afa3e3d042cf5c61151",
                "5f8424c9b58d297e8b318a77",
                "5f8424c9b58d297e8b318a77",
                "5f8570baea8ceed36e64aa8a",
                "5f856c263e3d042cf5c61774",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8424c9b58d297e8b318a77",
                "5f8424c9b58d297e8b318a77",
                "5f8570baea8ceed36e64aa8a",
                "5ee9d653bfefe792d5c6d137",
                "5ee9d653bfefe792d5c6d137",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f856afa3e3d042cf5c61151",
                "5f8570baea8ceed36e64aa8a",
                "5f856afa3e3d042cf5c61151",
                "5f8424c9b58d297e8b318a77",
                "5f843a3d1aef5b0e841fe11c",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5ee9d653bfefe792d5c6d137",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f856afa3e3d042cf5c61151",
                "5f8424c9b58d297e8b318a77",
                "5f8424c9b58d297e8b318a77",
                "5f8425c4fa4b9629a41e43c9",
                "5f8425c4fa4b9629a41e43c9",
                "5f8425c4fa4b9629a41e43c9",
                "5f8425c4fa4b9629a41e43c9",
                "5f857068e2c2fb7ab0cc0b70",
                "5f857068e2c2fb7ab0cc0b70",
                "5f8425c4fa4b9629a41e43c9",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8424c9b58d297e8b318a77",
                "5f8424c9b58d297e8b318a77",
                "5f8424c9b58d297e8b318a77",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f856c263e3d042cf5c61774",
                "5ee9d653bfefe792d5c6d137",
                "5f843a3d1aef5b0e841fe11c",
                "5f8425c4fa4b9629a41e43c9",
                "5ee9d653bfefe792d5c6d137",
                "5f857068e2c2fb7ab0cc0b70",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8425c4fa4b9629a41e43c9",
                "5f857068e2c2fb7ab0cc0b70",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f843a3d1aef5b0e841fe11c",
                "5f856afa3e3d042cf5c61151",
                "5ee9d653bfefe792d5c6d137",
                "5f856afa3e3d042cf5c61151",
                "5f856afa3e3d042cf5c61151",
                "61711a9c7e88fdceab193fdd",
                "5f843cecfa4b9629a41ec0b7",
                "5f8425c4fa4b9629a41e43c9",
                "5f856afa3e3d042cf5c61151",
                "5f8570baea8ceed36e64aa8a",
                "5f856afa3e3d042cf5c61151",
                "5ee9d653bfefe792d5c6d137",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8424c9b58d297e8b318a77",
                "5ee9d653bfefe792d5c6d137",
                "5f8425c4fa4b9629a41e43c9",
                "5f8425c4fa4b9629a41e43c9",
                "5ee9d653bfefe792d5c6d137",
                "5f8425c4fa4b9629a41e43c9",
                "5f8424c9b58d297e8b318a77",
                "5f843cecfa4b9629a41ec0b7",
                "5f856afa3e3d042cf5c61151",
                "5ee9d653bfefe792d5c6d137",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8424c9b58d297e8b318a77",
                "5f8425c4fa4b9629a41e43c9",
                "5f8424c9b58d297e8b318a77",
                "5f8424c9b58d297e8b318a77",
                "5f8424c9b58d297e8b318a77",
                "5f8425c4fa4b9629a41e43c9",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8425c4fa4b9629a41e43c9",
                "5f856c263e3d042cf5c61774",
                "5f856c263e3d042cf5c61774",
                "5f857068e2c2fb7ab0cc0b70",
                "5f857068e2c2fb7ab0cc0b70",
                "5f857068e2c2fb7ab0cc0b70",
                "5f857068e2c2fb7ab0cc0b70",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f856afa3e3d042cf5c61151",
                "5f8570baea8ceed36e64aa8a",
                "5f856afa3e3d042cf5c61151",
                "5f843a3d1aef5b0e841fe11c",
                "5f843cecfa4b9629a41ec0b7",
                "5f856c263e3d042cf5c61774",
                "5f8570baea8ceed36e64aa8a",
                "5f8424c9b58d297e8b318a77",
                "5f8424c9b58d297e8b318a77",
                "5f857068e2c2fb7ab0cc0b70",
                "5f8424c9b58d297e8b318a77",
                "5f856afa3e3d042cf5c61151",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f856afa3e3d042cf5c61151",
                "5f8570baea8ceed36e64aa8a",
                "5f843a3d1aef5b0e841fe11c",
                "5f8570baea8ceed36e64aa8a",
                "5f8424c9b58d297e8b318a77",
                "5f8424c9b58d297e8b318a77",
                "5f8424c9b58d297e8b318a77",
                "5f856afa3e3d042cf5c61151",
                "5f856afa3e3d042cf5c61151",
                "5ee9d653bfefe792d5c6d137",
                "5ee9d653bfefe792d5c6d137",
                "5f8570baea8ceed36e64aa8a",
                "5f8570baea8ceed36e64aa8a",
                "5f8425c4fa4b9629a41e43c9",
                "5f8425c4fa4b9629a41e43c9",
                "5f8570baea8ceed36e64aa8a",
                "5f856afa3e3d042cf5c61151",
                "5f856c263e3d042cf5c61774"
        };


        String[] arr1 = new String[]{"5f8424c9b58d297e8b318a77","5f842646fa4b9629a41e465c",
                "5f8425c4fa4b9629a41e43c9","5fbb8a5fe75884212062de06",
                "5f843a3d1aef5b0e841fe11c","5f843cecfa4b9629a41ec0b7",
                "5ee9d653bfefe792d5c6d137"};
        String[] arr2 = new String[]{"5f857068e2c2fb7ab0cc0b70","5f8570baea8ceed36e64aa8a",
                "61711a9c7e88fdceab193fdd","5f856afa3e3d042cf5c61151",
                "5f856c263e3d042cf5c61774"};

        HashMap<String, String> stringStringHashMap = new HashMap<>();

        for (String a:
        arr1) {
            stringStringHashMap.put(a,"最右");
        }
        for (String a:
        arr2) {
            stringStringHashMap.put(a,"皮皮");
        }


        //若统计的是int数组，先转化为List
        List<String> list = Arrays.stream(arr).collect(Collectors.toList());
//groupingBy分组
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//控制台输出map
        map.forEach((k, v) -> {
            System.out.println("队列id = " + k + ",进入敏感图数量 =" + v + ",  所属 appId = "+ stringStringHashMap.get(k));
        });

    }
}


//5f8570baea8ceed36e64aa8a,进入敏感图数量 =56,  所属 appId = 皮皮  （济南基础-短视频）
//5f856afa3e3d042cf5c61151,进入敏感图数量 =27,  所属 appId = 皮皮
//5f8425c4fa4b9629a41e43c9,进入敏感图数量 =24,  所属 appId = 最右
//5f8424c9b58d297e8b318a77,进入敏感图数量 =25,  所属 appId = 最右
//5ee9d653bfefe792d5c6d137,进入敏感图数量 =16,  所属 appId = 最右
//5f857068e2c2fb7ab0cc0b70,进入敏感图数量 =12,  所属 appId = 皮皮
//5f856c263e3d042cf5c61774,进入敏感图数量 =8,  所属 appId = 皮皮
//5f843cecfa4b9629a41ec0b7,进入敏感图数量 =8,  所属 appId = 最右
//5f843a3d1aef5b0e841fe11c,进入敏感图数量 =5,  所属 appId = 最右
//61711a9c7e88fdceab193fdd,进入敏感图数量 =2,  所属 appId = 皮皮
//

