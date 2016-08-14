package by.epam.jmp.patterns.facade;

import by.epam.jmp.patterns.beans.Person;
import by.epam.jmp.patterns.dao.PersonDao;

/**
 * Created by Gambit on 8/15/2016.
 */
public class PersonFacadeImpl implements PersonFacade {
    private PersonDao dataBasePersonDao;
    private PersonDao fileSystemPersonDao;

    public PersonFacadeImpl(PersonDao dataBasePersonDao, PersonDao fileSystemPersonDao) {
        this.dataBasePersonDao = dataBasePersonDao;
        this.fileSystemPersonDao = fileSystemPersonDao;
    }

    public Person readFromDataBase(String name) {
        return dataBasePersonDao.read(name);
    }

    public Person readFromFileSystem(String name) {
        return fileSystemPersonDao.read(name);
    }

    public void storeToDataBase(Person person) {
        dataBasePersonDao.save(person);
    }

    public void storeToFileSystem(Person person) {
        fileSystemPersonDao.save(person);
    }
}
