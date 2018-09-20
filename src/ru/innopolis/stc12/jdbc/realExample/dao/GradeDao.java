package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.pojo.Grade;

import java.util.List;

public class GradeDao implements GenericDao<Grade, Integer> {
    @Override
    public boolean create(Grade entity) {
        return false;
    }

    @Override
    public Grade read(Integer id) {
        return null;
    }

    @Override
    public Grade update(Grade entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Grade> getAll() {
        return null;
    }
}
