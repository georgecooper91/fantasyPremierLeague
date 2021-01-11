package com.fpl.comparators;

import com.fpl.models.Player;

import java.util.Comparator;

import static com.fpl.functionalMethods.FunctionalMethods.parseDouble;

public class ValueComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        var p1 = parseDouble.apply(o1.getValueSeason());
        var p2 = parseDouble.apply(o2.getValueSeason());
        return Double.compare(p2, p1);
    }
}
