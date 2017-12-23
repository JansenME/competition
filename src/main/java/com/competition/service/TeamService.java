package com.competition.service;

import com.competition.model.Team;
import com.competition.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import java.util.List;

public class TeamService {
    private static final Logger LOG = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Response handleException(Exception e) {
        LOG.error("There was an error in TeamController. Errormessage: {}", e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
