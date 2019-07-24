package com.competition.model.entity;

import com.competition.model.Role;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Data
public class Competition {
    @Id
    private ObjectId id;

    private final String name;
    private final String description;

    private final Map<ObjectId, Role> competitors;

    public String getId() {
        return id.toString();
    }
}
