package com.jfxbase.oopjfxbase;

import java.sql.*;

public class DBConnection {
    public static Connection conn = null;
    public static void connect() {

        try {
            String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres";
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to PostgreSQL has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
