package com.competition.controller;

import com.competition.mapper.TeamMapper;
import com.competition.model.Team;
import com.competition.response.TeamListResponse;
import com.competition.response.TeamResponse;
import com.competition.service.TeamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
public class TeamController {
    private TeamService teamService = new TeamService();
    private TeamMapper teamMapper = new TeamMapper();

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public Response getTeams() {
        try {
            List<Team> teams = teamService.getTeams();

            List<TeamResponse> teamResponses = teamMapper.createTeamResponseList(teams);

            TeamListResponse teamResponse = new TeamListResponse(teamResponses);

            return Response.ok(teamResponse).build();
        } catch (Exception e) {
           return teamService.handleException(e);
        }
    }
}
