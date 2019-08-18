package com.arthur.basic.j8f;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    public static void main(String[] args) {


        final List<String> list = Arrays.asList("Hello","World", "Hi", "CompletableFuture");
        final List<String> list2 = Arrays.asList("hello","world", "hi", "completablefuture");
        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
             System.out.println(list.get(0));
             return list.get(0);
        });

        list.stream().skip(1).forEach(e -> completableFuture.thenRun(() -> System.out.println(e)));


        final CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(list2.get(0));
            return list2.get(0);
        });

        list2.stream().skip(1).forEach(e -> completableFuture2.thenRun(() -> System.out.println(e)));

        CompletableFuture.allOf(completableFuture,completableFuture).join();


        System.out.println("Done");

    }
}
