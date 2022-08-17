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
        String s2 = "SELECT * FROM employee_payroll";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("update employee_payroll set basicPay =? where fname=?");
            preparedStatement.setInt(1,3500000);
            preparedStatement.setString(2,"Terisa");
            java.sql.Statement statement=connection.createStatement();
            int result=preparedStatement.executeUpdate();
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