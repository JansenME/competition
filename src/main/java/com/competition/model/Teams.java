package com.competition.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teams {
    private Long id;
    private String teamname;
    private Teammember teammember1;
    private Teammember teammember2;
    private String password;

    public Teams() {

    }

    public Teams(String teamname, Teammember teammember1, Teammember teammember2) {
        this.teamname = teamname;
        this.teammember1 = teammember1;
        this.teammember2 = teammember2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public Teammember getTeammember1() {
        return teammember1;
    }

    public void setTeammember1(Teammember teammember1) {
        this.teammember1 = teammember1;
    }

    public Teammember getTeammember2() {
        return teammember2;
    }

    public void setTeammember2(Teammember teammember2) {
        this.teammember2 = teammember2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
