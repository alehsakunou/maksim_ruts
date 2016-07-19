package by.epam.jmp.patterns.decarator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gambit on 7/19/2016.
 */
public class PersonInputStream {
    private InputStream stream;

    public PersonInputStream(InputStream stream) {
        this.stream = stream;
    }

    public Person readPerson() throws IOException {
        // todo: add inputStream contract???
        List<Byte> data = new ArrayList<Byte>();
        int result;
        while ((result = stream.read()) != -1) {
            data.add((byte)result);
        }
        byte[] bytes = new byte[data.size()];
        for (int i = 0; i < data.size(); i++) {
            bytes[i] = data.get(i);
        }
        // todo: improve creation of bean
        String[] params = new String(bytes).split(";");
        stream.close();
        return new Person(params[0], Integer.parseInt(params[1]));
    }
}
