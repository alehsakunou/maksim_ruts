package by.epam.jmp.patterns.facade;

import by.epam.jmp.patterns.beans.Person;
import by.epam.jmp.patterns.dao.DBHelper;
import by.epam.jmp.patterns.factory.AbstractPersonDaoFactory;
import by.epam.jmp.patterns.factory.DatabasePersonDaoFactory;
import by.epam.jmp.patterns.factory.FilePersonDaoFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gambit on 8/15/2016.
 */
public class PersonFacadeImplTest {
    @Before
    public void setUp() throws Exception {
        DBHelper.createTables();
    }

    @Test
    public void testFacade() throws Exception {
        AbstractPersonDaoFactory dBfactory = AbstractPersonDaoFactory.getFactory(DatabasePersonDaoFactory.class);
        AbstractPersonDaoFactory filefactory = AbstractPersonDaoFactory.getFactory(FilePersonDaoFactory.class);

        PersonFacadeImpl personFacade = new PersonFacadeImpl(dBfactory.getPersonDao(), filefactory.getPersonDao());
        Person person = new Person("John", 20);

        personFacade.storeToDataBase(person);
        personFacade.storeToFileSystem(person);

        Person dBPerson = personFacade.readFromDataBase("John");
        Person filePerson = personFacade.readFromFileSystem("John");

        assertEquals(person, dBPerson);
        assertEquals(person, filePerson);
    }
}