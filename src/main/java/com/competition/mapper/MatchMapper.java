package com.competition.mapper;

import com.competition.model.Matches;
import com.competition.response.MatchResponse;

import java.util.ArrayList;
import java.util.List;

public class MatchMapper {
    public List<MatchResponse> createMatchResponseList(List<Matches> matches) {
        List<MatchResponse> matchResponses = new ArrayList<>();

        for (Matches match : matches) {
            MatchResponse matchResponse = new MatchResponse(match);
            matchResponses.add(matchResponse);
        }
        return matchResponses;
    }
}
