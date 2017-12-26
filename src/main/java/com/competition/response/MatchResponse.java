package com.competition.response;

import com.competition.model.Matches;
import com.competition.model.Team;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchResponse {
    @NotNull
    private List<TeamResponse> teams;

    private Long homeGoals;
    private Long awayGoals;

    public MatchResponse(Matches match) {
        List<TeamResponse> teamResponses = new ArrayList<>();

        for (Team team : match.getTeams()) {
            teamResponses.add(new TeamResponse(team));
        }

        this.teams = teamResponses;
    }

    public void setGoals(Matches match, Long homeGoals, Long awayGoals) {
        match.setHomeGoals(homeGoals);
        match.setAwayGoals(awayGoals);
    }

    public List<TeamResponse> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamResponse> teams) {
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
