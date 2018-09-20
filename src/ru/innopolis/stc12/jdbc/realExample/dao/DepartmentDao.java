package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.pojo.Department;

import java.util.List;

public class DepartmentDao implements GenericDao<Department, Integer> {
    @Override
    public boolean create(Department entity) {
        return false;
    }

    @Override
    public Department read(Integer id) {
        return null;
    }

    @Override
    public Department update(Department entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Department> getAll() {
        return null;
    }
}
