package ru.innopolis.stc12.jdbc.realExample.dao;

import java.util.List;

public interface GenericDao<E> {
    boolean create(E entity);

    E read(int id);

    boolean update(E entity);

    boolean delete(int id);

    List<E> getAll();
}
