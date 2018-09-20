package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.pojo.Group;

import java.util.List;

public class GroupDao implements GenericDao<Group, Integer> {
    @Override
    public boolean create(Group entity) {
        return false;
    }

    @Override
    public Group read(Integer id) {
        return null;
    }

    @Override
    public Group update(Group entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Group> getAll() {
        return null;
    }
}
