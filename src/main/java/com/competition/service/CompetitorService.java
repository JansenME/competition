package com.competition.service;

import com.competition.model.Competitor;
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

    public Competitor postNewCompetitor(final String firstName, final String lastName, final String phoneNumber, final String email) {
        Competitor competitor = createNewCompetitor(firstName, lastName, phoneNumber, email);

        competitorRepository.insert(competitor);

        return competitor;
    }

    private Competitor createNewCompetitor(final String firstName, final String lastName, final String phoneNumber, final String email) {
        return new Competitor(firstName, lastName, phoneNumber, email);
    }
}
