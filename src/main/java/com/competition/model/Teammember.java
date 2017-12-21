package com.competition.model;

public class Teammember {
    private String firstName;
    private String tussenvoegsel;
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
}
