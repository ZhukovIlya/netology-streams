package ru.netology;

public class Main {
    public static void main(String[] args) {

        ThreadGroup group = new ThreadGroup("group");


        MyThread thread1 = new MyThread(group, "Поток 1");
        MyThread thread2 = new MyThread(group, "Поток 2");
        MyThread thread3 = new MyThread(group, "Поток 3");
        MyThread thread4 = new MyThread(group, "Поток 4");


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException err) {

        }


        group.interrupt();

    }
}
