package com.example.demo.sharding;

import lombok.extern.slf4j.Slf4j;
import lombok.var;

@Slf4j
public class RangeShardingTest {

    public static void main(String[] args) {

        var data1 = new Data(1, "data1", Data.DataType.TYPE1);
        var data2 = new Data(2, "data2", Data.DataType.TYPE2);
        var data3 = new Data(3, "data3", Data.DataType.TYPE3);
        var data4 = new Data(4, "data4", Data.DataType.TYPE1);
        var rangeShardManager = new RangeShardManager();
        var shard1 = new DataShard(1);
        var shard2 = new DataShard(2);
        var shard3 = new DataShard(3);
        var shard4 = new DataShard(-1);
        rangeShardManager.addNewShard(shard1);
        rangeShardManager.addNewShard(shard2);
        rangeShardManager.addNewShard(shard3);
        rangeShardManager.addNewShard(shard4);

        rangeShardManager.storeData(data1);
        rangeShardManager.storeData(data2);
        rangeShardManager.storeData(data3);
        rangeShardManager.storeData(data4);
        log.info("data:{}",rangeShardManager.shardMap);
    }
}
