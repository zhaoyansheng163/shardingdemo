package com.example.demo.sharding;

@lombok.Data
public class Data {

    private int key;
    private String value;
    private DataType type;

    public Data(final int key, final String value, final DataType type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

    enum DataType {
        TYPE1, TYPE2, TYPE3
    }
}
