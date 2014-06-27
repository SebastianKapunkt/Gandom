insert into Genre(id, name) values (1, 'Action');
insert into Genre(id, name) values (2, 'Adventure');
insert into Genre(id, name) values (3, 'Singelplayer');
insert into Genre(id, name) values (4, '3rd-Person');
insert into Genre(id, name) values (5, 'Puzzle');
insert into Genre(id, name) values (6, 'First-Person');
insert into Genre(id, name) values (7, 'Coop');
insert into Genre(id, name) values (8, 'Rennspiel');
insert into Genre(id, name) values (9, 'Sport');
insert into Genre(id, name) values (10, 'RPG');
insert into Genre(id, name) values (11, 'Shooter');
insert into Genre(id, name) values (12, 'Open-World');
insert into Genre(id, name) values (13, 'Fantasy');
insert into Genre(id, name) values (14, 'Turn-based');
insert into Genre(id, name) values (15, 'Indie');
insert into Genre(id, name) values (16, 'Point&Click');
insert into Genre(id, name) values (17, 'Multiplayer');
insert into Genre(id, name) values (18, '2D');
insert into Genre(id, name) values (19, 'MMO');
insert into Genre(id, name) values (20, 'Strategy');

insert into Publisher(id, name) values (1, 'Capcom');
insert into Publisher(id, name) values (2, 'Valve');
insert into Publisher(id, name) values (3, 'Ubisoft');
insert into Publisher(id, name) values (4, '2K Games');
insert into Publisher(id, name) values (5, 'SQUARE ENIX, Eidos Interactive');
insert into Publisher(id, name) values (6, 'Daedalic Entertainment');
insert into Publisher(id, name) values (7, 'Deep Silver');
insert into Publisher(id, name) values (8, 'Rockstar Games');
insert into Publisher(id, name) values (10, 'Chucklefish');
insert into Publisher(id, name) values (11, 'Electronic Arts');
insert into Publisher(id, name) values (12, 'TimeGate Studios');
insert into Publisher(id, name) values (13, 'Blizzard Entertainment');
insert into Publisher(id, name) values (14, 'Nordic Games');

insert into Game(id, name, publisher_id) values (1, 'DMC Devil May Cry', 1);
insert into game_genre(game_id, genre_id) values (1, 1);
insert into game_genre(game_id, genre_id) values (1, 2);
insert into game_genre(game_id, genre_id) values (1, 3);
insert into game_genre(game_id, genre_id) values (1, 4);

insert into Game(id, name, publisher_id) values (2, 'Portal', 2);
insert into game_genre(game_id, genre_id) values (2, 1);
insert into game_genre(game_id, genre_id) values (2, 2);
insert into game_genre(game_id, genre_id) values (2, 3);
insert into game_genre(game_id, genre_id) values (2, 5);
insert into game_genre(game_id, genre_id) values (2, 6);

insert into Game(id, name, publisher_id) values (3, 'Portal 2', 2);
insert into game_genre(game_id, genre_id) values (3, 1);
insert into game_genre(game_id, genre_id) values (3, 2);
insert into game_genre(game_id, genre_id) values (3, 3);
insert into game_genre(game_id, genre_id) values (3, 5);
insert into game_genre(game_id, genre_id) values (3, 6);
insert into game_genre(game_id, genre_id) values (3, 7);

insert into Game(id, name, publisher_id) values (4, 'TrackMania2 Stadium', 3);
insert into game_genre(game_id, genre_id) values (4, 8);
insert into game_genre(game_id, genre_id) values (4, 9);
insert into game_genre(game_id, genre_id) values (4, 17);

insert into Game(id, name, publisher_id) values (5, 'Borderlands 2', 4);
insert into game_genre(game_id, genre_id) values (5, 1);
insert into game_genre(game_id, genre_id) values (5, 7);
insert into game_genre(game_id, genre_id) values (5, 10);
insert into game_genre(game_id, genre_id) values (5, 11);

insert into Game(id, name, publisher_id) values (6, 'Final Fantasy VII', 5);
insert into game_genre(game_id, genre_id) values (6, 3);
insert into game_genre(game_id, genre_id) values (6, 10);
insert into game_genre(game_id, genre_id) values (6, 13);
insert into game_genre(game_id, genre_id) values (6, 14);

insert into Game(id, name, publisher_id) values (7, 'Bioshock Infinite', 4);
insert into game_genre(game_id, genre_id) values (7, 1);
insert into game_genre(game_id, genre_id) values (7, 3);
insert into game_genre(game_id, genre_id) values (7, 11);

insert into Game(id, name, publisher_id) values (8, 'Deponia', 6);
insert into game_genre(game_id, genre_id) values (8, 2);
insert into game_genre(game_id, genre_id) values (8, 3);
insert into game_genre(game_id, genre_id) values (8, 5);
insert into game_genre(game_id, genre_id) values (8, 15);
insert into game_genre(game_id, genre_id) values (8, 16);

