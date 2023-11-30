package org.example;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;
public class TimeDisplayProgram {
    private static long startTime;

    public static void setStartTime

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        scheduler.scheduleAtFixedRate(TimeDisplayProgram::displayElapsedTime, 0, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(TimeDisplayProgram::displayMessage, 0, 5, TimeUnit.SECONDS);
    }

    private static void displayElapsedTime() {
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Elapsed time: " + elapsedTime + " seconds");
    }

    private static void displayMessage() {
        System.out.println("Минуло 5 секунд");
    }
}
