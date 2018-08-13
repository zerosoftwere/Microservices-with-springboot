package me.xerosoft.models;

import java.math.BigInteger;

/**
 * Created by xero on 8/7/18.
 */
public class Table extends BaseEntity<BigInteger> {

    private int capacity;

    public Table(BigInteger id, String name, int capacity) {
        super(id, name);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format("{id: %s, name: %s, capacity: %s}", getId(), getName(), getCapacity());
    }
}
