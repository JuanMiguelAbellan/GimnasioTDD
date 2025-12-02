package com.Actividad.Gimnasio.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBConnector {

    private static Connection connection;

    private MySQLDBConnector(){}

    public static Connection getInstance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://videojuegos.cneyuookagv4.us-east-1.rds.amazonaws.com:3306/gimnasio",
                        "admin", "admin.12345678");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
