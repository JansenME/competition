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
        fw.write("\n");
        writeScores();

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

    private void writeScores() throws IOException {
    }

    private List<Teammember> createTeamMembers() {
        List<Teammember> teammembers = new ArrayList<>();

        Teammember lucBosch = new Teammember("Luc", null, "Bosch", null, null);
        teammembers.add(lucBosch);

        Teammember ahmetErsahin = new Teammember("Ahmet", null, "Ersahin", null, null);
        teammembers.add(ahmetErsahin);

        Teammember gaicoStoltenborgh = new Teammember("Gaico", null, "Stoltenborgh", null, null);
        teammembers.add(gaicoStoltenborgh);

        Teammember satishBiharie = new Teammember("Satish", null, "Biharie", null, null);
        teammembers.add(satishBiharie);

        Teammember bastiaanKarelse = new Teammember("Bastiaan", null, "Karelse", null, null);
        teammembers.add(bastiaanKarelse);

        Teammember wiebeHoekstra = new Teammember("Wiebe", null, "Hoekstra", null, null);
        teammembers.add(wiebeHoekstra);

        Teammember ronaldMathies = new Teammember("Ronald", null, "Mathies", null, null);
        teammembers.add(ronaldMathies);

        Teammember ramonDeBeijer = new Teammember("Ramon", "de", "Beijer", null, null);
        teammembers.add(ramonDeBeijer);

        Teammember edwinCox = new Teammember("Edwin", null, "Cox", null, null);
        teammembers.add(edwinCox);

        Teammember kenanArslan = new Teammember("Kenan", null,"Arslan", null, null);
        teammembers.add(kenanArslan);

        Teammember robbertMackelenbergh = new Teammember("Robbert", null,"Mackelenbergh", null, null);
        teammembers.add(robbertMackelenbergh);

        Teammember zoranDjukic = new Teammember("Zoran", null,"Djukic", null, null);
        teammembers.add(zoranDjukic);

        Teammember basStoker = new Teammember("Bas", null,"Stoker", null, null);
        teammembers.add(basStoker);

        Teammember oussamaChougna = new Teammember("Oussama", null,"Chougna", null, null);
        teammembers.add(oussamaChougna);

        Teammember waiHo = new Teammember("Wai", null,"Ho", null, null);
        teammembers.add(waiHo);

        Teammember michaelWong = new Teammember("Michael", null,"Wong", null, null);
        teammembers.add(michaelWong);

        Teammember danielleAlmeida = new Teammember("Danielle", null,"Almeida", null, null);
        teammembers.add(danielleAlmeida);

        Teammember keesVanDenBerg = new Teammember("Kees", "van den","Berg", null, null);
        teammembers.add(keesVanDenBerg);

        Teammember geoffreyTas = new Teammember("Geoffrey", null,"Tas", null, null);
        teammembers.add(geoffreyTas);

        Teammember ciriloWortel = new Teammember("Cirilo", null,"Wortel", null, null);
        teammembers.add(ciriloWortel);

        Teammember arieVanDerLee = new Teammember("Arie", "van der","Lee", null, null);
        teammembers.add(arieVanDerLee);

        Teammember richardDeuzeman = new Teammember("Richard", null,"Deuzeman", null, null);
        teammembers.add(richardDeuzeman);

        Teammember arnoKoehler = new Teammember("Arno", null,"Koehler", null, null);
        teammembers.add(arnoKoehler);

        Teammember loekHeijmans = new Teammember("Loek", null,"Heijmans", null, null);
        teammembers.add(loekHeijmans);

        Teammember johannesTimmerman = new Teammember("Johannes", null,"Timmerman", null, null);
        teammembers.add(johannesTimmerman);

        Teammember adamSmiechura = new Teammember("Adam", null,"Smiechura", null, null);
        teammembers.add(adamSmiechura);

        Teammember timPrijn = new Teammember("Tim", null,"Prijn", null, null);
        teammembers.add(timPrijn);

        Teammember patrickVanLeuveren = new Teammember("Patrick", "van","Leuveren", null, null);
        teammembers.add(patrickVanLeuveren);

        Teammember ronaldBroeks = new Teammember("Ronald", null,"Broeks", null, null);
        teammembers.add(ronaldBroeks);

        Teammember jeroenKops = new Teammember("Jeroen", null,"Kops", null, null);
        teammembers.add(jeroenKops);

        Teammember davidBaak = new Teammember("David", null,"Baak", null, null);
        teammembers.add(davidBaak);

        Teammember remcoRunge = new Teammember("Remco", null,"Runge", null, null);
        teammembers.add(remcoRunge);

        Teammember martijnJansen = new Teammember("Martijn", null,"Jansen", null, null);
        teammembers.add(martijnJansen);

        Teammember danielPerezPerez = new Teammember("Daniel", null,"Perez Perez", null, null);
        teammembers.add(danielPerezPerez);

        Teammember aldoStein = new Teammember("Aldo", null,"Stein", null, null);
        teammembers.add(aldoStein);

        Teammember edwardVanDerWielen = new Teammember("Edward", "van der","Wielen", null, null);
        teammembers.add(edwardVanDerWielen);

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

        Team happyTreeFriends = new Team("Happy Tree Friends", teammembers.subList(6,7));
        mapWithTeamIds.put(happyTreeFriends.getTeamname(), 4L);
        teams.add(happyTreeFriends);

        Team muppets2 = new Team("Muppets 2", teammembers.subList(8,9));
        mapWithTeamIds.put(muppets2.getTeamname(), 5L);
        teams.add(muppets2);

        Team thunderbirds = new Team("Thunderbirds", teammembers.subList(10,11));
        mapWithTeamIds.put(thunderbirds.getTeamname(), 6L);
        teams.add(thunderbirds);

        Team teamBas = new Team("Team Bas", teammembers.subList(12,13));
        mapWithTeamIds.put(teamBas.getTeamname(), 7L);
        teams.add(teamBas);

        Team manchesterShitty = new Team("Manchester Shitty", teammembers.subList(14,15));
        mapWithTeamIds.put(manchesterShitty.getTeamname(), 8L);
        teams.add(manchesterShitty);

        Team hypolab = new Team("Hypolab", teammembers.subList(16,17));
        mapWithTeamIds.put(hypolab.getTeamname(), 9L);
        teams.add(hypolab);

        Team x_men = new Team("X-Men", teammembers.subList(18,19));
        mapWithTeamIds.put(x_men.getTeamname(), 10L);
        teams.add(x_men);

        Team theBigBangTheory = new Team("The Big Bang Theory", teammembers.subList(20,21));
        mapWithTeamIds.put(theBigBangTheory.getTeamname(), 11L);
        teams.add(theBigBangTheory);

        Team muppets3 = new Team("Muppets 3", teammembers.subList(22,23));
        mapWithTeamIds.put(muppets3.getTeamname(), 12L);
        teams.add(muppets3);

        Team teamJohannes = new Team("Team Johannes", teammembers.subList(24,25));
        mapWithTeamIds.put(teamJohannes.getTeamname(), 13L);
        teams.add(teamJohannes);

        Team reservoirDogs = new Team("Reservoir Dogs", teammembers.subList(26,27));
        mapWithTeamIds.put(reservoirDogs.getTeamname(), 14L);
        teams.add(reservoirDogs);

        Team muppets4 = new Team("Muppets 4", teammembers.subList(28,29));
        mapWithTeamIds.put(muppets4.getTeamname(), 15L);
        teams.add(muppets4);

        Team statlerAndWaldorf = new Team("Statler and Waldorf", teammembers.subList(30,31));
        mapWithTeamIds.put(statlerAndWaldorf.getTeamname(), 16L);
        teams.add(statlerAndWaldorf);

        Team teamInkpot = new Team("Team Inkpot", teammembers.subList(32,33));
        mapWithTeamIds.put(teamInkpot.getTeamname(), 17L);
        teams.add(teamInkpot);

        Team tvtDoorgedraaid = new Team("TVT Doorgedraaid", teammembers.subList(34,35));
        mapWithTeamIds.put(tvtDoorgedraaid.getTeamname(), 18L);
        teams.add(tvtDoorgedraaid);

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
