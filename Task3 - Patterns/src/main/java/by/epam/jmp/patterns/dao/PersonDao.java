package by.epam.jmp.patterns.dao;

import by.epam.jmp.patterns.beans.Person;

import java.util.List;

/**
 * Created by Gambit on 7/24/2016.
 */
public interface PersonDao {
    void save(Person person);
    List<Person> read();
    Person read(String name);
}
