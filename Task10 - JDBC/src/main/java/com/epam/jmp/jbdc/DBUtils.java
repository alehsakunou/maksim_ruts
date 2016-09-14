package com.epam.jmp.jbdc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Consumer;

/**
 * Util class for database support
 * Created by Gambit on 9/15/2016.
 */
public class DBUtils {
    /**
     * Transactional wrapper for consumer
     * @param connection connection to database
     * @param consumer consumer with db-logic
     */
    public static void transactional(Connection connection, Consumer<Connection> consumer) {
        try {
            connection.setAutoCommit(false);
            consumer.accept(connection);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new DatabaseTransactionException(ex);
            }
        }
    }
}
