package com.competition.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Teammember {
    private static final String EMPTY_STRING = "";

    private Long teamMemberId;

    @NotNull
    private String firstName;
    private String tussenvoegsel;

    @NotNull
    private String lastName;
    private String phoneNumber;
    private String email;

    public Teammember() {

    }

    public Teammember(final String firstName, final String tussenvoegsel, final String lastName, final String phoneNumber, final String email) {
        this.firstName = firstName;
        if (tussenvoegsel == null) {
            this.tussenvoegsel = EMPTY_STRING;
        } else {
            this.tussenvoegsel = tussenvoegsel;
        }
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String fullName() {
        if (EMPTY_STRING.equals(this.tussenvoegsel)) {
            return this.firstName + " " + this.lastName;
        } else {
            return this.firstName + " " + this.tussenvoegsel + " " + this.lastName;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(Long teamMemberId) {
        this.teamMemberId = teamMemberId;
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
