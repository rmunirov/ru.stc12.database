package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.pojo.Teacher;

import java.util.List;

public class TeacherDao implements GenericDao<Teacher, Integer> {
    @Override
    public boolean create(Teacher entity) {
        return false;
    }

    @Override
    public Teacher read(Integer id) {
        return null;
    }

    @Override
    public Teacher update(Teacher entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Teacher> getAll() {
        return null;
    }
}
