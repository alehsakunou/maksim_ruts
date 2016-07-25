package by.epam.jmp.patterns.dao;

import by.epam.jmp.patterns.beans.Person;
import by.epam.jmp.patterns.factory.AbstractPersonDaoFactory;
import by.epam.jmp.patterns.factory.FilePersonDaoFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gambit on 7/25/2016.
 */
public class FilePersonDaoTest {
    @Test
    public void testDaoFlow() throws Exception {
        PersonDao dao = AbstractPersonDaoFactory.getFactory(FilePersonDaoFactory.class).getPersonDao();
        Person person = new Person("Jack", 10);
        dao.save(person);
        Person clone = dao.read(person.getName());
        assertEquals("Oops", person, clone);
    }
}