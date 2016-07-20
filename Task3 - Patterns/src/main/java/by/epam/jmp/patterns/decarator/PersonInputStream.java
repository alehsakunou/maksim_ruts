package by.epam.jmp.patterns.decarator;

import org.apache.commons.lang.ArrayUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gambit on 7/19/2016.
 */
public class PersonInputStream extends InputStream {
    private InputStream stream;

    public PersonInputStream(InputStream stream) {
        this.stream = stream;
    }

    public Person readPerson() throws IOException {
        List<Byte> data = new ArrayList<Byte>();
        int result;

        while ((result = stream.read()) != -1) {
            data.add((byte)result);
        }
        stream.close();

        byte[] bytes = ArrayUtils.toPrimitive(data.toArray(new Byte[data.size()]));
        return Person.fromString(new String(bytes));
    }

    public int read() throws IOException {
        return stream.read();
    }
}
