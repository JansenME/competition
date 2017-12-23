package com.competition.response;

import com.competition.model.Team;
import com.competition.model.Teammember;

import javax.validation.constraints.NotNull;
import java.util.List;

public class TeamResponse {
    @NotNull
    private String teamname;
    @NotNull
    private List<Teammember> teamMembers;

    TeamResponse(Team team) {
        this.teamname = team.getTeamname();
        this.teamMembers = team.getTeamMembers();
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public List<Teammember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Teammember> teamMembers) {
        this.teamMembers = teamMembers;
    }
}
