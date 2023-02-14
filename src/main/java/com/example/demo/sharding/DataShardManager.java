package com.example.demo.sharding;

import lombok.var;

import java.util.HashMap;
import java.util.Map;

public abstract class DataShardManager {

    protected Map<Integer, DataShard> shardMap;

    public DataShardManager() {
        shardMap = new HashMap<>();
    }

    //添加一个新的DataShard
    public boolean addNewShard(final DataShard shard) {
        var shardId = shard.getId();
        if (!shardMap.containsKey(shardId)) {
            shardMap.put(shardId, shard);
            return true;
        } else {
            return false;
        }
    }

    //根据Id移除一个DataShard
    public boolean removeShardById(final int shardId) {
        if (shardMap.containsKey(shardId)) {
            shardMap.remove(shardId);
            return true;
        } else {
            return false;
        }
    }

    //根据Id获取一个DataShard
    public DataShard getShardById(final int shardId) {
        return shardMap.get(shardId);
    }

    //将数据存储在合适的DataShard中
    public abstract int storeData(final Data data);

    //将一个DataShard分配给具体的数据
    protected abstract int allocateShard(final Data data);
}