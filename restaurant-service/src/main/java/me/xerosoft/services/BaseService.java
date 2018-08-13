package me.xerosoft.services;

import me.xerosoft.repositories.BaseRepository;

/**
 * Created by xero on 8/7/18.
 */
public abstract class BaseService<TE, T> extends ReadOnlyService<TE, T> {
    private final BaseRepository<TE, T> repository;

    public BaseService(BaseRepository<TE, T> repository) {
        super(repository);
        this.repository = repository;
    }

    public void add(TE entity) throws Exception {
        repository.add(entity);
    }
}
