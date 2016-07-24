package by.epam.jmp.patterns.decarator;

import by.epam.jmp.patterns.beans.Person;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Gambit on 7/19/2016.
 */
public class PersonOutputStream extends OutputStream {
    private OutputStream stream;

    public PersonOutputStream(OutputStream stream) {
        this.stream = stream;
    }

    public void writePerson(Person person) throws IOException {
        stream.write(person.toString().getBytes());
        stream.flush();
        stream.close();
    }

    public void write(int b) throws IOException {
        stream.write(b);
    }
}
