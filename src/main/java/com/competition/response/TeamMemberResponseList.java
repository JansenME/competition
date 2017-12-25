package com.competition.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamMemberResponseList {
    private List<TeamMemberResponse> teamMembers;

    public TeamMemberResponseList(List<TeamMemberResponse> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public List<TeamMemberResponse> getTeamMembers() {
        return teamMembers;
    }
}
