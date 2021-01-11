package com.fpl;

import com.fpl.functionalMethods.FunctionalMethods;
import com.fpl.models.Fixtures;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Request {

    private final String URL = "https://fantasy.premierleague.com/api/";

    protected String sendRequest(String path) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();


        var request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(URL + path))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

    public List<CompletableFuture<String>> getNextFixtures(List<Integer> ngws) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        HttpClient client = HttpClient.newBuilder()
                .executor(executorService)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        List<URI> paths = ngws.stream()
                .map(e -> URL + "fixtures/?event=" + e)
                .map(URI::create)
                .collect(Collectors.toList());

        List<CompletableFuture<String>> result = paths.stream()
                .map(url -> client.sendAsync(
                        HttpRequest.newBuilder(url)
                            .build(),
                        HttpResponse.BodyHandlers.ofString())
                            .thenApply(HttpResponse::body))
                .collect(Collectors.toList())
                ;
        result.forEach(e -> FunctionalMethods.getResult.accept(e));
        executorService.shutdown();
        return result;
    }





//    public List<Fixtures> getFixtures() {
//    }
}
