package me.xerosoft.services;

import me.xerosoft.repositories.BaseRepository;

/**
 * Created by xero on 8/10/18.
 */
public class BaseService<TE, T> extends ReadOnlyService<TE, T> {

    private final BaseRepository repository;

    public BaseService(BaseRepository<TE, T> repository) {
        super(repository);
        this.repository = repository;
    }

    public void add(TE enitity) throws Exception {
        repository.add(enitity);
    }
}
