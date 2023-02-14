package com.example.demo.sharding;



import lombok.var;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class LookupShardManager extends DataShardManager {

    private final Map<Integer, Integer> lookupMap = new HashMap<>();

    @Override
    public int storeData(Data data) {
        var shardId = allocateShard(data);
        lookupMap.put(data.getKey(), shardId);
        var shard = shardMap.get(shardId);
        shard.storeData(data);
        return shardId;
    }

    @Override
    protected int allocateShard(Data data) {
        var key = data.getKey();
        //根据查找表执行查找操作
        if (lookupMap.containsKey(key)) {
            return lookupMap.get(key);
        } else {
            var shardCount = shardMap.size();
            return new SecureRandom().nextInt(shardCount - 1) + 1;
        }
    }
}