package me.xerosoft.services;

import me.xerosoft.repositories.ReadOnlyRepository;

import java.util.Collection;

/**
 * Created by xero on 8/7/18.
 */
public abstract class ReadOnlyService<TE, T> {
    private  final ReadOnlyRepository<TE, T> repository;

    public ReadOnlyService(ReadOnlyRepository<TE, T> repository) {
        this.repository = repository;
    }

    public ReadOnlyRepository<TE, T> getRepository() {
        return repository;
    }

    public Collection<TE> getAll() {
        return repository.getAll();
    }
}
