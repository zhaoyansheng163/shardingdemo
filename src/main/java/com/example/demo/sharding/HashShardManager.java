package com.example.demo.sharding;
import lombok.var;

public class HashShardManager extends DataShardManager {

    @Override
    public int storeData(Data data) {
        var shardId = allocateShard(data);
        var shard = shardMap.get(shardId);
        shard.storeData(data);
        return shardId;
    }

    @Override
    protected int allocateShard(Data data) {
        var shardCount = shardMap.size();
        //执行哈希算法
        var hash = data.getKey() % shardCount;
        return hash == 0 ? hash + shardCount : hash;
    }
}