package com.competition.repository;

import com.competition.model.Teammember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends JpaRepository<Teammember, Long> {
}
