package com.competition.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Teammember {
    @OneToMany
    private Long teamMemberId;

    @NotNull
    private String firstName;
    private String tussenvoegsel;

    @NotNull
    private String lastName;
    private String phoneNumber;

    public Teammember() {

    }

    public Teammember(String firstName, String tussenvoegsel, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.tussenvoegsel = tussenvoegsel;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
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

    @Override
    public String toString() {
        String name;

        if (tussenvoegsel == null) {
            name = this.firstName + " " + this.lastName;
        } else {
            name = this.firstName + " " + this.tussenvoegsel + " " + this.lastName;
        }

        return name;
    }
}
