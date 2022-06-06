package org.example.repository;

import java.util.ArrayList;
import java.util.List;

public class AbstractListRepository<T> implements IRepository<T> {

    protected List<T> persistenceList;

    public AbstractListRepository() {
        persistenceList = new ArrayList<>();
    }

    @Override
    public void save(T object) {
        persistenceList.add(object);
    }

    @Override
    public T read(T object) {
        return persistenceList.contains(object) ? object : null;
    }
}
