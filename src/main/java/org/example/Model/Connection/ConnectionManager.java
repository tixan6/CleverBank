package org.example.Model.Connection;

import java.nio.file.NotDirectoryException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static final String URL_KEY = "url.db";
    public static final String USER_KEY = "user.db";
    public static final String PASSWORD_KEY = "password.db";

    static
    {
        loadDriver();
    }
    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection()
    {
        try {
            return DriverManager.getConnection(
                    PropertyUtill.GetProperties(URL_KEY),
                    PropertyUtill.GetProperties(USER_KEY),
                    PropertyUtill.GetProperties(PASSWORD_KEY)
            );
        }
        catch (SQLException exception)
        {
            throw new RuntimeException(exception);
        }

    }
}
