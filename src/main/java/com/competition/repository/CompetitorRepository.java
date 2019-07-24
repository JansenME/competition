package com.competition.repository;

import com.competition.model.entity.Competitor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitorRepository extends MongoRepository<Competitor, ObjectId> {

}
