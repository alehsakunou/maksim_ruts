package by.epam.jmp.patterns.decarator;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Gambit on 7/19/2016.
 */
public class PersonOutputStream {
    private OutputStream stream;

    public PersonOutputStream(OutputStream stream) {
        this.stream = stream;
    }

    public void writePerson(Person person) throws IOException {
        // todo: add outputStream contract???
        stream.write(person.toString().getBytes());
        stream.flush();
        stream.close();
    }
}
