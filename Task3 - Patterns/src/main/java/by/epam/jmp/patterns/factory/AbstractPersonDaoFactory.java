package by.epam.jmp.patterns.factory;

import by.epam.jmp.patterns.dao.PersonDao;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gambit on 7/24/2016.
 */
public abstract class AbstractPersonDaoFactory {
    private static Map<Class, AbstractPersonDaoFactory> FACTORIES;

    public abstract PersonDao getPersonDao();

    static {
        FACTORIES = new HashMap<Class, AbstractPersonDaoFactory>();
        FACTORIES.put(DatabasePersonDaoFactory.class, new DatabasePersonDaoFactory());
        FACTORIES.put(FilePersonDaoFactory.class, new FilePersonDaoFactory());
    }

    public static AbstractPersonDaoFactory getFactory(Class clazz) {
        AbstractPersonDaoFactory factory = FACTORIES.get(clazz);
        if (factory == null) {
            throw new IllegalArgumentException(clazz.getName());
        }
        return factory;
    }
}
