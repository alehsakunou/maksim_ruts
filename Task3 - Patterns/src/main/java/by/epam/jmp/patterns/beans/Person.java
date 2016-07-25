package by.epam.jmp.patterns.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by Gambit on 7/19/2016.
 */
public class Person {
    private static final String SEPARATOR = ";";
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Person fromString(String string) {
        String[] params = string.split(SEPARATOR);
        return new Person(params[0], Integer.parseInt(params[1]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Person other = (Person) o;
        return new EqualsBuilder()
                .append(age, other.age)
                .append(name, other.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(age)
                .hashCode();
    }

    @Override
    public String toString() {
        return name + SEPARATOR + age;
    }
}
