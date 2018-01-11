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

        Teammember lucBosch = new Teammember("Luc", null, "Bosch", null, null);
        teammembers.add(lucBosch);

        Teammember ahmetErsahin = new Teammember("Ahmet", null, "Ersahin", null, null);
        teammembers.add(ahmetErsahin);

        Teammember gaicoStoltenborgh = new Teammember("Gaico", null, "Stoltenborgh", null, null);
        teammembers.add(gaicoStoltenborgh);

        Teammember satishBihari = new Teammember("Satish", null, "Biharie", null, null);
        teammembers.add(satishBihari);

        Teammember bastiaanKarelse = new Teammember("Bastiaan", null, "Karelse", null, null);
        teammembers.add(bastiaanKarelse);

        Teammember wiebeHoekstra = new Teammember("Wiebe", null, "Hoekstra", null, null);
        teammembers.add(wiebeHoekstra);

        return teammembers;
    }

    private List<Team> createTeams() {
        List<Team> teams = new ArrayList<>();
        List<Teammember> teammembers = createTeamMembers();

        Team siebelGiants = new Team("Siebel Giants", teammembers.subList(0,1));
        mapWithTeamIds.put(siebelGiants.getTeamname(), 1L);
        teams.add(siebelGiants);

        Team muppets1 = new Team("Muppets 1", teammembers.subList(2,3));
        mapWithTeamIds.put(muppets1.getTeamname(), 2L);
        teams.add(muppets1);

        Team digitalMasters = new Team("Digital Masters", teammembers.subList(4,5));
        mapWithTeamIds.put(digitalMasters.getTeamname(), 3L);
        teams.add(digitalMasters);

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
