package com.fpl.comparators;

import com.fpl.models.Fixtures;
import java.util.Comparator;

import static com.fpl.functionalMethods.FunctionalMethods.createZdt;

public class DateTimeComparator implements Comparator<Fixtures> {


    @Override
    public int compare(Fixtures f1, Fixtures f2) {
        return createZdt.apply(f1.getKickoffTime()).compareTo(createZdt.apply(f2.getKickoffTime()));
    }
}
