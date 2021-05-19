package ru.netology;


import java.util.concurrent.Callable;

class MyCallable implements Callable<Integer> {
    private int number;
    public MyCallable(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        while (i < number) {
            Thread.sleep(2500);
            System.out.println(Thread.currentThread().getName() + " Всем привет");
            i++;
        }
        return i;
    }
}