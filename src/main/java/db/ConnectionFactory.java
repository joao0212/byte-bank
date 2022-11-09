package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/byte_bank",
                            "root", "root");
        } catch (Exception exception) {
            throw new RuntimeException();
        }
    }
}
