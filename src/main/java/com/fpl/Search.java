package com.fpl;

import com.fpl.comparators.*;
import com.fpl.models.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Search {

    private final Player[] players;

    public Search(Player[] players) {
        this.players = players;
    }

    protected List<Player> handleSearch(int position, int minPrice, int maxPrice, int typeOfSearch){
        List<Player> results = new ArrayList<>();
        switch(typeOfSearch){
            case 1: results = valueSearch(position, minPrice, maxPrice);
            break;
            case 2: results = influenceSearch(position, minPrice, maxPrice);
            break;
            case 3: results = creativeSearch(position, minPrice, maxPrice);
            break;
            case 4: results = threatSearch(position, minPrice, maxPrice);
            break;
            case 5: results = formSearch(position, minPrice, maxPrice);
            break;
            default: System.out.print("Search parameters out of bounds. Please re-configure search");
        }
        return results;
    }

    private List<Player> valueSearch(int position, int minPrice, int maxPrice) {
        ValueComparator vc = new ValueComparator();
        List<Player> result = Arrays.stream(players)
                .filter(p -> p.getPosition() == position & p.getPrice() <= maxPrice & p.getPrice() >= minPrice
                    & p.getNews().length() < 1)
                .sorted(vc)
                .limit(20)
                .collect(Collectors.toList())
                ;
        setTeams(result);
        printResults(result);
        return result;
    }

    private List<Player> influenceSearch(int position, int minPrice, int maxPrice) {
        InfluenceComparator ic = new InfluenceComparator();
        List<Player> result = Arrays.stream(players)
                .filter(p -> p.getPosition() == position & p.getPrice() <= maxPrice & p.getPrice() >= minPrice
                        & p.getNews().length() < 1)
                .sorted(ic)
                .limit(20)
                .collect(Collectors.toList())
                ;
        setTeams(result);
        printResults(result);
        return result;
    }

    private List<Player> creativeSearch(int position, int minPrice, int maxPrice) {
        CreativeComparator cc = new CreativeComparator();
        List<Player> result = Arrays.stream(players)
                .filter(p -> p.getPosition() == position & p.getPrice() <= maxPrice & p.getPrice() >= minPrice
                        & p.getNews().length() < 1)
                .sorted(cc)
                .limit(20)
                .collect(Collectors.toList())
                ;
        setTeams(result);
        printResults(result);
        return result;
    }

    private List<Player> threatSearch(int position, int minPrice, int maxPrice) {
        ThreatComparator tc = new ThreatComparator();
        List<Player> result = Arrays.stream(players)
                .filter(p -> p.getPosition() == position & p.getPrice() <= maxPrice & p.getPrice() >= minPrice
                        & p.getNews().length() < 1)
                .sorted(tc)
                .limit(20)
                .collect(Collectors.toList())
                ;
        setTeams(result);
        printResults(result);
        return result;
    }

    private List<Player> formSearch(int position, int minPrice, int maxPrice) {
        FormComparator fc = new FormComparator();
        List<Player> result = Arrays.stream(players)
                .filter(p -> p.getPosition() == position & p.getPrice() <= maxPrice & p.getPrice() >= minPrice
                        & p.getNews().length() < 1)
                .sorted(fc)
                .limit(20)
                .collect(Collectors.toList())
                ;
        setTeams(result);
        printResults(result);
        return result;
    }

    private void setTeams(List<Player> result) {
        result.forEach(Player::setTeam);
    }

    private void printResults(List<Player> r){
        r.forEach(System.out::println);
    }
}
