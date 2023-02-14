package com.example.demo.sharding;

import lombok.var;

public class RangeShardManager extends DataShardManager {

    @Override
    public int storeData(Data data) {
        var shardId = allocateShard(data);
        var shard = shardMap.get(shardId);
        shard.storeData(data);
        return shardId;
    }

    @Override
    protected int allocateShard(Data data) {
        var type = data.getType();
        //根据Type按照范围进行分片
        switch (type) {
            case TYPE1:
                return 1;
            case TYPE2:
                return 2;
            case TYPE3:
                return 3;
            default:
                return -1;
        }
    }
}