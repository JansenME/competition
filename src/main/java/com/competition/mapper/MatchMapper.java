package com.competition.mapper;

import com.competition.model.Matches;
import com.competition.response.MatchResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MatchMapper {
    public List<MatchResponse> createMatchResponseList(List<Matches> matches) {
        List<MatchResponse> matchResponses = new ArrayList<>();

        for (Matches match : matches) {
            MatchResponse matchResponse = new MatchResponse(match);
            matchResponses.add(matchResponse);
        }
        return matchResponses;
    }

    public MatchResponse createMatchResponseList(Matches match) {
        return new MatchResponse(match);
    }
}
