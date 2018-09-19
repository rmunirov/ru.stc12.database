package ru.innopolis.stc12.jdbc;

import java.sql.*;

public class Sample2 {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "hfbkm1988")) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE city = ? and age > ?;");
            preparedStatement.setString(1, "Samara");
            preparedStatement.setInt(2, 18);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getString("name") + ";");
                System.out.print(resultSet.getString("family_name") + ";");
                System.out.print(resultSet.getInt("age") + ";");
                System.out.print(resultSet.getString("city") + ";");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
