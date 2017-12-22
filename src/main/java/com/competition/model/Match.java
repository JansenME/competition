package com.competition.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Match {
    private Long matchId;

    @NotNull
    private Team homeTeam;

    @NotNull
    private Team awayTeam;

    @NotNull
    private Long homeGoals;

    @NotNull
    private Long awayGoals;

    public Match() {
    }

    public Match(final Team homeTeam, final Team awayTeam, final Long homeGoals, final Long awayGoals) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getMatchId() {
        return matchId;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Long getHomeGoals() {
        return homeGoals;
    }

    public Long getAwayGoals() {
        return awayGoals;
    }
}
