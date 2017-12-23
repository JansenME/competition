package com.competition.controller;

import com.competition.model.Team;
import com.competition.response.TeamListResponse;
import com.competition.service.TeamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private TeamService teamService = new TeamService();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Response getTeams() {
        try {
            List<Team> teams = teamService.getTeams();

            TeamListResponse teamResponse = new TeamListResponse(teams);

            return Response.ok(teamResponse).build();
        } catch (Exception e) {
           return teamService.handleException(e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Response addTeam() {
        return Response.status(200).entity("Henk").build();
    }
}
