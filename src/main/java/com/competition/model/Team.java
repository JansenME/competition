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
    private Teammember teammember1;

    @NotNull
    @ManyToOne
    private Teammember teammember2;
    private String password;

    public Team() {

    }

    public Team(String teamname, Teammember teammember1, Teammember teammember2) {
        this.teamname = teamname;
        this.teammember1 = teammember1;
        this.teammember2 = teammember2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getTeamId() {
        return teamId;
    }

    public String getTeamname() {
        return teamname;
    }

    public Teammember getTeammember1() {
        return teammember1;
    }

    public Teammember getTeammember2() {
        return teammember2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
