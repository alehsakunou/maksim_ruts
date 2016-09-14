package com.epam.jmp.jbdc;

import org.apache.commons.io.FileUtils;

import java.io.File;
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
public class ContentGenerator {
    private static final List<String> NAMES;
    private static final List<String> SURNAMES;
    private static final Random RANDOM = new Random();

    static {
        List<String> tempSurnames;
        List<String> tempNames;
        try {
            tempNames = FileUtils.readLines(new File("us names.txt"));
            tempSurnames = FileUtils.readLines(new File("us surnames.txt"));
        } catch (IOException e) {
            tempNames = Collections.emptyList();
            tempSurnames = Collections.emptyList();
        }
        NAMES = tempNames;
        SURNAMES = tempSurnames;
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
