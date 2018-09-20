package ru.innopolis.stc12.jdbc.realExample.dao;

import java.util.List;

public interface GenericDao<E, K> {
    boolean create(E entity);

    E read(K id);

    E update(E entity);

    boolean delete(K id);

    List<E> getAll();
}
