package com.competition.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class Competitor {
    @Id
    private ObjectId id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Competitor(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id.toString();
    }
}
