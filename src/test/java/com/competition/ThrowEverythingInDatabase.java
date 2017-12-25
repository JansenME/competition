package com.competition;

import com.competition.model.Teammember;
import com.competition.service.TeamMemberService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThrowEverythingInDatabase {
    TeamMemberService teamMemberService = new TeamMemberService();

    @Test
    public void fillDatabase() {
        saveTeamMembers();
    }

    private void saveTeamMembers() {
        for (Teammember teammember : createTeamMembers()) {
            teamMemberService.saveTeamMember(teammember);
        }
    }

    private List<Teammember> createTeamMembers() {
        List<Teammember> teammembers = new ArrayList<>();

        Teammember teammember1 = new Teammember("Henk", null, "Verhoek", null, null);
        teammembers.add(teammember1);

        return teammembers;
    }
}
