package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

public class jdbc1 {

    public static Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/employeepayroll?useSSL=false";
        String userName = "root";
        String passWord = "123456789";
        Connection con;
        con = DriverManager.getConnection(jdbcURL, userName, passWord);
        return con;
    }

    public static void main(String [] args) {
        String sql = "SELECT * FROM employee_payroll";
        try {
            Connection connection = getConnection();
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("fname");
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("salary");
                double Phone=resultSet.getDouble("Phone");
                LocalDate start = resultSet.getDate("start").toLocalDate();
                System.out.println(id+" "+name+" "+gender+" "+" " + Phone + salary+" "+start);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}