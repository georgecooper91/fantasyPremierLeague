package com.fpl.comparators;

import com.fpl.models.Player;

import java.util.Comparator;

import static com.fpl.functionalMethods.FunctionalMethods.parseDouble;

public class ThreatComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        return parseDouble.apply(p2.getThreat()).compareTo(parseDouble.apply(p1.getThreat()));
    }
}
