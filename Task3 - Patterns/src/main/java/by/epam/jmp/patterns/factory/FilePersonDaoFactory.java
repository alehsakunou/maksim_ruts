package by.epam.jmp.patterns.factory;

import by.epam.jmp.patterns.dao.FilePersonDao;
import by.epam.jmp.patterns.dao.PersonDao;

/**
 * Created by Gambit on 7/24/2016.
 */
public class FilePersonDaoFactory extends AbstractPersonDaoFactory {
    public PersonDao getPersonDao() {
        return new FilePersonDao("out.txt");
    }
}
