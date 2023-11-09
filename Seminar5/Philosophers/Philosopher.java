package Seminar5.Philosophers;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    private final Semaphore table;

    Philosopher(Semaphore table) {
        this.table = table;
    }

    public void think() {
        System.out.printf(" %s думает.\n", Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void eat() {
        System.out.printf(" %s обедает.\n", Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            think();

            try {
                table.acquire();
                eat();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                table.release();
            }
        }
    }
}
