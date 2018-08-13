package me.xerosoft.services;

import me.xerosoft.repositories.ReadOnlyRepository;

import java.util.Collection;

/**
 * Created by xero on 8/10/18.
 */
public abstract class ReadOnlyService<TE, T> {
    private final ReadOnlyRepository<TE, T> repository;

    public ReadOnlyService(ReadOnlyRepository repository) {
        this.repository = repository;
    }

    public ReadOnlyRepository<TE, T> getRepository() {
        return repository;
    }

    Collection<TE> getAll() {
        return repository.getAll();
    }
}
