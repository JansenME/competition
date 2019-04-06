package com.competition.controller;

import com.competition.mapper.MatchMapper;
import com.competition.model.Matches;
import com.competition.response.MatchResponse;
import com.competition.response.MatchResponseList;
import com.competition.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {
    private final MatchService matchService;
    private final MatchMapper matchMapper;

    @Autowired
    public MatchController(MatchService matchService, MatchMapper matchMapper) {
        this.matchService = matchService;
        this.matchMapper = matchMapper;
    }

    @GetMapping("/matches")
    public ResponseEntity getMatches() {
        try {
            List<Matches> matches = matchService.getMatches();

            List<MatchResponse> matchResponses = matchMapper.createMatchResponseList(matches);

            MatchResponseList matchResponse = new MatchResponseList(matchResponses);

            return ResponseEntity.ok(matchResponse);
        } catch (Exception e) {
            return matchService.handleException(e);
        }
    }

    @GetMapping("/match/{matchId}")
    public ResponseEntity getMatch(@PathVariable Long matchId) {
        try {
            Matches match = matchService.getOneMatch(matchId);

            MatchResponse matchResponse = matchMapper.createMatchResponseList(match);

            return ResponseEntity.ok(matchResponse);
        } catch (Exception e) {
            return matchService.handleException(e);
        }
    }

    @GetMapping("/matches/team/{teamId}")
    public ResponseEntity getMatchesFromTeam(@PathVariable Long teamId) {
        try {
            List<Matches> matchesFromTeam = matchService.getMatchesFromTeam(teamId);

            List<MatchResponse> matchResponses = matchMapper.createMatchResponseList(matchesFromTeam);

            MatchResponseList matchResponse = new MatchResponseList(matchResponses);

            return ResponseEntity.ok(matchResponse);
        } catch (Exception e) {
            return matchService.handleException(e);
        }
    }
}
