package com.competition.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchResponseList {
    private List<MatchResponse> matches;

    public MatchResponseList(List<MatchResponse> matches) {
        this.matches = matches;
    }

    public List<MatchResponse> getMatches() {
        return matches;
    }
}
