package com.competition.service;

import com.competition.model.entity.Competitor;
import com.competition.repository.CompetitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitorService {
    private final CompetitorRepository competitorRepository;

    @Autowired
    public CompetitorService(final CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    public List<Competitor> getAllCompetitors() {
        return competitorRepository.findAll();
    }

    public Competitor postNewCompetitor(final Competitor competitor) {
        competitorRepository.insert(competitor);

        return competitor;
    }

    public void deleteAllCompetitors() {
        competitorRepository.deleteAll();
    }
}
