package com.competition.repository;

import com.competition.model.Matches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository <Matches, Long> {
}
