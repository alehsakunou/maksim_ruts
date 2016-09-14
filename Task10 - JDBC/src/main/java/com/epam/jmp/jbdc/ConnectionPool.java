package com.epam.jmp.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton connection pool
 * Created by Gambit on 9/14/2016.
 */
public final class ConnectionPool {
    private volatile static Connection CONNECTION;

    private ConnectionPool() {
    }

    /**
     * Get free connection from pool
     * @return Connection from pool
     * @throws SQLException if connection does not exist
     */
    public static Connection getConnection() throws SQLException {
        if (CONNECTION == null) {
            synchronized (ConnectionPool.class){
                if (CONNECTION == null) {
                    CONNECTION = DriverManager.getConnection(
                            "jdbc:derby:memory:jmp;create=true",
                            "derbyuser",
                            "derbyuser");
                }
            }
        }
        return CONNECTION;
    }
}
