package com.competition.repository;

import com.competition.model.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface MatchRepository extends JpaRepository <Matches, Long> {

    @Query(value = "SELECT team_id FROM match_team WHERE match_id = ?1", nativeQuery = true)
    List<BigInteger> findTeamsByMatchId(Long matchId);

}
