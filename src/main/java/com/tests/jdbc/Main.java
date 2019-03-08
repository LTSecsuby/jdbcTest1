package com.tests.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private final static String USERNAME = "root";
    private final static String USERPASS = "root";
    private final static String USERURL = "jdbc:mysql://localhost:3333/Mysql";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Driver driver;

        try{
            driver = new com.mysql.jdbc.Driver();
        } catch (SQLException ex) {
            System.out.println("create driver error");
            return;
        }

        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException ex) {
            System.out.println("to register driver error");
            return;
        }

        try {
            connection = DriverManager.getConnection(USERURL, USERNAME, USERPASS);

            System.out.println("use code..");

        } catch (SQLException ex) {
            System.out.println("create connection error");
            return;
        } finally {
            if(connection != null) {
                connection.close();
            }
        }

    }
}