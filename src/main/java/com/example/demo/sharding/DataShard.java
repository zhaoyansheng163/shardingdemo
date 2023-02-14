package com.example.demo.sharding;


import java.util.HashMap;
import java.util.Map;
@lombok.Data
public class DataShard {

    private final int id;
    private final Map<Integer, Data> dataStore;

    public DataShard(final int id) {
        this.id = id;
        this.dataStore = new HashMap<>();
    }

    public void storeData(Data data) {
        dataStore.put(data.getKey(), data);
    }

    public void clearData() {
        dataStore.clear();
    }

    public Data getDataById(final int id) {
        return dataStore.get(id);
    }

    public int getId() {
        return id;
    }
}