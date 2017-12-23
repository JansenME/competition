package com.competition.mapper;

import com.competition.model.Team;
import com.competition.response.TeamResponse;

import java.util.ArrayList;
import java.util.List;

public class TeamMapper {
    public List<TeamResponse> createTeamResponseList(List<Team> teams) {
        List<TeamResponse> teamResponses = new ArrayList<>();

        for (Team team : teams) {
            TeamResponse teamResponse = new TeamResponse(team);
            teamResponses.add(teamResponse);
        }
        return teamResponses;
    }
}
