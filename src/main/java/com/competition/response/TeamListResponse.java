package com.competition.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamListResponse {
    private List<TeamResponse> teams;

    public TeamListResponse(List<TeamResponse> teams) {
        this.teams = teams;
    }

    public List<TeamResponse> getTeams() {
        return teams;
    }
}
