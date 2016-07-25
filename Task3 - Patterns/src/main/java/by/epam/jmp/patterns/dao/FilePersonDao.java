package by.epam.jmp.patterns.dao;

import by.epam.jmp.patterns.beans.Person;
import by.epam.jmp.patterns.decarator.PersonInputStream;
import by.epam.jmp.patterns.decarator.PersonOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gambit on 7/24/2016.
 */
public class FilePersonDao implements PersonDao {
    private PersonInputStream inputStream;
    private PersonOutputStream outputStream;

    public FilePersonDao(String filename) {
        // todo
        try {
            inputStream = new PersonInputStream(new FileInputStream(new File(filename)));
            outputStream = new PersonOutputStream(new FileOutputStream(new File(filename)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(Person person) {
        try {
            outputStream.writePerson(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> read() {
        try {
            return new ArrayList<Person>()
            {
                { add(inputStream.readPerson()); }
            };
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }

    public Person read(String name) {
        try {

            Person person = inputStream.readPerson();
            if (name.equals(person.getName())) {
                return person;
            }
            throw new PersistenceException("Sorry, Mario, but your princess in another castle");
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }
}
