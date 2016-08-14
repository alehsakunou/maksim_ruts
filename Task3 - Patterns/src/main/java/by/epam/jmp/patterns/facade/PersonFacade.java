package by.epam.jmp.patterns.facade;

import by.epam.jmp.patterns.beans.Person;

/**
 * Created by Gambit on 8/15/2016.
 */
public interface PersonFacade {
    Person readFromDataBase(String name);
    Person readFromFileSystem(String name);
    void storeToDataBase(Person person);
    void storeToFileSystem(Person person);
}
