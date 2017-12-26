package com.competition;

import com.competition.model.Teammember;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateDatabaseFile {
    private static final Logger LOG = LoggerFactory.getLogger(CreateDatabaseFile.class);
    private static final String EMPTY_STRING = "";

    private FileWriter fw;

    @Test
    public void createFile() throws IOException {
        fw = new FileWriter("A:/competition-rabobank/src/main/resources/import.sql");

        writeTeamMembers();

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
}
