package me.xerosoft.models;

/**
 * Created by xero on 8/10/18.
 */
public class BaseEntity<T> extends Entity<T> {
    protected final boolean isModified;

    public BaseEntity(T id, String name) {
        super(id, name);
        this.isModified = false;
    }

    public boolean isModified() {
        return isModified;
    }
}
