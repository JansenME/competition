package com.competition.repository;

import com.competition.model.entity.JoinCompetitorCompetition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinCompetitorCompetitionRepository extends MongoRepository<JoinCompetitorCompetition, String> {

}
