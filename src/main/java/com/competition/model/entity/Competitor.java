package com.competition.model.entity;

import com.competition.model.Role;
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
    private Role role;

    private final String password;
}
