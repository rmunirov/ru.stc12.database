package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.pojo.Discipline;

import java.util.List;

public class DisciplineDao implements GenericDao<Discipline, Integer> {
    @Override
    public boolean create(Discipline entity) {
        return false;
    }

    @Override
    public Discipline read(Integer id) {
        return null;
    }

    @Override
    public Discipline update(Discipline entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Discipline> getAll() {
        return null;
    }
}
