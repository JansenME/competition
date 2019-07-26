package com.competition.model.entity;

import com.competition.model.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class JoinCompetitorCompetition {
    @Id
    private String id;

    private final String competitorId;
    private final String competitionId;
    private final Role role;
}
