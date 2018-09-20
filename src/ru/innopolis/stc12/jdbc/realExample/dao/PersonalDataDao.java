package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.pojo.PersonalData;

import java.util.List;

public class PersonalDataDao implements GenericDao<PersonalData, Integer> {
    @Override
    public boolean create(PersonalData entity) {
        return false;
    }

    @Override
    public PersonalData read(Integer id) {
        return null;
    }

    @Override
    public PersonalData update(PersonalData entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<PersonalData> getAll() {
        return null;
    }
}
