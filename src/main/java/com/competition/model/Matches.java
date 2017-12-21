package com.competition.model;

import javax.persistence.Entity;

@Entity
public class Matches {
    private Long id;
    private Long homeTeam;
    private Long awayTeam;
    private Long homeGoals;
    private Long awayGoals;

    public Matches() {
    }

    public Matches(Long homeTeam, Long awayTeam, Long homeGoals, Long awayGoals) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
