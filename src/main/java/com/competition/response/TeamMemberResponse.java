package com.competition.response;

import com.competition.model.Teammember;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamMemberResponse {
    @NotNull
    private String firstName;
    private String tussenvoegsel;

    @NotNull
    private String lastName;
    private String phoneNumber;
    private String email;

    public TeamMemberResponse(Teammember teammember) {
        this.firstName = teammember.getFirstName();
        this.tussenvoegsel = teammember.getTussenvoegsel();
        this.lastName = teammember.getLastName();
        this.phoneNumber = teammember.getPhoneNumber();
        this.email = teammember.getEmail();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
