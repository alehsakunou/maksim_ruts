package by.epam.jmp.patterns.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Gambit on 7/25/2016.
 */
public class DBHelper {
    private static final String ID_FIELD = "    id BIGINT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),";
    private static final String CREATE_TABLE =
            "CREATE TABLE PERSONS" +
                    "(" +
                    ID_FIELD +
                    "    NAME VARCHAR(100),\n" +
                    "    AGE INT\n" +
                    ")";
    public static final String URL = "jdbc:derby:memory:springCoreDB;create=true";
    public static final String USER = "derbyuser";
    public static final String PASSWORD = "derbyuser";

    private static volatile Connection CONNECTION_INSTANCE = null;

    static {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (CONNECTION_INSTANCE == null) {
            synchronized (DBHelper.class) {
                if (CONNECTION_INSTANCE == null) {
                    try {
                        CONNECTION_INSTANCE = DriverManager.getConnection(URL, USER, PASSWORD);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return CONNECTION_INSTANCE;
    }

    public static void createTables() {
        try {
            getConnection().createStatement().execute(CREATE_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
