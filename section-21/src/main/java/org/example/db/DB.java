package org.example.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection connection;
    private static boolean isOnTransaction = false;

    private static Properties loadProperties() {
        try(FileInputStream fileInputStream = new FileInputStream("src/main/resources/db.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                try {
                    Properties properties = loadProperties();
                    String url = properties.getProperty("dburl");
                    connection = DriverManager.getConnection(url, properties);
                    connection.setAutoCommit(!DB.isOnTransaction);
                } catch (SQLException e) {
                    throw new DbException(e.getMessage());
                }

            }
        }
        catch (Exception e) {
            throw new DbException(e.getMessage());
        }

        return connection;
    }


    public static void closeConnection() {
       if (connection != null) {
           try {
               connection.close();
           } catch (SQLException e) {
               throw new DbException(e.getMessage());
           }
       }
    }

    public static void setIsOnTransaction(boolean isOnTransaction) {
        DB.isOnTransaction = isOnTransaction;
    }
}
