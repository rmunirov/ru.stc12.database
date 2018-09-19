package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.connectionManager.ConnectionManager;
import ru.innopolis.stc12.jdbc.realExample.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc12.jdbc.realExample.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean addStudent(Student student) {
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students VALUES (DEFAULT , ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getFamilyName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getContact());
            preparedStatement.setInt(5, student.getCity());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Student getStydentById(int id) {
        Connection connection = connectionManager.getConnection();
        Student student = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE id = ?")) {
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
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean deleteStudentById(int id) {
        return false;
    }

    @Override
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
}
