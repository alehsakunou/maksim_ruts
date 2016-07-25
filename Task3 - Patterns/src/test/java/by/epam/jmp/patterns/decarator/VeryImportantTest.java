package by.epam.jmp.patterns.decarator;

import by.epam.jmp.patterns.beans.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gambit on 7/19/2016.
 */
public class VeryImportantTest {

    public static final String OUT_FILE = "out.txt";

    @Test
    public void testDifficultLogicOfStreams() throws Exception {
        Person donor = new Person("John", 10);

        FileOutputStream fos = new FileOutputStream(new File(OUT_FILE));
        PersonOutputStream pos = new PersonOutputStream(fos);
        pos.writePerson(donor);

        FileInputStream fis = new FileInputStream(new File(OUT_FILE));
        PersonInputStream pis = new PersonInputStream(fis);
        Person clone = pis.readPerson();

        assertEquals("Ooops, something went wrong!!", donor, clone);
    }
}
