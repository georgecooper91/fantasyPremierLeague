package com.fpl.functionalMethods;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalMethods {

    public static Function<String, Double> parseDouble = Double::parseDouble;

    public static Consumer<CompletableFuture<String>> getResult = stringCompletableFuture -> {
        try {
            stringCompletableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    };

    public static Predicate<LinkedHashMap<String, Object>> findUnfinishedGameweek = jn -> !(boolean) jn.get("finished");

    public static Function<String, ZonedDateTime> createZdt = s ->
            ZonedDateTime.parse(s, DateTimeFormatter.ISO_ZONED_DATE_TIME);


}
