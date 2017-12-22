package com.competition.repository;

import com.competition.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository <Match, Long> {
}
