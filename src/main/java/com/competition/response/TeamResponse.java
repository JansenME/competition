package com.competition.response;

import com.competition.model.Team;
import com.competition.model.Teammember;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamResponse {
    @NotNull
    private String teamname;
    @NotNull
    private List<TeamMemberResponse> teamMembers;

    public TeamResponse(Team team) {
        this.teamname = team.getTeamname();

        List<TeamMemberResponse> teamMemberResponses = new ArrayList<>();

        for (Teammember teammember : team.getTeamMembers()) {
            teamMemberResponses.add(new TeamMemberResponse(teammember));
        }

        this.teamMembers = teamMemberResponses;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public List<TeamMemberResponse> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMemberResponse> teamMembers) {
        this.teamMembers = teamMembers;
    }
}
