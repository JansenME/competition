package com.competition.service;

import com.competition.model.Role;
import com.competition.model.entity.Competition;
import com.competition.model.entity.JoinCompetitorCompetition;
import com.competition.repository.CompetitionRepository;
import com.competition.repository.JoinCompetitorCompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {
    private final CompetitionRepository competitionRepository;
    private final JoinCompetitorCompetitionRepository joinCompetitorCompetitionRepository;

    @Autowired
    public CompetitionService(final CompetitionRepository competitionRepository, final JoinCompetitorCompetitionRepository joinCompetitorCompetitionRepository) {
        this.competitionRepository = competitionRepository;
        this.joinCompetitorCompetitionRepository = joinCompetitorCompetitionRepository;
    }

    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    public Competition postNewCompetition(final Competition competition) {
        competitionRepository.insert(competition);

        return competition;
    }

    public JoinCompetitorCompetition addCompetitor(final JoinCompetitorCompetition joinCompetitorCompetition) {
        joinCompetitorCompetition.setRole(Role.USER);
        joinCompetitorCompetitionRepository.insert(joinCompetitorCompetition);

        return joinCompetitorCompetition;
    }

    public void deleteAllCompetitions() {
        competitionRepository.deleteAll();
    }
}
