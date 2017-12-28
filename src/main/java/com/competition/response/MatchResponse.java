package com.competition.response;

import com.competition.model.Matches;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchResponse {
    @NotNull
    private Long id;
    @NotNull
    private String homeTeam;
    @NotNull
    private String awayTeam;

    private Long homeGoals;
    private Long awayGoals;

    public MatchResponse(Matches match) {
        this.id = match.getId();
        this.homeTeam = match.getTeams().get(0).getTeamname();
        this.awayTeam = match.getTeams().get(1).getTeamname();
    }

    public void setGoals(Matches match, Long homeGoals, Long awayGoals) {
        match.setHomeGoals(homeGoals);
        match.setAwayGoals(awayGoals);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Long getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(Long homeGoals) {
        this.homeGoals = homeGoals;
    }

    public Long getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(Long awayGoals) {
        this.awayGoals = awayGoals;
    }
}
