package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Connection connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_management_system_v1",
                    "root",
                    "1234");
            String sql2="INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement1= connection.prepareStatement(sql2);
            preparedStatement1.setString(1, "sasindu");
            preparedStatement1.setString(2, "p12");
            preparedStatement1.executeUpdate();
            preparedStatement1.setString(1, "ravindu");
            preparedStatement1.setString(2, "p121");
            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            Connection connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_management_system_v1",
                    "root",
                    "1234");
            String sql="select * from users;";
            java.sql.PreparedStatement preparedStatement =connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String dbUserName= resultSet.getString("username");
                String dbPassword = resultSet.getString("password");
                System.out.println(dbUserName +"-"+dbPassword);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }





    }
}