insert into Game(id, name, publisher_id) values (9, 'Saints Row: The Third', 7);
insert into game_genre(game_id, genre_id) values (9, 1);
insert into game_genre(game_id, genre_id) values (9, 3);
insert into game_genre(game_id, genre_id) values (9, 4);
insert into game_genre(game_id, genre_id) values (9, 7);
insert into game_genre(game_id, genre_id) values (9, 11);
insert into game_genre(game_id, genre_id) values (9, 12);

insert into Game(id, name, publisher_id) values (10, 'Grand Theft Auto San Andreas', 8);
insert into game_genre(game_id, genre_id) values (10, 1);
insert into game_genre(game_id, genre_id) values (10, 3);
insert into game_genre(game_id, genre_id) values (10, 4);
insert into game_genre(game_id, genre_id) values (10, 11);
insert into game_genre(game_id, genre_id) values (10, 12);
insert into game_genre(game_id, genre_id) values (10, 17);

insert into Game(id, name, publisher_id) values (11, 'Tomb Raider', 5);
insert into game_genre(game_id, genre_id) values (11, 1);
insert into game_genre(game_id, genre_id) values (11, 2);
insert into game_genre(game_id, genre_id) values (11, 3);
insert into game_genre(game_id, genre_id) values (11, 4);
insert into game_genre(game_id, genre_id) values (11, 12);

insert into Game(id, name, publisher_id) values (12, 'Starbound', 10);
insert into game_genre(game_id, genre_id) values (12, 10);
insert into game_genre(game_id, genre_id) values (12, 12);
insert into game_genre(game_id, genre_id) values (12, 15);
insert into game_genre(game_id, genre_id) values (12, 17);
insert into game_genre(game_id, genre_id) values (12, 18);

insert into Game(id, name, publisher_id) values (13, 'Half-Life 2', 2);
insert into game_genre(game_id, genre_id) values (13, 1);
insert into game_genre(game_id, genre_id) values (13, 2);
insert into game_genre(game_id, genre_id) values (13, 3);
insert into game_genre(game_id, genre_id) values (13, 6);
insert into game_genre(game_id, genre_id) values (13, 11);

insert into Game(id, name, publisher_id) values (14, 'Crysis 2 - Maximum Edition', 11);
insert into game_genre(game_id, genre_id) values (14, 1);
insert into game_genre(game_id, genre_id) values (14, 3);
insert into game_genre(game_id, genre_id) values (14, 6);
insert into game_genre(game_id, genre_id) values (14, 11);

insert into Game(id, name, publisher_id) values (15, 'Far Cry 3', 3);
insert into game_genre(game_id, genre_id) values (15, 1);
insert into game_genre(game_id, genre_id) values (15, 2);
insert into game_genre(game_id, genre_id) values (15, 3);
insert into game_genre(game_id, genre_id) values (15, 6);
insert into game_genre(game_id, genre_id) values (15, 11);
insert into game_genre(game_id, genre_id) values (15, 12);

insert into Game(id, name, publisher_id) values (16, 'Doungen Siege', 5);
insert into game_genre(game_id, genre_id) values (16, 2);
insert into game_genre(game_id, genre_id) values (16, 3);
insert into game_genre(game_id, genre_id) values (16, 10);

insert into Game(id, name, publisher_id) values (17, 'Section 8: Prejudice', 12);
insert into game_genre(game_id, genre_id) values (17, 1);
insert into game_genre(game_id, genre_id) values (17, 6);
insert into game_genre(game_id, genre_id) values (17, 11);

insert into Game(id, name, publisher_id) values (18, 'World of Warcraft', 13);
insert into game_genre(game_id, genre_id) values (18, 10);
insert into game_genre(game_id, genre_id) values (18, 19);

insert into Game(id, name, publisher_id) values (19, 'Starcraft II', 13);
insert into game_genre(game_id, genre_id) values (19, 20);

insert into Game(id, name, publisher_id) values (20, 'Diablo III', 13);
insert into game_genre(game_id, genre_id) values (20, 2);
insert into game_genre(game_id, genre_id) values (20, 7);
insert into game_genre(game_id, genre_id) values (20, 10);

insert into Game(id, name, publisher_id) values (21, 'Starcraft', 13);
insert into game_genre(game_id, genre_id) values (21, 20);

insert into Game(id, name, publisher_id) values (22, 'Diablo II', 13);
insert into game_genre(game_id, genre_id) values (22, 2);
insert into game_genre(game_id, genre_id) values (22, 7);
insert into game_genre(game_id, genre_id) values (22, 10);

insert into Game(id, name, publisher_id) values (23, 'Counter-Strike', 2);
insert into game_genre(game_id, genre_id) values (23, 1);
insert into game_genre(game_id, genre_id) values (23, 6);
insert into game_genre(game_id, genre_id) values (23, 11);

insert into Game(id, name, publisher_id) values (24, 'Darksiders', 14);
insert into game_genre(game_id, genre_id) values (24, 1);
insert into game_genre(game_id, genre_id) values (24, 2);
insert into game_genre(game_id, genre_id) values (24, 3);
insert into game_genre(game_id, genre_id) values (24, 4);
insert into game_genre(game_id, genre_id) values (24, 10);
