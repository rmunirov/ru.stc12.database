package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.pojo.City;

import java.util.List;

public class CityDao implements GenericDao<City, Integer> {
    @Override
    public boolean create(City entity) {
        return false;
    }

    @Override
    public City read(Integer id) {
        return null;
    }

    @Override
    public City update(City entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<City> getAll() {
        return null;
    }
}
