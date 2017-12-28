package com.competition.service;

import com.competition.model.Team;
import com.competition.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    private static final Logger LOG = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getTeams() {
        if (teamRepository != null && teamRepository.findAll() != null) {
            return teamRepository.findAll();
        } else {
            return new ArrayList<>();
        }
    }

    public Response handleException(Exception e) {
        LOG.error("There was an error in TeamController. Stacktrace:", e.fillInStackTrace());
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    public Team getOneTeam(Long teamId) {
        return teamRepository.findOne(teamId);
    }
}
