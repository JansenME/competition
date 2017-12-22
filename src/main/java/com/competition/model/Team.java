package com.competition.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Team {
    @OneToMany
    private Long teamId;

    @NotNull
    private String teamname;

    @NotNull
    @ManyToOne
    private Long teammember1;

    @NotNull
    @ManyToOne
    private Long teammember2;
    private String password;

    public Team() {

    }

    public Team(String teamname, Long teammember1, Long teammember2) {
        this.teamname = teamname;
        this.teammember1 = teammember1;
        this.teammember2 = teammember2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public Long getTeammember1() {
        return teammember1;
    }

    public void setTeammember1(Long teammember1) {
        this.teammember1 = teammember1;
    }

    public Long getTeammember2() {
        return teammember2;
    }

    public void setTeammember2(Long teammember2) {
        this.teammember2 = teammember2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
