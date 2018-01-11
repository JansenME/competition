package com.competition.service;

import com.competition.model.Matches;
import com.competition.model.Team;
import com.competition.repository.MatchRepository;
import com.competition.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {
    private static final Logger LOG = LoggerFactory.getLogger(MatchService.class);

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    public List<Matches> getMatches() {
        if (matchRepository != null && matchRepository.findAll() != null) {
            List<Matches> matches = matchRepository.findAll();

            for (Matches match : matches) {
                List<BigInteger> teamIds = matchRepository.findTeamsByMatchId(match.getId());
                List<Team> teams = new ArrayList<>();

                for (BigInteger team : teamIds) {
                    teams.add(teamRepository.findOne(Long.parseLong(team.toString())));
                }

                match.setTeams(teams);
            }


            return matches;
        } else {
            return new ArrayList<>();
        }
    }

    public Matches getOneMatch(Long matchId) {
        List<BigInteger> teamIds = matchRepository.findTeamsByMatchId(matchId);
        List<Team> teams = new ArrayList<>();

        for (BigInteger teamId : teamIds) {
            teams.add(teamRepository.findOne(Long.parseLong(teamId.toString())));
        }

        Matches match = matchRepository.findOne(matchId);
        match.setTeams(teams);
        return match;
    }

    public List<Matches> getMatchesFromTeam(Long teamId) {
        List<Matches> allMatches = getMatches();
        List<Matches> matchesFromTeam = new ArrayList<>();

        for (Matches match : allMatches) {
            if (match.getTeams().get(0).getId().equals(teamId) || match.getTeams().get(1).getId().equals(teamId)) {
                matchesFromTeam.add(match);
            }
        }

        return matchesFromTeam;
    }

    public Response handleException(Exception e) {
        LOG.error("There was an error in MatchController. Stacktrace:", e.fillInStackTrace());
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
