package me.xerosoft.models;

/**
 * Created by xero on 8/10/18.
 */
public abstract class Entity<T> {
    protected T id;
    protected String name;

    public Entity(T id, String name) {
        this.id = id;
        this.name = name;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
