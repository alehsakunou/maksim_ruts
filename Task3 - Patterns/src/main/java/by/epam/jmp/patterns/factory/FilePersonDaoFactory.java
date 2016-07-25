package by.epam.jmp.patterns.factory;

import by.epam.jmp.patterns.dao.FilePersonDao;
import by.epam.jmp.patterns.dao.PersistenceException;
import by.epam.jmp.patterns.dao.PersonDao;
import by.epam.jmp.patterns.decarator.PersonInputStream;
import by.epam.jmp.patterns.decarator.PersonOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Gambit on 7/24/2016.
 */
public class FilePersonDaoFactory extends AbstractPersonDaoFactory {

    public static final String FILENAME = "out.txt";

    public PersonDao getPersonDao() {
        try {
            PersonInputStream inputStream = new PersonInputStream(new FileInputStream(new File(FILENAME)));
            PersonOutputStream outputStream = new PersonOutputStream(new FileOutputStream(new File(FILENAME)));
            return new FilePersonDao(inputStream, outputStream);
        } catch (FileNotFoundException e) {
            throw new PersistenceException(e);
        }
    }
}
