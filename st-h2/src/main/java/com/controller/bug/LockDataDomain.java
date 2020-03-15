package com.controller.bug;

public class LockDataDomain {

    private static int counter = 0;
    private static Object locker = new Object();

    public static int reset() {
        counter = 0;
        return counter;
    }

    public synchronized void wrong() {
        counter++;
    }

    public void right() {
        synchronized (locker) {
            counter++;
        }
    }

    public static int getCounter() {
        return counter;
    }
}
