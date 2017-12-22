package com.competition.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Matches {
    private Long matchId;

    @NotNull
    private List<Team> teams;

    private Long homeGoals;
    private Long awayGoals;

    public Matches() {
    }

    public Matches(List<Team> teams) {
        this.teams = teams;
    }

    public void setScore(final Long homeGoals, final Long awayGoals) {
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "match_team",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
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
