package com.competition.service;

import com.competition.model.Matches;
import com.competition.repository.MatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {
    private static final Logger LOG = LoggerFactory.getLogger(MatchService.class);

    @Autowired
    private MatchRepository matchRepository;

    public List<Matches> getMatches() {
        if (matchRepository != null && matchRepository.findAll() != null) {
            return matchRepository.findAll();
        } else {
            return new ArrayList<>();
        }
    }

    public Response handleException(Exception e) {
        LOG.error("There was an error in MatchController. Stacktrace:", e.fillInStackTrace());
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
