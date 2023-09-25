package org.example.platzi.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/project";
    private static String user = "root";
    private static String password = "";

    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {
        if(pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(user);
            pool.setPassword(password);

            //setInitialSize(int): Establece el tamaño inicial del pool de conexiones.
            pool.setInitialSize(3);
            //setMinIdle(int): Establece el número mínimo de conexiones inactivas que el pool debe mantener en todo momento.
            pool.setMinIdle(3);
            //setMaxIdle(int): Establece el número máximo de conexiones inactivas que el pool puede mantener en todo momento.
            pool.setMaxIdle(10);
            //setMaxTotal(int): Establece el número máximo de conexiones totales que el pool puede mantener activas simultáneamente.
            pool.setMaxTotal(10);

        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
