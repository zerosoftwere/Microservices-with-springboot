package me.xerosoft.repositories;

/**
 * Created by xero on 8/10/18.
 */
public interface BaseRepository<TE, T> extends ReadOnlyRepository<TE, T>{
    void add(TE entity);
    void update(TE entity);
    void remove(T id);
}
