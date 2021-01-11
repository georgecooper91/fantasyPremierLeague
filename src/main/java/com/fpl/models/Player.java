package com.fpl.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fpl.enums.Teams;

import java.util.List;

public class Player {

    private final int priceChange;
    private final int position;
    private final String firstName;
    private final String lastName;
    private final String form;
    private final String news;
    private final int id;
    private final int price;
    private final String pointsPerGame;
    private final int teamCode;
    private final int totalPoints;
    private final int minutes;
    private final int goals;
    private final int assists;
    private final int cleanSheets;
    private final int goalsConceded;
    private final int ownGoals;
    private final int penaltiesSaved;
    private final int penaltiesMissed;
    private final int yellowCards;
    private final int redCards;
    private final int saves;
    private final int bonus;
    private final int bps;
    private final String valueForm;
    private final String valueSeason;
    private final String influence;
    private final String creativity;
    private final String threat;
    private final String ictIndex;
    private final int influenceRank;
    private final int influenceRankType;
    private final int creativityRank;
    private final int creativityRankType;
    private final int threatRank;
    private final int threatRankType;
    private final int ictIndexRank;
    private final int ictIndexRankType;
    private final int cornersIndirectFkOrder;
    private final int directFkOrder;
    private final int penaltiesOrder;
    private Teams team;
    private List<Fixtures> fixtures;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Player(@JsonProperty("cost_change_start") int priceChange,
                  @JsonProperty("element_type") int position,
                  @JsonProperty("first_name") String firstName,
                  @JsonProperty("web_name") String lastName,
                  @JsonProperty("form") String form,
                  @JsonProperty("news") String news,
                  @JsonProperty("id") int id,
                  @JsonProperty("now_cost") int price,
                  @JsonProperty("points_per_game") String pointsPerGame,
                  @JsonProperty("team") int teamCode,
                  @JsonProperty("total_points") int totalPoints,
                  @JsonProperty("minutes") int minutes,
                  @JsonProperty("goals_scored") int goals,
                  @JsonProperty("assists") int assists,
                  @JsonProperty("clean_sheets") int cleanSheets,
                  @JsonProperty("goals_conceded") int goalsConceded,
                  @JsonProperty("own_goals") int ownGoals,
                  @JsonProperty("penalties_saved") int penaltiesSaved,
                  @JsonProperty("penalties_missed") int penaltiesMissed,
                  @JsonProperty("yellow_cards") int yellowCards,
                  @JsonProperty("red_cards") int redCards,
                  @JsonProperty("saves") int saves,
                  @JsonProperty("bonus") int bonus,
                  @JsonProperty("bps") int bps,
                  @JsonProperty("value_form") String valueForm,
                  @JsonProperty("value_season") String valueSeason,
                  @JsonProperty("influence") String influence,
                  @JsonProperty("creativity") String creativity,
                  @JsonProperty("threat") String threat,
                  @JsonProperty("ict_index") String ictIndex,
                  @JsonProperty("influence_rank") int influenceRank,
                  @JsonProperty("influence_rank_type") int influenceRankType,
                  @JsonProperty("creativity_rank") int creativityRank,
                  @JsonProperty("creativity_rank_type") int creativityRankType,
                  @JsonProperty("threat_rank") int threatRank,
                  @JsonProperty("threat_rank_type") int threatRankType,
                  @JsonProperty("ict_index_rank") int ictIndexRank,
                  @JsonProperty("ict_index_rank_type") int ictIndexRankType,
                  @JsonProperty("corners_and_indirect_freekicks_order") int cornersIndirectFkOrder,
                  @JsonProperty("direct_freekicks_order") int directFkOrder,
                  @JsonProperty("penalties_order") int penaltiesOrder) {
        this.priceChange = priceChange;
        this.position = position;
        this.firstName = firstName;
        this.lastName = lastName;
        this.form = form;
        this.news = news;
        this.id = id;
        this.price = price;
        this.pointsPerGame = pointsPerGame;
        this.teamCode = teamCode;
        this.totalPoints = totalPoints;
        this.minutes = minutes;
        this.goals = goals;
        this.assists = assists;
        this.cleanSheets = cleanSheets;
        this.goalsConceded = goalsConceded;
        this.ownGoals = ownGoals;
        this.penaltiesSaved = penaltiesSaved;
        this.penaltiesMissed = penaltiesMissed;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.saves = saves;
        this.bonus = bonus;
        this.bps = bps;
        this.valueForm = valueForm;
        this.valueSeason = valueSeason;
        this.influence = influence;
        this.creativity = creativity;
        this.threat = threat;
        this.ictIndex = ictIndex;
        this.influenceRank = influenceRank;
        this.influenceRankType = influenceRankType;
        this.creativityRank = creativityRank;
        this.creativityRankType = creativityRankType;
        this.threatRank = threatRank;
        this.threatRankType = threatRankType;
        this.ictIndexRank = ictIndexRank;
        this.ictIndexRankType = ictIndexRankType;
        this.cornersIndirectFkOrder = cornersIndirectFkOrder;
        this.directFkOrder = directFkOrder;
        this.penaltiesOrder = penaltiesOrder;
    }

