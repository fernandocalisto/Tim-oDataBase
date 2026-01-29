package calistofernando.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("database.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.err.println("ERRO: O arquivo database.properties não foi encontrado!");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(props.getProperty("db.url"),props.getProperty("db.user") , props.getProperty("db.password"));
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to Database", e);
        }
    }
}
