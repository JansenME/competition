package com.competition.service;

import com.competition.model.Team;
import com.competition.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<?> handleException(Exception e) {
        LOG.error("There was an error in TeamController. Stacktrace:", e.fillInStackTrace());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    public Team getOneTeam(Long teamId) {
        return teamRepository.findOne(teamId);
    }
}
