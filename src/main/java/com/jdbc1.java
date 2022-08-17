package com;

import java.sql.*;
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
        String s2 = "SELECT * FROM EMPLOYEE_PAYROLL WHERE START BETWEEN CAST('2019-01-01' AS DATE) AND DATE(NOW())";
        try {
            Connection connection = getConnection();
            java.sql.Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(s2);
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("fname");
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("salary");
                double Phone=resultSet.getDouble("Phone");
                LocalDate start = resultSet.getDate("start").toLocalDate();
                double basic=resultSet.getDouble("basicPay");
                System.out.println(id+ " id "+name+" fname " + gender+  "  " + Phone + " salary " + salary + " "+start +" "+ basic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}