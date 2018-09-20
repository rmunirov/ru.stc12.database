package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.pojo.Perfomance;

import java.util.List;

public class PerfomanceDao implements GenericDao<Perfomance, Integer> {
    @Override
    public boolean create(Perfomance entity) {
        return false;
    }

    @Override
    public Perfomance read(Integer id) {
        return null;
    }

    @Override
    public Perfomance update(Perfomance entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Perfomance> getAll() {
        return null;
    }
}
