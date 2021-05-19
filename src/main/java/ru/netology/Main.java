package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Callable<Integer>> myCallables = new ArrayList<>() {{
            add(new MyCallable(1));
            add(new MyCallable(2));
            add(new MyCallable(3));
            add(new MyCallable(4));
        }};

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


        final List<Future<Integer>> tasks = threadPool.invokeAll(myCallables);
        for (Future<Integer> task : tasks) {
            System.out.println("Результат задачи: " + task.get());
        }


        final Integer taskAny = threadPool.invokeAny(myCallables);
        System.out.println("Результат задачи: " + taskAny);

        threadPool.shutdown();

    }
}
