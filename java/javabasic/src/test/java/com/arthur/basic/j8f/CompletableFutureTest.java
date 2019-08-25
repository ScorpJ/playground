package com.arthur.basic.j8f;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTest {

    public static void main(String[] args) {

        Executor executor = Executors.newFixedThreadPool(3, (Runnable r) -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

        Stream<List<String>> stream =
            Stream.of(Arrays.asList("Hello","World", "Hi", "CompletableFuture"),
                    Arrays.asList("hello","world", "hi", "completablefuture"),
                    Arrays.asList("apple"));

        List<CompletableFuture<Integer>> cfList =
        stream.map(list ->
            CompletableFuture.supplyAsync(() -> {
                list.forEach(e -> printDelay(e));
                return list.size();
            },executor)
        ).collect(Collectors.toList());

        System.out.println("*****************************");
        cfList.stream().map(CompletableFuture::join).collect(Collectors.toList());

        System.out.println("Done");


    }


    private static void printDelay(String content){

        int delay = 500 + ThreadLocalRandom.current().nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(content);
    }
}
