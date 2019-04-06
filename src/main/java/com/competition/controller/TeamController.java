package com.competition.controller;

import com.competition.mapper.TeamMapper;
import com.competition.model.Team;
import com.competition.response.TeamResponse;
import com.competition.response.TeamResponseList;
import com.competition.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    @GetMapping("/teams")
    public ResponseEntity getTeams() {
        try {
            List<Team> teams = teamService.getTeams();

            List<TeamResponse> teamResponses = teamMapper.createTeamResponseList(teams);

            TeamResponseList teamResponse = new TeamResponseList(teamResponses);

            return ResponseEntity.ok(teamResponse);
        } catch (Exception e) {
           return teamService.handleException(e);
        }
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity getTeam(@PathVariable Long teamId) {
        try {
            Team team = teamService.getOneTeam(teamId);

            TeamResponse teamResponse = teamMapper.createTeamResponseList(team);

            return ResponseEntity.ok(teamResponse);
        } catch (Exception e) {
            return teamService.handleException(e);
        }
    }
}
