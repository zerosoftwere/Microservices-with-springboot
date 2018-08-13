package me.xerosoft.repositories;

/**
 * Created by xero on 8/7/18.
 */
public interface BaseRepository<TE, T> extends ReadOnlyRepository<TE, T> {
    void add(TE entity);
    void remove(T id);
    void update(TE entity);
}
