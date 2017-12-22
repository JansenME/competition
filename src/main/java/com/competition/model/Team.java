package com.competition.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Team {
    private Long teamId;

    @NotNull
    private String teamname;

    @NotNull
    private List<Teammember> teamMembers;

    private String password;

    public Team() {

    }

    public Team(final String teamname, final List<Teammember> teamMembers) {
        this.teamname = teamname;
        this.teamMembers = teamMembers;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "team_teammember",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "team_member_id")
    )
    public List<Teammember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Teammember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
