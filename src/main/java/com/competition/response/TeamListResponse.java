package com.competition.response;

import java.util.List;

public class TeamListResponse {
    private List<TeamResponse> teams;

    public TeamListResponse(List<TeamResponse> teams) {
        this.teams = teams;
    }

    public List<TeamResponse> getTeams() {
        return teams;
    }
}
