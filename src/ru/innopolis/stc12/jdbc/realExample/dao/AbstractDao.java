package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.connectionManager.ConnectionManager;
import ru.innopolis.stc12.jdbc.realExample.connectionManager.ConnectionManagerJdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<E, K> implements GenericDao<E, K> {
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();   //TODO this right?
    protected String readSql;

    protected abstract E readParse(PreparedStatement statement, K id) throws SQLException;

    @Override
    public boolean create(E entity) {
        return false;
    }

    @Override
    public E read(K id) {
        Connection connection = connectionManager.getConnection();
        E entity;
        try (PreparedStatement preparedStatement = connection.prepareStatement(readSql)) {
            entity = readParse(preparedStatement, id);
            return entity;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public E update(E entity) {
        return null;
    }

    @Override
    public boolean delete(K id) {
        return false;
    }

    @Override
    public List<E> getAll() {
        return null;
    }
}
