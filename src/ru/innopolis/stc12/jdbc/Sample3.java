package ru.innopolis.stc12.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sample3 {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "hfbkm1988")) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students SET age = 20 WHERE id = ?");
            for (String arg : args) {
                preparedStatement.setInt(1, Integer.valueOf(arg));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
