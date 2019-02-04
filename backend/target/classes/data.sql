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
insert into actions (id, description, lvl) values (13, 'утопился(-ась)', 11);
insert into actions (id, description, lvl) values (14, 'умерл(-а) от голода', 11);
insert into actions (id, description, lvl) values (15, 'спрыгнул(-а) с крыши', 11);
insert into actions (id, description, lvl) values (16, 'умер(-а) от чумы', 11);
insert into actions (id, description, lvl) values (17, 'умер(-а) от свинного гриппа', 11);
insert into actions (id, description, lvl) values (18, 'умер(-а) от холеры', 11);

insert into action_places (id, lvl, action_place) values (1, 0, 'в кабинке туалета');
insert into action_places (id, lvl, action_place) values (2, 0, 'в спальне');
insert into action_places (id, lvl, action_place) values (3, 0, 'в канализации');
insert into action_places (id, lvl, action_place) values (4, 0, 'в музее');

insert into regions (id, city, country, continent, planet) values (1, 'в Москве', 'в России', 'в Европе', 'в мире');
insert into regions (id, city, country, continent, planet) values (2, 'в Серене', 'в Бельгии', 'в Европе', 'в мире');
insert into regions (id, city, country, continent, planet) values (3, 'в Серене', 'в Бельгии', 'в Европе', 'в мире');
insert into regions (id, city, country, continent, planet) values (4, 'в Коге', 'в Японии', 'в Азии', 'в мире');
insert into regions (id, city, country, continent, planet) values (5, 'в Токио', 'в Японии', 'в Азии', 'в мире');
insert into regions (id, city, country, continent, planet) values (6, 'в Мати', 'в Филиппинах', 'в Азии', 'в мире');

--Criminals
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1983-01-04 06:06:06', true, null, false, 'Вася', null, true, 'Пупкин');
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1977-02-04 06:06:06', true, null, false, 'Джон', null, true, 'Уик');
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1981-12-02 06:06:06', true, null, false, 'Лада', 'Фёдорова', true, 'Ивановна');
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1967-06-25 06:06:06', true, null, false, 'Диана', 'Степановна', true, 'Конягина');
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1990-07-17 06:06:06', true, null, false, 'Роза', 'Романовна', true, 'Андреевна');
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1976-03-17 06:06:06', true, null, false, 'Мартьян', 'Васильевич', true, 'Ахметзянов');
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1964-05-12 06:06:06', true, null, false, 'Ефимов', 'Емельян', true, 'Анатольевич');

--Non criminals
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1965-03-24 06:06:06', false, null, false, 'Ярославна', 'Степановна', true, 'Ефимова');
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1990-05-20 06:06:06', false, null, false, 'Валерий', 'Дмитриевич', true, 'Матвеев');
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1965-02-09 06:06:06', false, null, false, 'Серафим', 'Вениаминович', true, 'Васильев');
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1984-05-17 06:06:06', false, null, false, 'Любим', 'Степанович', true, 'Беляев');
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1978-06-27 06:06:06', false, null, false, 'Лукерья', 'Владимировна', true, 'Щербакова');
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1972-06-17 06:06:06', false, null, false, 'Рада', 'Львовна', true, 'Назарова');
insert into persons (born_date, is_criminal, death_date, is_fake, name, patronymic, sex, surname)
values ('1994-10-10 06:06:06', false, null, false, 'Инесса', 'Кирилловна', true, 'Петрова');

--Testing data that doesn't have to exist
--Users
insert into users
values ('kiran', 'kiran@kiran.com', null, '12121212', null, null, null, null, null);

insert into users
values ('tiran', 'tiran@tiran.com', null, '12121212', null, null, null, null, null);



