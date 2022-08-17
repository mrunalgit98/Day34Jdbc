package com;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class jdbc {
    public static void main(String[] args) {


        String jdbcurl = "jdbc:mysql://localhost:3306/employeepayroll?useSSL=false";

        String user = "root";

        String pass = "123456789";

        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded");
        }catch (ClassNotFoundException e){
          throw new IllegalStateException("cannot find driver",e);
        }
   listDriver();
        try {
            System.out.println("connectiong to database " +jdbcurl);
            connection=DriverManager.getConnection(jdbcurl,user,pass);
            System.out.println("connection is succesful " + connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void listDriver(){
        Enumeration<Driver>driverlist= DriverManager.getDrivers();
        while (driverlist.hasMoreElements()){
            Driver driverclass=(Driver) driverlist.nextElement();
            System.out.println(" " +driverclass.getClass().getName());
        }
    }
}
