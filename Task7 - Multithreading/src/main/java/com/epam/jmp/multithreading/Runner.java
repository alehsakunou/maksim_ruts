package com.epam.jmp.multithreading;

import java.io.*;

/**
 * Created by Gambit on 8/20/2016.
 */
public class Runner {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Repository repository = new ConcurrencyRepository("D:\\123");
        File file = new File("d:\\2013-12-17 10.54.16.jpg");
        String name = "2013-12-17 10.54.16.jpg";

        repository.saveAsync(name, new FileInputStream(file));
        Thread.sleep(5000);
        repository.files().forEach(System.out::println);
        FileOutputStream fos = new FileOutputStream(new File("D:\\234\\" + name));
        repository.loadAsync("2013-12-17 10.54.16.jpg", fos);
        Thread.sleep(5000);
        repository.close();
        System.out.println("Complete!");
    }
}
