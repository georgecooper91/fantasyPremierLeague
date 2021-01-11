package com.fpl.enums;

import java.util.HashMap;
import java.util.Map;

public enum Teams {

    ARS(1),
    AVL(2),
    BHA(3),
    BUR(4),
    CHE(5),
    CRY(6),
    EVE(7),
    FUL(8),
    LEI(9),
    LEE(10),
    LIV(11),
    MCI(12),
    MUN(13),
    NEW(14),
    SHU(15),
    SOU(16),
    TOT(17),
    WBA(18),
    WHU(19),
    WOL(20);


    private final int value;
    private static Map<Integer, Enum> map = new HashMap<>();

    Teams(int value){
        this.value = value;
    }

    static {
        for(Teams team : Teams.values()){
            map.put(team.value, team);
        }
    }

    public static Teams valueOf(int team){
        return (Teams) map.get(team);
    }

    public int getValue() {
        return value;
    }
}
