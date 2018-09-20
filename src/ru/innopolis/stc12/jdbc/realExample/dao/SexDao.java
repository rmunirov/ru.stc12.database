package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.pojo.Sex;

import java.util.List;

public class SexDao implements GenericDao<Sex, Integer> {
    @Override
    public boolean create(Sex entity) {
        return false;
    }

    @Override
    public Sex read(Integer id) {
        return null;
    }

    @Override
    public Sex update(Sex entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Sex> getAll() {
        return null;
    }
}
