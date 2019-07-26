package com.competition.service;

import com.competition.model.entity.Competition;
import com.competition.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {
    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(final CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    public Competition postNewCompetition(final Competition competition) {
        competitionRepository.insert(competition);

        return competition;
    }

    public void deleteAllCompetitions() {
        competitionRepository.deleteAll();
    }
}
