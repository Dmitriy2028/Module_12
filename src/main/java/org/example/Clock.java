package org.example;

public class Clock {
    private static long startTime;

    public static long getStartTime() {
        return startTime;
    }

    public static void setStartTime(long startTime) {
        Clock.startTime = startTime;
    }

    public static void displayElapsedTime() {
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Elapsed time: " + elapsedTime + " seconds");
    }

    public static void displayMessage() {
        System.out.println("5 seconds have passed");
    }
}
