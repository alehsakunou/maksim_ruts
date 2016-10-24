package com.epam.jmp.nosql;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Content generator for task implementation
 * Created by Gambit on 9/14/2016.
 */
public final class ContentGenerator {
    private static final List<String> NAMES;
    private static final List<String> SURNAMES;
    private static final Random RANDOM = new Random();
    private static final int MAX_AGE = 70;
    private static final int MIN_AGE = 10;

    static {
        List<String> tempSurnames;
        List<String> tempNames;
        try {
            tempNames = IOUtils.readLines(ContentGenerator.class.getClassLoader().getResourceAsStream("us names.txt"));
            tempSurnames = IOUtils.readLines(ContentGenerator.class.getClassLoader().getResourceAsStream("us surnames.txt"));
        } catch (IOException e) {
            tempNames = Collections.emptyList();
            tempSurnames = Collections.emptyList();
        }
        NAMES = tempNames;
        SURNAMES = tempSurnames;
    }

    private ContentGenerator() {
    }

    /**
     * Generate random name for user
     * @return random name
     */
    public static String getRandomName() {
        return NAMES.get(RANDOM.nextInt(NAMES.size()));
    }

    /**
     * Generate random surname for user
     * @return random surname
     */
    public static int getRandomAge() {
        return RANDOM.nextInt(MAX_AGE - MIN_AGE) + MIN_AGE;
    }

    public static String getRandomSurname() {
        return SURNAMES.get(RANDOM.nextInt(SURNAMES.size()));
    }

    /**
     * Generate random post for user
     * @return random post
     */
    public static String getRandomPost() {
        return "post of " + NAMES.get(RANDOM.nextInt(NAMES.size()));
    }

    /**
     * Generate random date
     * @return random date
     */
    public static Date getRandomDate() {
        int year = LocalDate.now().getYear() - RANDOM.nextInt(80);
        int month = RANDOM.nextInt(12) + 1;
        int day = RANDOM.nextInt(28) + 1;

        return Date.valueOf(LocalDate.of(year, month, day));
    }
}
