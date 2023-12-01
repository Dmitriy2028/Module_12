package org.example;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        FizzBuzz fz = new FizzBuzz();
        System.out.println(fz.NumberPrinter(25));

        Clock cl = new Clock();
        cl.setStartTime(System.currentTimeMillis());
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        scheduler.scheduleAtFixedRate(Clock::displayElapsedTime, 0, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(Clock::displayMessage, 0, 5, TimeUnit.SECONDS);
    }
}
