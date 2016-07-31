package by.epam.jmp.memory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Gambit on 7/31/2016.
 */
public class Application {
    public static void foo(LocalDate date) {
        LocalDateTime localDateTime = LocalDateTime.of(date, LocalTime.now());
        System.out.println(localDateTime);
    }

    public static int foo1(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.now()).getHour();
    }

    public static LocalDateTime foo2(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.now());
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            foo(LocalDate.now());
            System.out.println(foo1(LocalDate.now()));
            System.out.println(foo2(LocalDate.now()));
            Thread.sleep(100);
        }


    }
}
