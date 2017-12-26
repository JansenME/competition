package com.competition.controller;

import com.competition.mapper.MatchMapper;
import com.competition.model.Matches;
import com.competition.response.MatchResponse;
import com.competition.response.MatchResponseList;
import com.competition.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
public class MatchController {
    @Autowired
    private MatchService matchService = new MatchService();
    private MatchMapper matchMapper = new MatchMapper();

    @RequestMapping(value = "/matches", method = RequestMethod.GET)
    public Response getMatches() {
        try {
            List<Matches> matches = matchService.getMatches();

            List<MatchResponse> matchResponses = matchMapper.createMatchResponseList(matches);

            MatchResponseList matchResponse = new MatchResponseList(matchResponses);

            return Response.ok(matchResponse).build();
        } catch (Exception e) {
            return matchService.handleException(e);
        }
    }
}
