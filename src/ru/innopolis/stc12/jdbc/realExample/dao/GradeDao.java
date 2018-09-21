package ru.innopolis.stc12.jdbc.realExample.dao;


import ru.innopolis.stc12.jdbc.realExample.pojo.Grade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDao extends AbstractDao<Grade> {
    public GradeDao() {
        readSql = "SELECT * FROM grade WHERE id = ?";
        createSql = "INSERT INTO grade VALUES (DEFAULT , ?)";
        deleteSql = "DELETE FROM grade WHERE id=?";
        updateSql = "UPDATE grade SET name=? WHERE id=?";
        readAllSql = "SELECT * FROM grade";
    }

    @Override
    protected List<Grade> readParse(ResultSet resultSet) throws SQLException {
        List<Grade> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new Grade(resultSet.getInt("id"), resultSet.getInt("point")));
        }
        return list;
    }

    @Override
    protected boolean createParse(PreparedStatement statement, Grade entity) throws SQLException {
        statement.setInt(1, entity.getGrade());
        return statement.execute();
    }

    @Override
    protected boolean updateParse(PreparedStatement statement, Grade entity) throws SQLException {
        statement.setInt(1, entity.getGrade());
        statement.setInt(2, entity.getId());
        return statement.execute();
    }
}
