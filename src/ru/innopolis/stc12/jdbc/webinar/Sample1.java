package ru.innopolis.stc12.jdbc.webinar;

import java.sql.*;

public class Sample1 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "hfbkm1988")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

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
