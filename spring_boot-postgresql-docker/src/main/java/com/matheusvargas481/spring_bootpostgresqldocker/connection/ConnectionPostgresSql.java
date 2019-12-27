package com.matheusvargas481.spring_bootpostgresqldocker.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPostgresSql {
    private static ConnectionPostgresSql connection;

    public static ConnectionPostgresSql getInstance() {
        if (connection == null) {
            connection = new ConnectionPostgresSql();
        }
        return connection;
    }

    public static Connection getConnection() {
        Connection connection = null;
        ResourceBundle bundle = ResourceBundle.getBundle("application");
        try {
            Class.forName(bundle.getString("driverClassName"));
            connection = DriverManager.getConnection(bundle.getString("jdbcUrl"),
                    bundle.getString("username"),
                    bundle.getString("password"));
            System.out.println("Opened database successfully");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Nao foi possivel conectar-se ao banco de dados: " + e.getMessage());
            System.exit(0);
        }
        return connection;
    }
}