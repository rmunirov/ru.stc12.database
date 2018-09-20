package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.connectionManager.ConnectionManager;
import ru.innopolis.stc12.jdbc.realExample.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc12.jdbc.realExample.pojo.Group;
import ru.innopolis.stc12.jdbc.realExample.pojo.PersonalData;
import ru.innopolis.stc12.jdbc.realExample.pojo.Sex;
import ru.innopolis.stc12.jdbc.realExample.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class StudentDao extends AbstractDao<Student, Integer> {
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();   //TODO this right?

    public StudentDao() {
        readSql = "SELECT * FROM students WHERE id = ?";
    }

    @Override
    protected Student readParse(PreparedStatement statement, Integer id) throws SQLException {
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Sex sex = DaoFactory.getSexDao().read(resultSet.getInt("sex"));
            Group group = DaoFactory.getGroupDao().read(resultSet.getInt("group"));
            PersonalData personalData = DaoFactory.getPersonalDataDao().read(resultSet.getInt("personal_data"));

            return new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    sex,
                    resultSet.getDate("date_of_receipt"),
                    group,
                    personalData);
        }
        return null;
    }

    @Override
    public boolean create(Student entity) {
        Connection connection = connectionManager.getConnection();
        String sql = "INSERT INTO students VALUES (DEFAULT , ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getSurname());
            preparedStatement.setInt(3, entity.getSex().getId());
            preparedStatement.setDate(4, convertUtilDateToSqlDate(entity.getDateOfReceipt()));
            preparedStatement.setInt(5, entity.getGroup().getId());
            preparedStatement.setInt(6, entity.getPersonalData().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private java.sql.Date convertUtilDateToSqlDate(Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }
}
