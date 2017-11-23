package com.tactfactory.thread;

public class CounterThread extends Thread {
    private int lastNumber;
    private int sleepTime;

    public CounterThread(int finalCounter, int sleepTime) {
        this.lastNumber = finalCounter;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        for (int i = 1; i <= this.lastNumber; ++ i) {
            String name = Thread.currentThread().getName();
            System.out.println(name + ": " + i);

            try {
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.err.println("J'avais jamais vu ça !!!!!");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread t1 = new CounterThread(100, 100);
        Thread t2 = new CounterThread(50, 200);

        t1.setName("Le premier :D");
        t2.setName("Le deuxième :-(");

        t1.start();
        System.out.println("On lance le deuxième");
        t2.start();
        System.out.println("Lancement fini");
    }
}
