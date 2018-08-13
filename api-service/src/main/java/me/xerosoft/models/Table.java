package me.xerosoft.models;

import java.math.BigInteger;

/**
 * Created by xero on 8/10/18.
 */
public class Table {
    private BigInteger id;
    private String name;
    private int capacity;

    public Table(BigInteger id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public Table() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
