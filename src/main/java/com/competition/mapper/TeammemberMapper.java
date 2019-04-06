package com.competition.mapper;

import com.competition.model.Teammember;
import com.competition.response.TeamMemberResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeammemberMapper {

    public List<TeamMemberResponse> createTeamMemberResponseList(List<Teammember> teamMembers) {
        List<TeamMemberResponse> teamMemberResponses = new ArrayList<>();

        for (Teammember teammember : teamMembers) {
            TeamMemberResponse teamMemberResponse = new TeamMemberResponse(teammember);
            teamMemberResponses.add(teamMemberResponse);
        }
        return teamMemberResponses;
    }

    public TeamMemberResponse createTeamMemberResponseList(Teammember teamMember) {
        return new TeamMemberResponse(teamMember);
    }
}
