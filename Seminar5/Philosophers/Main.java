package Seminar5.Philosophers;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int philosophersNumber = 5;
        Semaphore table = new Semaphore(1);
        for (int i = 1; i < 6; i++) {
            new Thread(new Philosopher(table), "Филосов " + i).start();
        }
    }
}
