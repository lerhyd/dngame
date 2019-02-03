insert into ranks (id, level, rank) values (1, 0, 'Beginner');
insert into ranks (id, level, rank) values (2, 2, 'Novice');
insert into ranks (id, level, rank) values (3, 5, 'Graduate');
insert into ranks (id, level, rank) values (4, 8, 'Expert');
insert into ranks (id, level, rank) values (5, 12, 'Master');
insert into ranks (id, level, rank) values (6, 17, 'Grand Master');
insert into ranks (id, level, rank) values (7, 22, 'Legend');
insert into ranks (id, level, rank) values (8, 27, 'Psycho');

insert into actions (id, description, lvl) values (1, 'был(-а) убит(-а)', 0);
insert into actions (id, description, lvl) values (2, 'был(-а) ограблен(-а)', 1);
insert into actions (id, description, lvl) values (3, 'был(-а) зарезан(-а)', 2);
insert into actions (id, description, lvl) values (4, 'был(-а) изнасилован(-а)', 3);
insert into actions (id, description, lvl) values (5, 'был(-а) ограблен(-а)', 4);
insert into actions (id, description, lvl) values (6, 'был(-а) подвергнут(-а) нападению', 5);
insert into actions (id, description, lvl) values (7, 'был(-а) отравлен(-а)', 6);
insert into actions (id, description, lvl) values (8, 'был(-а) поддожен(-а)', 7);
insert into actions (id, description, lvl) values (9, 'был(-а) избит(-а) тетрадью', 8);
insert into actions (id, description, lvl) values (10, 'был(-а) убит(-а) карандашом', 9);
insert into actions (id, description, lvl) values (11, 'был(-а) убит(-а) книгой', 10);
insert into actions (id, description, lvl) values (12, 'был(-а) убит(-а) из огнестрельного оружия', 11);
insert into actions (id, description, lvl) values (12, 'утопился(-ась)', 11);
insert into actions (id, description, lvl) values (12, 'умер(-а) от голода', 11);
insert into actions (id, description, lvl) values (12, 'спрыгнул(-а) с крыши', 11);
insert into actions (id, description, lvl) values (12, 'умер(-а) от чумы', 11);
insert into actions (id, description, lvl) values (12, 'умер(-а) от свинного гриппа', 11);
insert into actions (id, description, lvl) values (12, 'умер(-а) от холеры', 11);

insert into action_places (id, lvl, action_place) values (1, 0, 'в кабинке туалета');
insert into action_places (id, lvl, action_place) values (1, 0, 'в спальне');
insert into action_places (id, lvl, action_place) values (1, 0, 'в канализации');
insert into action_places (id, lvl, action_place) values (1, 0, 'в музее');

insert into regions (id, city, country) values (1, 'Moscow', 'Russia');

insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1988-10-01 06:06:06', true, null, false, 'Vasya', null, true, 'Pupkin');

--Testing data that doesn't have to exist
insert into users
values ('kiran', 'kiran@kiran.com', null, '12121212', null, null, null, null, null);

insert into users
values ('tiran', 'tiran@tiran.com', null, '12121212', null, null, null, null, null);