    public int getPriceChange() {
        return priceChange;
    }

    public int getPosition() {
        return position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getForm() {
        return form;
    }

    public String getNews() {
        return news;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getPointsPerGame() {
        return pointsPerGame;
    }

    public int getTeamCode() {
        return teamCode;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getOwnGoals() {
        return ownGoals;
    }

    public int getPenaltiesSaved() {
        return penaltiesSaved;
    }

    public int getPenaltiesMissed() {
        return penaltiesMissed;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public int getSaves() {
        return saves;
    }

    public int getBonus() {
        return bonus;
    }

    public int getBps() {
        return bps;
    }

    public String getValueForm() {
        return valueForm;
    }

    public String getValueSeason() {
        return valueSeason;
    }

    public String getInfluence() {
        return influence;
    }

    public String getCreativity() {
        return creativity;
    }

    public String getThreat() {
        return threat;
    }

    public String getIctIndex() {
        return ictIndex;
    }

    public int getInfluenceRank() {
        return influenceRank;
    }

    public int getInfluenceRankType() {
        return influenceRankType;
    }

    public int getCreativityRank() {
        return creativityRank;
    }

    public int getCreativityRankType() {
        return creativityRankType;
    }

    public int getThreatRank() {
        return threatRank;
    }

    public int getThreatRankType() {
        return threatRankType;
    }

    public int getIctIndexRank() {
        return ictIndexRank;
    }

    public int getIctIndexRankType() {
        return ictIndexRankType;
    }

    public int getCornersIndirectFkOrder() {
        return cornersIndirectFkOrder;
    }

    public int getDirectFkOrder() {
        return directFkOrder;
    }

    public int getPenaltiesOrder() {
        return penaltiesOrder;
    }

    public Teams getTeam() {
        return team;
    }

    public void setTeam() {
        this.team = Teams.valueOf(teamCode);
    }

    public List<Fixtures> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixtures> fixtures) {
        this.fixtures = fixtures;
    }

    @Override
    public String toString() {
        return 	firstName + " " +
                lastName + ", " +
                team +
                ", id=" + id +
                ", price=" + price +
                ", pointsPerGame='" + pointsPerGame +
                ", totalPoints=" + totalPoints +
                ", valueSeason='" + valueSeason +
                ", influence='" + influence +
                ", influenceRankType=" + influenceRankType +
                ", creativity='" + creativity +
                ", creativityRankType=" + creativityRankType +
                ", threat='" + threat +
                ", threatRankType=" + threatRankType +
                ", ictIndex='" + ictIndex +
                ", influenceRank=" + influenceRank +
                ", ictIndexRankType=" + ictIndexRankType +
                ", form='" + form +
                ", minutes=" + minutes +
                ", goals=" + goals +
                ", assists=" + assists +
                ", cleanSheets=" + cleanSheets +
                ", goalsConceded=" + goalsConceded +
                ", ownGoals=" + ownGoals +
                ", penaltiesSaved=" + penaltiesSaved +
                ", penaltiesMissed=" + penaltiesMissed +
                ", yellowCards=" + yellowCards +
                ", redCards=" + redCards +
                ", saves=" + saves +
                ", bonus=" + bonus +
                ", valueForm='" + valueForm +
                ", cornersIndirectFkOrder=" + cornersIndirectFkOrder +
                ", directFkOrder=" + directFkOrder +
                ", penaltiesOrder=" + penaltiesOrder +
                ", valueForm='" + valueForm +
                ", position=" + position;
    }
}
