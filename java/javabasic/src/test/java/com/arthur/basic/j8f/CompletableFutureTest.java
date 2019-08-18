package com.arthur.basic.j8f;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    public static void main(String[] args) {


        final List<String> list = Arrays.asList("Hello","World", "Hi", "CompletableFuture");
        final List<String> list2 = Arrays.asList("hello","world", "hi", "completablefuture");
        final CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
             System.out.println("Process for list 1");
             return null;
        });

        list.stream().forEach(e -> completableFuture.thenRun(() -> System.out.println(e)));


        final CompletableFuture<Void> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Process for list 2");
            return null;
        });

        list2.stream().forEach(e -> completableFuture2.thenRun(() -> System.out.println(e)));

        CompletableFuture.allOf(completableFuture,completableFuture).join();


        System.out.println("Done");

//        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
//            System.out.println(list.get(0));
//            return null;
//        });

    }
}
