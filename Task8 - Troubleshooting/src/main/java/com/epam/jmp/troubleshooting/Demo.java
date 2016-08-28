package com.epam.jmp.troubleshooting;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Gambit on 8/29/2016.
 */
public class Demo {

    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);
        Runnable runnable1 = new DeadlockThread(s1, s2);
        Runnable runnable2 = new DeadlockThread(s2, s1);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(runnable1);
        executorService.submit(runnable2);
    }
}
