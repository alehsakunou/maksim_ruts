package by.epam.jmp.patterns.factory;

import by.epam.jmp.patterns.dao.DBHelper;
import by.epam.jmp.patterns.dao.DatabasePersonDao;
import by.epam.jmp.patterns.dao.PersonDao;

/**
 * Created by Gambit on 7/24/2016.
 */
public class DatabasePersonDaoFactory extends AbstractPersonDaoFactory {
    public PersonDao getPersonDao() {
        return new DatabasePersonDao(DBHelper.getConnection());
    }
}
