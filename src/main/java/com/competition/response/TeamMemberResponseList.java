package com.competition.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamMemberResponseList {
    private List<TeamMemberResponse> teamMemberResponses;

    public TeamMemberResponseList(List<TeamMemberResponse> teamMemberResponses) {
        this.teamMemberResponses = teamMemberResponses;
    }

    public List<TeamMemberResponse> getTeamMemberResponses() {
        return teamMemberResponses;
    }
}
