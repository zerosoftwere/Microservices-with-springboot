package me.xerosoft.repositories;

import me.xerosoft.models.Entity;

import java.util.Collection;

/**
 * Created by xero on 8/7/18.
 */
public interface ReadOnlyRepository<TE, T> {
    boolean contains(T id);
    Entity get(T id);
    Collection<TE> getAll();
}
