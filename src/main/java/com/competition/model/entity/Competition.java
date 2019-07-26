package com.competition.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Competition {
    @Id
    private String id;

    private final String name;
    private final String description;
}
