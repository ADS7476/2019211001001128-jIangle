package com.jiangle.week4.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBCTest {
    public static void main(String[] a) throws SQLException, ClassNotFoundException {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=db;";
        String username = "jl1";
        String password = "123456";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,username,password);
        System.out.println(con);
    }
}