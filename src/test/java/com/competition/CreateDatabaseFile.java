package com.competition;

import com.competition.model.Matches;
import com.competition.model.Team;
import com.competition.model.Teammember;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateDatabaseFile {
    private static final Logger LOG = LoggerFactory.getLogger(CreateDatabaseFile.class);
    private static final String EMPTY_STRING = "";

    private FileWriter fw;
    private Map<String, Long> mapWithTeamIds = new HashMap<>();

    @Test
    public void createFile() throws IOException {
        fw = new FileWriter("A:/competition-rabobank/src/main/resources/import.sql");

        writeTeamMembers();
        fw.write("\n");
        writeTeams();
        fw.write("\n");
        writeMatches();

        fw.close();
    }

    private void writeTeamMembers() throws IOException {
        List<Teammember> teammembers = createTeamMembers();

        for (Teammember teammember : teammembers) {
            String firstName = "'" + teammember.getFirstName() + "'";
            String tussenvoegsel = EMPTY_STRING.equals(teammember.getTussenvoegsel()) ? null : "'" + teammember.getTussenvoegsel() + "'";
            String lastName = "'" + teammember.getLastName() + "'";
            String phoneNumber = EMPTY_STRING.equals(teammember.getPhoneNumber()) ? null : "'" + teammember.getPhoneNumber() + "'";
            String email = EMPTY_STRING.equals(teammember.getEmail()) ? null : "'" + teammember.getEmail() + "'";

            String query = String.format("INSERT INTO `competition`.`teammember` (`first_name`, `tussenvoegsel`, `last_name`, `phone_number`, `email`) VALUES (%s, %s, %s, %s, %s);\n", firstName, tussenvoegsel, lastName, phoneNumber, email);

            fw.write(query);
            LOG.info("Added teammember ({}) to the sql query.", teammember.fullName());
        }
    }

    private void writeTeams() throws IOException {
        List<Team> teams = createTeams();

        int counterTeam = 1;
        int counterTeamMember = 1;

        for (Team team : teams) {
            String queryTeam = String.format("INSERT INTO `competition`.`team` (`teamname`) VALUES ('%s');\n", team.getTeamname());
            String queryTeamMember1 = String.format("INSERT INTO `competition`.`team_teammember` (`team_id`, `team_member_id`) VALUES (%s, %s);\n", counterTeam, counterTeamMember);
            String queryTeamMember2 = String.format("INSERT INTO `competition`.`team_teammember` (`team_id`, `team_member_id`) VALUES (%s, %s);\n", counterTeam, counterTeamMember+1);

            fw.write(queryTeam);
            fw.write(queryTeamMember1);
            fw.write(queryTeamMember2);
            LOG.info("Added team ({}) to the sql query.", team.getTeamname());

            counterTeam++;
            counterTeamMember = counterTeamMember + 2;
        }
    }

    private void writeMatches() throws IOException {
        List<Matches> matches = generateAllMatches();

        int counterMatch = 1;

        for (Matches match : matches) {
            String queryMatch = "INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);\n";
            Long team1Id = mapWithTeamIds.get(match.getTeams().get(0).getTeamname());
            Long team2Id = mapWithTeamIds.get(match.getTeams().get(1).getTeamname());

            String queryTeam1 = String.format("INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (%s, %s);\n", counterMatch, team1Id);
            String queryTeam2 = String.format("INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (%s, %s);\n", counterMatch, team2Id);

            fw.write(queryMatch);
            fw.write(queryTeam1);
            fw.write(queryTeam2);

            LOG.info("Added match between {} and {} to the sql query", match.getTeams().get(0).getTeamname(), match.getTeams().get(1).getTeamname());

            counterMatch++;
        }
    }

    private List<Teammember> createTeamMembers() {
        List<Teammember> teammembers = new ArrayList<>();

        Teammember teammember1 = new Teammember("Henk", null, "Verhoek", "0623164578", "henk.verhoek@henkie.nl");
        teammembers.add(teammember1);

        Teammember teammember2 = new Teammember("Klaas", "de", "Jong", "0656887419", null);
        teammembers.add(teammember2);

        Teammember teammember3 = new Teammember("Kees", "de", "Vries", null, null);
        teammembers.add(teammember3);

        Teammember teammember4 = new Teammember("Jaap", null, "Bakker", "0655896963", null);
        teammembers.add(teammember4);

        Teammember teammember5 = new Teammember("Jan", null, "Visser", null, "jantje@jantjevisser.nl");
        teammembers.add(teammember5);

        Teammember teammember6 = new Teammember("Gerrie", null, "Smit", null, null);
        teammembers.add(teammember6);

        Teammember teammember7 = new Teammember("Jasper", "van de", "Berg", null, "jasper@berg.nl");
        teammembers.add(teammember7);

        Teammember teammember8 = new Teammember("Arjan", null, "Mulder", "0644787529", null);
        teammembers.add(teammember8);

        Teammember teammember9 = new Teammember("Hendrik", "de", "Groot", null, null);
        teammembers.add(teammember9);

        Teammember teammember10 = new Teammember("Bas", null, "Bos", null, null);
        teammembers.add(teammember10);

        return teammembers;
    }

    private List<Team> createTeams() {
        List<Team> teams = new ArrayList<>();
        List<Teammember> teammembers = createTeamMembers();

        Team team1 = new Team("Team 1", teammembers.subList(0,1));
        mapWithTeamIds.put(team1.getTeamname(), 1L);
        teams.add(team1);

        Team team2 = new Team("Team 2", teammembers.subList(2,3));
        mapWithTeamIds.put(team2.getTeamname(), 2L);
        teams.add(team2);

        Team team3 = new Team("Team 3", teammembers.subList(4,5));
        mapWithTeamIds.put(team3.getTeamname(), 3L);
        teams.add(team3);

        Team team4 = new Team("Team 4", teammembers.subList(6,7));
        mapWithTeamIds.put(team4.getTeamname(), 4L);
        teams.add(team4);

        Team team5 = new Team("Team 5", teammembers.subList(8,9));
        mapWithTeamIds.put(team5.getTeamname(), 5L);
        teams.add(team5);

        return teams;
    }

    private List<Matches> generateAllMatches() {
        List<Matches> matches = new ArrayList<>();
        List<Team> teams = createTeams();

        for (Team homeTeam : teams) {
            for (Team awayTeam: teams) {
                if (homeTeam != awayTeam) {
                    List<Team> teamForMatch = new ArrayList<>();
                    teamForMatch.add(homeTeam);
                    teamForMatch.add(awayTeam);

                    Matches match = new Matches(teamForMatch);
                    matches.add(match);
                }
            }
        }

        return matches;
    }
}
