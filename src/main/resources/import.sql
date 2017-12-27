INSERT INTO `competition`.`teammember` (`first_name`, `tussenvoegsel`, `last_name`, `phone_number`, `email`) VALUES ('Henk', null, 'Verhoek', '0623164578', 'henk.verhoek@henkie.nl');
INSERT INTO `competition`.`teammember` (`first_name`, `tussenvoegsel`, `last_name`, `phone_number`, `email`) VALUES ('Klaas', 'de', 'Jong', '0656887419', null);
INSERT INTO `competition`.`teammember` (`first_name`, `tussenvoegsel`, `last_name`, `phone_number`, `email`) VALUES ('Kees', 'de', 'Vries', null, null);
INSERT INTO `competition`.`teammember` (`first_name`, `tussenvoegsel`, `last_name`, `phone_number`, `email`) VALUES ('Jaap', null, 'Bakker', '0655896963', null);
INSERT INTO `competition`.`teammember` (`first_name`, `tussenvoegsel`, `last_name`, `phone_number`, `email`) VALUES ('Jan', null, 'Visser', null, 'jantje@jantjevisser.nl');
INSERT INTO `competition`.`teammember` (`first_name`, `tussenvoegsel`, `last_name`, `phone_number`, `email`) VALUES ('Gerrie', null, 'Smit', null, null);
INSERT INTO `competition`.`teammember` (`first_name`, `tussenvoegsel`, `last_name`, `phone_number`, `email`) VALUES ('Jasper', 'van de', 'Berg', null, 'jasper@berg.nl');
INSERT INTO `competition`.`teammember` (`first_name`, `tussenvoegsel`, `last_name`, `phone_number`, `email`) VALUES ('Arjan', null, 'Mulder', '0644787529', null);
INSERT INTO `competition`.`teammember` (`first_name`, `tussenvoegsel`, `last_name`, `phone_number`, `email`) VALUES ('Hendrik', 'de', 'Groot', null, null);
INSERT INTO `competition`.`teammember` (`first_name`, `tussenvoegsel`, `last_name`, `phone_number`, `email`) VALUES ('Bas', null, 'Bos', null, null);

INSERT INTO `competition`.`team` (`teamname`) VALUES ('Team 1');
INSERT INTO `competition`.`team_teammember` (`team_id`, `team_member_id`) VALUES (1, 1);
INSERT INTO `competition`.`team_teammember` (`team_id`, `team_member_id`) VALUES (1, 2);
INSERT INTO `competition`.`team` (`teamname`) VALUES ('Team 2');
INSERT INTO `competition`.`team_teammember` (`team_id`, `team_member_id`) VALUES (2, 3);
INSERT INTO `competition`.`team_teammember` (`team_id`, `team_member_id`) VALUES (2, 4);
INSERT INTO `competition`.`team` (`teamname`) VALUES ('Team 3');
INSERT INTO `competition`.`team_teammember` (`team_id`, `team_member_id`) VALUES (3, 5);
INSERT INTO `competition`.`team_teammember` (`team_id`, `team_member_id`) VALUES (3, 6);
INSERT INTO `competition`.`team` (`teamname`) VALUES ('Team 4');
INSERT INTO `competition`.`team_teammember` (`team_id`, `team_member_id`) VALUES (4, 7);
INSERT INTO `competition`.`team_teammember` (`team_id`, `team_member_id`) VALUES (4, 8);
INSERT INTO `competition`.`team` (`teamname`) VALUES ('Team 5');
INSERT INTO `competition`.`team_teammember` (`team_id`, `team_member_id`) VALUES (5, 9);
INSERT INTO `competition`.`team_teammember` (`team_id`, `team_member_id`) VALUES (5, 10);

INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (1, 1);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (1, 2);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (2, 1);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (2, 3);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (3, 1);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (3, 4);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (4, 1);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (4, 5);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (5, 2);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (5, 1);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (6, 2);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (6, 3);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (7, 2);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (7, 4);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (8, 2);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (8, 5);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (9, 3);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (9, 1);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (10, 3);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (10, 2);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (11, 3);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (11, 4);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (12, 3);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (12, 5);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (13, 4);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (13, 1);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (14, 4);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (14, 2);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (15, 4);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (15, 3);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (16, 4);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (16, 5);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (17, 5);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (17, 1);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (18, 5);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (18, 2);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (19, 5);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (19, 3);
INSERT INTO `competition`.`matches` (`home_goals`, `away_goals`) VALUES (null, null);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (20, 5);
INSERT INTO `competition`.`match_team` (`match_id`, `team_id`) VALUES (20, 4);
