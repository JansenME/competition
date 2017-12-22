package com.competition.repository;

import com.competition.model.Teammember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<Teammember, Long> {
}
