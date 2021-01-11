package com.fpl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpl.comparators.DateTimeComparator;
import com.fpl.models.Fixtures;
import com.fpl.models.Player;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    protected static List<Fixtures> fixtures;

    public static void main(String[] args) throws IOException, InterruptedException {
        Request request = new Request();
        var result = request.sendRequest("bootstrap-static/");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode fplData = mapper.readTree(result);

        Player[] pa = mapper.readValue(fplData.get("elements").toString(), Player[].class);
        Scanner scanner = new Scanner(System.in);
        HandleInputs hi = new HandleInputs(scanner);
        Search search = new Search(pa);
        System.out.print("To quit program at any time press Q\n" +
                "Enter 'ok' to continue.\n");

        while(!scanner.next().equals("Q")){
            int position = hi.handlePositionInput();
            int minPrice = hi.handleMinPrice();
            int maxPrice = hi.handleMaxPriceInput();
            int typeOfSearch = hi.handleSearchInput();
            scanner.nextLine();
            List<Player> results = search.handleSearch(position, minPrice, maxPrice, typeOfSearch);
            if(results.size() > 0){
                String fixt = hi.handleFixturesInput();
                if(fixt.charAt(0) == 'y'){
                    if(fixtures == null || fixtures.size() < 5) {
                        getFixes(mapper, fplData);
                    }
                    System.out.println("Enter id of player followed by ,");
                    String[] ids = scanner.nextLine().trim().replace(" ", "").split(",");
                    Set<Integer> idsInt = Arrays.stream(ids)
                            .map(Integer::parseInt)
                            //.peek(e -> System.out.println("id selected to see fixtures " + e))
                            .collect(Collectors.toSet())
                            ;
                    results = results.stream().filter(e -> idsInt.contains(e.getId()))
                            //.peek(e -> System.out.println("Looking for player fixtures " + e.getLastName()))
                            .collect(Collectors.toList());
                    //results.forEach(System.out::println);

                    results.forEach(p -> { ///System.out.println("Player about to find fixtures " + p.getLastName());
                        setPFix.accept(p);});

                }
            } else {
                System.out.println("Your search bore no results, please try again.");
            }
            System.out.println("");
            System.out.println("Would you like to search again?");
            System.out.println("y=yes, Q=quit");
        }
    }

    static Consumer<Player> setPFix = p -> {
        DateTimeComparator dtc = new DateTimeComparator();
        List<Fixtures> ff = fixtures.stream()
                .filter(f -> f.getHomeTeamCode() == p.getTeamCode() || f.getAwayTeamCode() == p.getTeamCode())
                .sorted(dtc)
                //.peek(e -> System.out.println("Finding fixtures for player " + p))
                .collect(Collectors.toList())
                ;
        System.out.println(p);
        System.out.print("Fixtures = ");
        ff.forEach(f -> {f.setHomeTeam(); f.setAwayTeam(); System.out.print(f + ", ");});
        System.out.println("");
        //p.setFixtures(ff);
    };

    private static void getFixes(ObjectMapper mapper, JsonNode fplData) {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        ex.submit(new GetFixtures(mapper, fplData));
        ex.shutdown();
    }

}
