package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.connectionManager.ConnectionManager;
import ru.innopolis.stc12.jdbc.realExample.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc12.jdbc.realExample.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class StudentDao implements GenericDao<Student, Integer> {
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    public boolean deleteStudentByName(Student student) {
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students WHERE name=? AND family_name=?")) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getFamilyName());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Student read(Integer id) {
        Connection connection = connectionManager.getConnection();
        Student student = null;
        String sql = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    student = new Student(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getInt(6));
                    return student;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return student;
    }


    @Override
    public Student update(Student entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
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
