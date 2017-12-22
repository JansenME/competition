package com.competition.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Match {
    private Long matchId;

    @NotNull
    @ManyToOne
    private Long homeTeam;

    @NotNull
    @ManyToOne
    private Long awayTeam;

    @NotNull
    private Long homeGoals;

    @NotNull
    private Long awayGoals;

    public Match() {
    }

    public Match(Long homeTeam, Long awayTeam, Long homeGoals, Long awayGoals) {
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

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Long homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Long getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Long awayTeam) {
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
