insert into ranks (id, level, rank) values (1, 0, 'Beginner');
insert into ranks (id, level, rank) values (2, 5, 'Novice');
insert into ranks (id, level, rank) values (3, 10, 'Graduate');
insert into ranks (id, level, rank) values (4, 15, 'Expert');
insert into ranks (id, level, rank) values (5, 20, 'Master');
insert into ranks (id, level, rank) values (6, 25, 'Grand Master');
insert into ranks (id, level, rank) values (7, 30, 'Legend');
insert into ranks (id, level, rank) values (8, 35, 'Psycho');

insert into actions (id, description, lvl) values (1, 'Heart attack', 0);

insert into action_places (id, lvl, action_place) values (1, 0, 'toilet');

insert into regions (id, city, country) values (1, 'Moscow', 'Russia');

insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1988-10-01 06:06:06', true, null, false, 'Vasya', null, true, 'Pupkin');

--Testing data that doesn't have to exist
insert into users
values ('kiran', 'kiran@kiran.com', null, '12121212', null, null, null, null, null);

insert into users
values ('tiran', 'tiran@tiran.com', null, '12121212', null, null, null, null, null);



