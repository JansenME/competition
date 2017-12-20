package com.competition.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teams {
    private Long id;
    private String teamname;
    private String teammember1;
    private String teammember2;

    public Teams() {

    }

    public Teams(String teamname, String teammember1, String teammember2) {
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

    public String getTeammember1() {
        return teammember1;
    }

    public void setTeammember1(String teammember1) {
        this.teammember1 = teammember1;
    }

    public String getTeammember2() {
        return teammember2;
    }

    public void setTeammember2(String teammember2) {
        this.teammember2 = teammember2;
    }
}