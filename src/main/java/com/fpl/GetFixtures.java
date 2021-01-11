package com.fpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpl.functionalMethods.FunctionalMethods;
import com.fpl.models.Fixtures;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetFixtures implements Runnable {

    private final ObjectMapper mapper;
    private final JsonNode fplData;

    public GetFixtures(ObjectMapper mapper, JsonNode fplData) {
        this.mapper = mapper;
        this.fplData = fplData;
    }

    @Override
    public void run() {
        Request request = new Request();
        int nextGameweek = getNextGameweek(fplData);
        List<Integer> ngws = getNextGameweeks(nextGameweek);
        Main.fixtures = request.getNextFixtures(ngws).stream()
                .map(e -> extractFixtures(mapper, e))
                .flatMap(Collection::parallelStream)
                .collect(Collectors.toList());
    }

    private List<Fixtures> extractFixtures(ObjectMapper mapper, CompletableFuture<String> e) {
        List<Fixtures> a = null;
        try {
            a = Arrays.asList(mapper.readValue(e.join(), Fixtures[].class));
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
        return a;
    }

    private List<Integer> getNextGameweeks(int nextGameweek) {
        return IntStream.range(nextGameweek, nextGameweek + 5)
                .boxed()
                .collect(Collectors.toList());
    }

    private int getNextGameweek(JsonNode fplData) {
        int gwId = 0;

        List<LinkedHashMap<String, Object>> events = null;
        try {
            events = mapper.readValue(fplData.get("events").toString(), List.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Optional<LinkedHashMap<String, Object>> gwData = events.stream()
                .filter(FunctionalMethods.findUnfinishedGameweek)
                .findFirst();
        if(gwData.isPresent()){
            gwId = (int) gwData.get().get("id");
        } else {
            System.out.println("Could not get fixture information. Please try again");
        }
        return gwId;
    }
}
