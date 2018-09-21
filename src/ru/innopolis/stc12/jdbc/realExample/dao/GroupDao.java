package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.pojo.Group;
import ru.innopolis.stc12.jdbc.realExample.pojo.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDao extends AbstractDao<Group> {
    public GroupDao() {
        readSql = "SELECT * FROM groups WHERE id = ?";
        createSql = "INSERT INTO groups VALUES (DEFAULT , ?, ?)";
        deleteSql = "DELETE FROM groups WHERE id=?";
        updateSql = "UPDATE groups SET name=?, teacher=? WHERE id=?";
        readAllSql = "SELECT * FROM groups";
    }

    @Override
    protected List<Group> readParse(ResultSet resultSet) throws SQLException {
        List<Group> list = new ArrayList<>();
        while (resultSet.next()) {
            Teacher teacher = DaoFactory.getTeacherDao().read(resultSet.getInt("curator"));
            list.add(new Group(resultSet.getInt("id"), resultSet.getString("name"), teacher));
        }
        return list;
    }

    @Override
    protected boolean createParse(PreparedStatement statement, Group entity) throws SQLException {
        if (entity.getCurator() == null) return false;
        statement.setString(1, entity.getName());
        statement.setInt(2, entity.getCurator().getId());
        return statement.execute();
    }

    @Override
    protected boolean updateParse(PreparedStatement statement, Group entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setInt(2, entity.getCurator().getId());
        statement.setInt(3, entity.getId());
        return statement.execute();
    }
}
