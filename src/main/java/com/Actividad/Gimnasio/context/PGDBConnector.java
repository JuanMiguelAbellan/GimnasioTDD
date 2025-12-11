package com.Actividad.Gimnasio.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PGDBConnector {

    private static Connection connection;

    private PGDBConnector(){}

    public static Connection getInstance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://postgresservidor.cneyuookagv4.us-east-1.rds.amazonaws.com:5432/gimnasio",
                        "postgre", "admin.12345678");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
