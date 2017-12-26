package com.competition.response;

import com.competition.model.Teammember;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamMemberResponse {
    @NotNull
    private String name;

    private String phoneNumber;
    private String email;

    public TeamMemberResponse(Teammember teammember) {
        String name = teammember.fullName();
        this.name = name;
        this.phoneNumber = teammember.getPhoneNumber();
        this.email = teammember.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
