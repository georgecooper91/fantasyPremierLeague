package com.fpl.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fpl.enums.Teams;

import java.time.LocalDateTime;

public class Fixtures {

    private final int id;
    private final int homeTeamCode;
    private final int awayTeamCode;
    private final int difficulty;
    private final boolean isHome;
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSZ")
    private final String kickoffTime;
    private Teams homeTeam;
    private Teams awayTeam;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Fixtures(@JsonProperty("id") int id,
                    @JsonProperty("team_h") int homeTeamCode,
                    @JsonProperty("team_a") int awayTeamCode,
                    @JsonProperty("difficulty") int difficulty,
                    @JsonProperty("is_home") boolean isHome,
                    @JsonProperty("kickoff_time") String kickoffTime) {
        this.id = id;
        this.homeTeamCode = homeTeamCode;
        this.awayTeamCode = awayTeamCode;
        this.difficulty = difficulty;
        this.isHome = isHome;
        this.kickoffTime = kickoffTime;
    }

    public int getId() {
        return id;
    }

    public int getHomeTeamCode() {
        return homeTeamCode;
    }

    public int getAwayTeamCode() {
        return awayTeamCode;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public boolean isHome() {
        return isHome;
    }

    public String getKickoffTime() {
        return kickoffTime;
    }

    public Teams getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam() {
        this.homeTeam = Teams.valueOf(homeTeamCode);
    }

    public Teams getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam() {
        this.awayTeam = Teams.valueOf(awayTeamCode);
    }

    @Override
    public String toString() {
        return homeTeam + " x " + awayTeam;
    }
}
