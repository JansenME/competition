package com.competition.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Competitor {
    @Id
    private String id;

    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String email;

    private final String password;
}
