package by.epam.jmp.patterns.dao;

import by.epam.jmp.patterns.beans.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gambit on 7/24/2016.
 */
public class DatabasePersonDao implements PersonDao {
    private static final String READ_PERSON = "select name, age from PERSONS where name = ?";
    private static final String READ_PERSONS = "select name, age from PERSONS";
    private static final String SAVE_PERSON = "INSERT INTO PERSONS (name, age) values (?, ?)";

    private final Connection connection;

    public DatabasePersonDao(Connection connection) {
        this.connection = connection;
    }

    public void save(Person person) {
        boolean autocommitValue = false;
        PreparedStatement pst = null;
        try {
            autocommitValue = connection.getAutoCommit();
            pst = connection.prepareStatement(SAVE_PERSON);
            pst.setString(1, person.getName());
            pst.setInt(2, person.getAge());
            pst.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                // LOGGER.error(e);
            }
        } finally {
            try {
                connection.setAutoCommit(autocommitValue);
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                // LOGGER.error(e);
            }
        }
    }

    public List<Person> read() {
        PreparedStatement pst;
        List<Person> persons = new ArrayList<Person>();
        try {
            pst = connection.prepareCall(READ_PERSONS);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");
                persons.add(new Person(name, age));
            }
            return persons;
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    public Person read(String name) {
        PreparedStatement pst;
        try {
            pst = connection.prepareCall(READ_PERSON);
            pst.setString(1, name);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                int age = resultSet.getInt("AGE");
                return new Person(name, age);
            }
            throw new PersistenceException("Sorry, Mario, but your princess in another castle");
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
