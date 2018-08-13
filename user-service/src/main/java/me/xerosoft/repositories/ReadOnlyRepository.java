package me.xerosoft.repositories;

import java.util.Collection;

/**
 * Created by xero on 8/10/18.
 */
public interface ReadOnlyRepository<TE, T> {
    TE get(T id);
    boolean contains(T id);
    Collection<TE> getAll();
}
