package macleetcode;

import java.util.*;

public class Shard {
    public Map<String,List<Integer>> sharding(List<String> nodes,int sharding){
        Map<String, List<Integer>> shardingResult = new HashMap<>();
        if (nodes == null||nodes.isEmpty()) {
            return shardingResult;
        }
        int count = 0;
        int nodeSize = nodes.size();
        int itemCount = sharding/nodeSize;
        int aliquant = sharding- itemCount*nodeSize;
        for (String node: nodes) {
            List<Integer> shardingItem = new ArrayList<>();
            for (int i = count*itemCount; i < (count+1)*itemCount; i++) {
                shardingItem.add(i);
            }
            if (count <aliquant) {
                int item = itemCount*nodeSize+count;
                shardingItem.add(item);
            }
            shardingResult.put(node,shardingItem );
            count++;
        }
        return shardingResult;
    }

    public static void main(String[] args) {
        Shard shard = new Shard();
        List<String> strings = new ArrayList<>();
        strings.add("0");
        strings.add("1");
        strings.add("2");

        Map<String, List<Integer>> sharding = shard.sharding(strings, 8);

        Set<Map.Entry<String, List<Integer>>> entries = sharding.entrySet();
        for (Map.Entry<String, List<Integer>> a:
             entries) {
            String key = a.getKey();
            List<Integer> value = a.getValue();
            System.out.println("key:"+key+" value: "+value.toString());
        }
    }
}
