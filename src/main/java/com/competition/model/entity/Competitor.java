package com.competition.model.entity;

import com.competition.model.Role;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Data
public class Competitor {
    @Id
    private ObjectId id;

    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String email;

    private Map<ObjectId, Role> roleInCompetitions;

    public String getId() {
        return id.toString();
    }

    public void addToRoleInCompetitions(final ObjectId competitionId, final Role role) {
        roleInCompetitions.put(competitionId, role);
    }
}
