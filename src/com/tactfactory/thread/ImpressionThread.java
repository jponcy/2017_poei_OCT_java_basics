package com.tactfactory.thread;

public class ImpressionThread extends Thread {
    private String word;

    public ImpressionThread(String word) {
        this.word = word;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; ++ i) {
            this.imprime();
        }
    }

    private void imprime() {
        synchronized (System.out) {
            for (int i = 0; i < this.word.length(); ++ i) {
                System.out.print(this.word.charAt(i));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ImpressionThread i1 = new ImpressionThread("Bonjour mon gars comment ça va bien ?");
        ImpressionThread iHan = new ImpressionThread("ça va mais j'aime pas ta tête, du coup aurevoir !");

        i1.start();
        iHan.start();
    }
}
