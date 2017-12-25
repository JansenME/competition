package com.competition.controller;

import com.competition.mapper.TeamMemberMapper;
import com.competition.model.Teammember;
import com.competition.response.TeamMemberResponse;
import com.competition.response.TeamMemberResponseList;
import com.competition.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
public class TeamMemberController {
    @Autowired
    private TeamMemberService teamMemberService;
    private TeamMemberMapper teamMemberMapper = new TeamMemberMapper();

    @RequestMapping(value = "/team_member", method = RequestMethod.GET)
    public Response getTeamMembers() {
        try {
            List<Teammember> teamMembers = teamMemberService.getAllTeamMembers();

            List<TeamMemberResponse> teamMemberResponses = teamMemberMapper.createTeamMemberResponseList(teamMembers);

            TeamMemberResponseList teamMemberResponseList = new TeamMemberResponseList(teamMemberResponses);

            return Response.ok(teamMemberResponseList).build();
        } catch (Exception e) {
            return teamMemberService.handleException(e);
        }
    }

    @RequestMapping(value = "/team_member/{teamMemberId}", method = RequestMethod.GET)
    public Response getTeamMembers(@PathVariable Long teamMemberId) {
        try {
            Teammember teammember = teamMemberService.getOneTeamMember(teamMemberId);

            TeamMemberResponse teamMemberResponse = teamMemberMapper.createTeamMemberResponseList(teammember);

            return Response.ok(teamMemberResponse).build();
        } catch (Exception e) {
            return teamMemberService.handleException(e);
        }
    }
}
