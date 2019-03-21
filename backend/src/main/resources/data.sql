--Testing data that doesn't have to exist
--Users
--insert into users
--values ('kiran', 'kiran@kiran.com', null, '12121212', null, null, null, null, null);

--insert into users
--values ('tiran', 'tiran@tiran.com', null, '12121212', null, null, null, null, null);

--Base data

--Achievements
----Main
insert into achievements (title, description, task) values ('Welcome', 'Всё с чего-то начинается', 'Достигните 1 уровеня');
insert into achievements (title, description, task) values ('Victory', 'Первая победа', 'Насладитесь первой победой над своим противником');
insert into achievements (title, description, task) values ('Ad astra', 'Через тернии к звёздам', 'Достигните 5 уровня');
insert into achievements (title, description, task) values ('Unstoppable', 'Вне пределов', 'Достигните 10 уровня');
insert into achievements (title, description, task) values ('Capital', 'Не тот, о чём вы подумали', 'Накопите первые 200 очков в одной игре');
----Kira
insert into achievements (title, description, task) values ('First assassinations', 'Всё бывает в первый раз', 'Убейте 5 человек за один матч');
insert into achievements (title, description, task) values ('Blood path', 'Вы идёте по пути крови', 'Убейте 20 человек за один матч');
insert into achievements (title, description, task) values ('Uncontrollable killer', 'Ты смотришь в бездну, а бездна на тебя', 'Выиграйте 10 матчей за Киру');
insert into achievements (title, description, task) values ('Irrepressible killer', 'Из бездны уже нет выхода', 'Выиграйте 20 матчей за Киру');
----Agent
insert into achievements (title, description, task) values ('First invistigations', 'Всё бывает в первый раз', 'Поймайте 5 преступников за один матч');
insert into achievements (title, description, task) values ('Path of righteousness', 'Вы идёте по пути праведности', 'Поймайте 20 преступников за один матч');
insert into achievements (title, description, task) values ('Uncontrollable detective', 'Ты смотришь в бездну, а бездна на тебя', 'Выиграйте 10 матчей за Агента');
insert into achievements (title, description, task) values ('Irrepressible detective', 'Из бездны уже нет выхода', 'Выиграйте 20 матчей за Агента');

--Rules
insert into rules (description) values ('Человек, чьё имя будет записано в этой тетради — умрёт.');
insert into rules (description) values ('Если причина смерти не указана, человек умрёт через 40 секунд от сердечного приступа.');
insert into rules (description) values ('Тетрадь станет частью человеческого мира в тот момент, когда коснется земли.');
insert into rules (description) values ('За человеком, получившим тетрадь смерти, до конца жизни будет следовать бог смерти, потерявший эту тетрадь.');
insert into rules (description) values ('Хозяин тетради сможет видеть и слышать первоначальных владельцев тетради.');
insert into rules (description) values ('Нельзя убить бога смерти');
insert into rules (description) values ('Человек, использующий эту тетрадь, не сможет попасть ни в Ад, ни в Рай.');
insert into rules (description) values ('Бог смерти совершенно не обязан кому-то объяснять, как использовать тетрадь или рассказывать правила, касающиеся человека, владеющего ею.');
insert into rules (description) values ('Боги Смерти могут увеличивать продолжительность своей жизни, записывая имена людей в тетрадь, но люди не могут.');
insert into rules (description) values ('Каждый человек имеет латентную склонность к суициду. Если человек напишет в тетрадь свое имя, то он умрет.');
insert into rules (description) values ('Нельзя убить человека, имя которого записано неверно');
insert into rules (description) values ('Если бог смерти решит использовать свою тетрадь, чтобы избавиться от кого, кто угрожает дорогому этому богу человеку, то жизнь последнего будет продлена, но сам бог смерти умрёт.');
insert into rules (description) values ('Человек, обладающий глазами бога смерти, сможет узнать имя и жизненный срок других, лишь взглянув на них.');
insert into rules (description) values ('Люди, отказавшиеся от права владения тетрадью смерти, забывают все, ее касающееся.');

--Ranks
----Kira's
insert into ranks (id, points, rank, is_kira) values (1, 30, 'Соловей разбойник', true);
insert into ranks (id, points, rank, is_kira) values (2, 35, 'Джокер', true);
insert into ranks (id, points, rank, is_kira) values (3, 40, 'Волан-де-Морт', true);
insert into ranks (id, points, rank, is_kira) values (4, 50, 'Пеннивайз', true);
insert into ranks (id, points, rank, is_kira) values (5, 80, 'Фредди Крюгер', true);
insert into ranks (id, points, rank, is_kira) values (6, 100, 'Агент 47', true);
insert into ranks (id, points, rank, is_kira) values (7, 170, 'Джон Уик', true);
insert into ranks (id, points, rank, is_kira) values (8, 256, 'Танос', true);
----Agent's
insert into ranks (id, points, rank, is_kira) values (9, 30, 'Даша путешественница', false);
insert into ranks (id, points, rank, is_kira) values (10, 35, 'Волшебный клубок', false);
insert into ranks (id, points, rank, is_kira) values (11, 40, 'Скуби-Ду', false);
insert into ranks (id, points, rank, is_kira) values (12, 50, 'Глухарь', false);
insert into ranks (id, points, rank, is_kira) values (13, 80, 'Комиссар Гордон', false);
insert into ranks (id, points, rank, is_kira) values (14, 100, 'Агент L', false);
insert into ranks (id, points, rank, is_kira) values (15, 170, 'Яндекс', false);
insert into ranks (id, points, rank, is_kira) values (16, 256, 'Шерлок Холмс', false);

--Action Places
insert into action_places (id, lvl, action_place) values (1, 0, 'в кабинке туалета');
insert into action_places (id, lvl, action_place) values (2, 0, 'в спальне');
insert into action_places (id, lvl, action_place) values (3, 0, 'в канализации');
insert into action_places (id, lvl, action_place) values (4, 1, 'на крыше 2-го корпуса на Ломоносова');
insert into action_places (id, lvl, action_place) values (5, 1, 'в кинотеатре');
insert into action_places (id, lvl, action_place) values (6, 1, 'рядом с магазином одежды');
insert into action_places (id, lvl, action_place) values (7, 2, 'в мясном бутике');
insert into action_places (id, lvl, action_place) values (8, 2, 'во время полета на самолете');
insert into action_places (id, lvl, action_place) values (9, 2, 'в поезде');
insert into action_places (id, lvl, action_place) values (10, 3, 'в сексшопе');
insert into action_places (id, lvl, action_place) values (11, 3, 'у гадалки');
insert into action_places (id, lvl, action_place) values (12, 3, 'в музее ');
insert into action_places (id, lvl, action_place) values (13, 4, 'в церкви');
insert into action_places (id, lvl, action_place) values (14, 4, 'в ресторане');
insert into action_places (id, lvl, action_place) values (15, 4, 'на конференции');
insert into action_places (id, lvl, action_place) values (16, 5, 'в полицейском участке');
insert into action_places (id, lvl, action_place) values (17, 5, 'в антикафе');
insert into action_places (id, lvl, action_place) values (18, 5, 'в анимационном парке');
insert into action_places (id, lvl, action_place) values (19, 6, 'в океанариуме');
insert into action_places (id, lvl, action_place) values (20, 6, 'в ночном клубе');
insert into action_places (id, lvl, action_place) values (21, 6, 'в офисе vk');
insert into action_places (id, lvl, action_place) values (22, 7, 'в баре');
insert into action_places (id, lvl, action_place) values (23, 7, 'в публичном доме');
insert into action_places (id, lvl, action_place) values (24, 7, 'в 375 аудитории');
insert into action_places (id, lvl, action_place) values (25, 8, 'в кофейне');
insert into action_places (id, lvl, action_place) values (26, 8, 'в госдуме');
insert into action_places (id, lvl, action_place) values (27, 8, 'в налоговой');
insert into action_places (id, lvl, action_place) values (28, 9, 'в аптеке');
insert into action_places (id, lvl, action_place) values (29, 9, 'в очереди банка');
insert into action_places (id, lvl, action_place) values (30, 9, 'в реке');
insert into action_places (id, lvl, action_place) values (31, 10, 'в детской комнате');
insert into action_places (id, lvl, action_place) values (32, 10, 'в оперном театре');
insert into action_places (id, lvl, action_place) values (33, 10, 'в посольстве Уганды!');
insert into action_places (id, lvl, action_place) values (34, 0, 'на восточном рынке');
insert into action_places (id, lvl, action_place) values (35, 1, 'в автобусе');
insert into action_places (id, lvl, action_place) values (36, 2, 'в саду');
insert into action_places (id, lvl, action_place) values (37, 3, 'на стройке');
insert into action_places (id, lvl, action_place) values (38, 4, 'на вершине горы');
insert into action_places (id, lvl, action_place) values (39, 5, 'в кабине грузовика');
insert into action_places (id, lvl, action_place) values (40, 6, 'в восточном экспрессе');
insert into action_places (id, lvl, action_place) values (41, 7, 'под Коломной');
insert into action_places (id, lvl, action_place) values (42, 8, 'в здании верховной рады');
insert into action_places (id, lvl, action_place) values (43, 9, 'в стране чудес');
insert into action_places (id, lvl, action_place) values (44, 10, 'в деревне скрытого листа');
insert into action_places (id, lvl, action_place) values (45, 0, 'в Карибском море');
insert into action_places (id, lvl, action_place) values (46, 1, 'в Хогвартсе');
insert into action_places (id, lvl, action_place) values (47, 2, 'на космической станции мир');
insert into action_places (id, lvl, action_place) values (48, 3, 'на Зазеркалье');
insert into action_places (id, lvl, action_place) values (49, 4, 'в стране дураков');
insert into action_places (id, lvl, action_place) values (50, 5, 'в Браавосе');
insert into action_places (id, lvl, action_place) values (51, 6, 'в Винтерфел');
insert into action_places (id, lvl, action_place) values (52, 7, 'в крепости кошек');
insert into action_places (id, lvl, action_place) values (53, 8, 'в дворце Кагуи');
insert into action_places (id, lvl, action_place) values (54, 9, 'в мире Шинигами');
insert into action_places (id, lvl, action_place) values (55, 10, 'в долине завершения');

--Actions
insert into actions (id, description, lvl) values (1, 'был(-а) пойман(-а) полицией', 0);
insert into actions (id, description, lvl) values (2, 'был(-а) убит(-а)', 0); -- Максим Веселов убил(-а) Ярослав Мудрый в кабинке туалета
insert into actions (id, description, lvl) values (3, 'был(-а) ограблен(-а)', 0);
insert into actions (id, description, lvl) values (4, 'был(-а) зарезан(-а)', 0);
insert into actions (id, description, lvl) values (5, 'был(-а) изнасилован(-а)', 1);
insert into actions (id, description, lvl) values (6, 'был(-а) ограблен(-а)', 1);
insert into actions (id, description, lvl) values (7, 'был(-а) подвергнут(-а) нападению', 1);
insert into actions (id, description, lvl) values (8, 'был(-а) отравлен(-а)', 2);
insert into actions (id, description, lvl) values (9, 'был(-а) поддожен(-а)', 2);
insert into actions (id, description, lvl) values (10, 'был(-а) избит(-а) тетрадью', 2);
insert into actions (id, description, lvl) values (11, 'был(-а) убит(-а) карандашом', 3);
insert into actions (id, description, lvl) values (12, 'был(-а) убит(-а) книгой', 3);
insert into actions (id, description, lvl) values (13, 'был(-а) убит(-а) из огнестрельного оружия', 3);
insert into actions (id, description, lvl) values (14, 'утопился(-ась)', 4);
insert into actions (id, description, lvl) values (15, 'умерл(-а) от голода', 4);
insert into actions (id, description, lvl) values (16, 'спрыгнул(-а) с крыши', 4);
insert into actions (id, description, lvl) values (17, 'умер(-а) от чумы', 5);
insert into actions (id, description, lvl) values (18, 'умер(-а) от свинного гриппа', 5);
insert into actions (id, description, lvl) values (19, 'умер(-а) от холеры', 5);
insert into actions (id, description, lvl) values (20, 'умер(-а) от болевого шока', 6);
insert into actions (id, description, lvl) values (21, 'был(-а) убит(-а) собакой', 6);
insert into actions (id, description, lvl) values (22, 'был(-а) убит(-а) медведем', 6);
insert into actions (id, description, lvl) values (23, 'был(-а) убит(-а) злым духом', 7);
insert into actions (id, description, lvl) values (24, 'замёрз(-ла) до смерти', 7);
insert into actions (id, description, lvl) values (25, 'умер(-ла) от передозировки наркотиков', 7);
insert into actions (id, description, lvl) values (26, 'подавился(-ась) едой', 8);
insert into actions (id, description, lvl) values (27, 'программировал на 1C', 8);
insert into actions (id, description, lvl) values (28, 'был(-а) избит(-а) тетрадью', 8);
insert into actions (id, description, lvl) values (29, 'был(-а) убит(-а) роботом', 9);
insert into actions (id, description, lvl) values (30, 'умер(-а) от углекислого газа', 9);
insert into actions (id, description, lvl) values (31, 'пытался(-ась) призвать сатану', 9);
insert into actions (id, description, lvl) values (32, 'был(-а) убит(-а) ударом молнии', 10);
insert into actions (id, description, lvl) values (33, 'умерл(-а) от смеха', 10);
insert into actions (id, description, lvl) values (34, 'убил(-а) собаку Джона Уика', 10);

--News templates
----10 !fake news
insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Произошло жестокое преступление.', true, false, true, false, false, 2, 7); --убийство

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'На масленице что-то пошло не так, совсем не так ...', true, false, true, false, false, 9, 30); --подожжен

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, '10 раз сказал "папка" на ОВТ и ...', true, false, false , false, false, 32, 21);--умер от молнии

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Ген. директор Reebok увидел новые лозунги компании.', true , false, false , false, false, 26, 1); --подавился едой
--
insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Производитель ручек был атакован конкурентом.', true , false, true , false, false, 11, 44);--убит карандашом

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, '8 допов для сдачи одной лабы.', false , false, true , false, false, 5, 10);--был изнасилован

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Ироничная смерть анестезиолога-коррупционера.', true , false, false , false, false, 20, 33);--болевой шок

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'ШОК! РУССКИЙ СТУДЕНТ ЗАЧИТАЛ РЭП НА КИТАЙСКОМ.', false , false, false , false, false, 31, 26);--пытался призвать сатану

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Борьба с наркотиками. Миф или реальность?', false , false, false , false, false, 25, 4);--передоз

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Чиновник решил доказать, что прожиточного минимума ему хватит на месяц.', true , false, false , false, false, 15, 29);--от голода

----10 fake news
insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'В России будет свой интернет. Го к нам?', false , true, false , false, false, 27, 17);--1С

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Первокурсники на ВТ сказали, что им не нужны допы и они сдадут все вовремя.', true , true, false , false, false, 33, 24);--умер от смеха

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Ужасная смерть космонавта на МКС', true , true, false , false, false, 22, 28);--убит медведем

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Убийственный уж.', true , true, true , false, false, 8, 46);--отравлен

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Новые виды оружия были добавлены в PUBG', true , true, true , false, false, 2, 51);--был убит

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'В ОАЭ температура опутилась до -38', true , true, false, false, false, 24, 24);--замерз до смерти

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Ходят слухи, что учитель Чака Норриса сильнее ученика в разы.', true , true, true , false, false, 13, 54);--огнестрел

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Ужасная смерть для комара', true , true, false , false, false, 19, 45);--холера

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Электричество во всем мире пропало год назад.', true , true, false , false, false, 29, 38);--убит роботом

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id,action_place)
values (false, 'Инцидент на Ломоносова 9', true , true, false , false, false, 16, 4);--спрыгнул с крыши

----5 absurd news
insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Олигарх отобрал у бомжа пустые бутылки, чтобы сдать их', false , true, true , false, false, 3, 40);--ограблен

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Интернет узнал настоящее имя птицы Так-Блэт. Press F to pay respect.', true , true, false , false, false, 17, 12);--умер от чумы

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Шок контент. Мальчик наказал ананас.', false , true, true , false, false, 10, 49);--избит тетрадью

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id,action_place)
values (false, 'Аквамен получил в паспортном столе новое имя и стал гражданином России, но ненадолго.', true , true, false , false, false, 14, 32);--утопился

insert into news (is_agent, what, is_die, is_fake, guilty_person_exists, is_published_for_agent, is_published_for_kira, action_id, action_place)
values (false, 'Синий кит потерпел поражение в битве MMA за пояс в легком весе.', true , true, false , false, false, 21, 13);--убит собакой

----Persons
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 August 1988',false,false,'Антонина','Яковлевна',false,'Борисова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 October 1973',true,false,'Клара','Тимофеевна',false,'Русина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 January 1979',false,false,'Марк','Эльдарович',true,'Новиков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 December 1991',true,false,'Авдей','Семенович',true,'Кириллов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 February 1966',false,false,'Кристина','Ефимовна',false,'Русова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 May 1988',true,false,'Амина','Васильевна',false,'Ерофеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 February 1995',false,false,'Казимира','Егоровна',false,'Кузьмина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 April 1977',false,false,'Каролина','Матвеевна',false,'Жукова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 May 1967',false,false,'Милан','Максимович',true,'Соколов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 April 1963',true,false,'Адриан','Ильич',true,'Шашков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 November 1969',false,false,'Домна','Эдуардовна',false,'Лапина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 January 1992',true,false,'Диана','Валентиновна',false,'Ильина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 July 1967',false,false,'Бруно','Тимурович',true,'Крылов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 February 1971',true,false,'Мариетта','Егоровна',false,'Полякова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 October 1967',true,false,'Ариадна','Романовна',false,'Лютова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 March 1965',false,false,'Твердислав','Артемович',true,'Петров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 January 1976',true,false,'Милий','Кириллович',true,'Захаров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 July 1994',false,false,'Казимир','Тимофеевич',true,'Леонов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 November 1970',true,false,'Аделаида','Кирилловна',false,'Фомина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 June 1972',true,false,'Сигизмунд','Эльдарович',true,'Зеленов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('11 July 1968',false,false,'Василий','Семенович',true,'Иванов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 March 1968',false,false,'Терентий','Максович',true,'Покровский');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 May 1968',false,false,'Эльвира','Леонидовна',false,'Мартынова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 February 1993',true,false,'Алиса','Антоновна',false,'Алексеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 June 1987',true,false,'Светозар','Евгеньевич',true,'Миронов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 February 1991',true,false,'Милен','Максимович',true,'Карпов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 June 1985',true,false,'Берта','Владимировна',false,'Голубева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 August 1969',false,false,'Пров','Тимофеевич',true,'Рзаев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 October 1984',false,false,'Арефий','Альбертович',true,'Андреев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 January 1980',false,false,'Аграфена','Федоровна',false,'Андреева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 January 1976',true,false,'Генриетта','Дмитриевна',false,'Стручкова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 May 1971',true,false,'Ольга','Львовна',false,'Филиппова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 June 1994',false,false,'Денис','Эдуардович',true,'Денисов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 May 1977',true,false,'Эраст','Эдуардович',true,'Семёнов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 April 1975',false,false,'Станислава','Федоровна',false,'Ильина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 April 1964',true,false,'Мира','Михайловна',false,'Смирнова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 May 1965',true,false,'Ладимир','Альбертович',true,'Вихирев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 August 1971',false,false,'Глафира','Виталиевна',false,'Данилова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 November 1968',false,false,'Владимир','Богданович',true,'Федотов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 July 1970',true,false,'Василиса','Григорьевна',false,'Игнатьева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 November 1977',false,false,'Аза','Кирилловна',false,'Баранова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 February 1993',false,false,'Лилиана','Евгеньевна',false,'Матвеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 February 1968',true,false,'Борислав','Федорович',true,'Пономарёв');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 June 1971',false,false,'Фирс','Николаевич',true,'Егоров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 October 1984',false,false,'Нифонт','Максович',true,'Беляев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 March 1982',true,false,'Лучезар','Васильевич',true,'Вирский');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 November 1981',false,false,'Клавдия','Станиславовна',false,'Журавлёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 October 1973',true,false,'Варвара','Аркадьевна',false,'Зайцева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 April 1982',false,false,'Валентин','Дмитриевич',true,'Герасимов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 July 1993',false,false,'Виргиния','Романовна',false,'Рзаева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 February 1987',false,false,'Серафим','Федорович',true,'Комаров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 September 1990',true,false,'Никон','Кириллович',true,'Крылов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 November 1990',false,false,'Ратмир','Семенович',true,'Беляев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 November 1977',false,false,'Оксана','Юрьевна',false,'Трифонова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 December 1988',false,false,'Юрий','Геннадьевич',true,'Троицкий');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 June 1969',false,false,'Фирс','Викторович',true,'Ильин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 June 1972',false,false,'Ипат','Николаевич',true,'Рощин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 February 1966',false,false,'Лавр','Алексеевич',true,'Ильин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 August 1984',false,false,'Пантелеймон','Павлович',true,'Шершов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 January 1992',true,false,'Авдей','Тимофеевич',true,'Соловьёв');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 May 1965',false,false,'Михаил','Артемович',true,'Шершов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 April 1976',true,false,'Инесса','Матвеевна',false,'Андреева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 September 1979',true,false,'Лазарь','Владимирович',true,'Константинов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 November 1979',true,false,'Леокадия','Павловна',false,'Захарова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 February 1975',false,false,'Севастьян','Егорович',true,'Поляков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 November 1971',false,false,'Вероника','Валерьевна',false,'Константинова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 November 1987',false,false,'Борислава','Тимофеевна',false,'Журавлёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 July 1966',true,false,'Варвара','Владиславовна',false,'Наумова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 July 1971',true,false,'Владилена','Викторовна',false,'Голубева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 February 1987',true,false,'Евлампий','Григорьевич',true,'Савельев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 May 1963',false,false,'Арсений','Аркадьевич',true,'Иванов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 May 1964',true,false,'Станимир','Георгиевич',true,'Воробьёв');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 April 1992',false,false,'Серафима','Ефимовна',false,'Михайлова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 June 1971',false,false,'Аверкий','Макарович',true,'Кузьмин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 May 1988',false,false,'Тамара','Александровна',false,'Воронец');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 June 1982',false,false,'Ника','Павловна',false,'Попова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 May 1977',false,false,'Людмила','Филипповна',false,'Савельева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 April 1988',false,false,'Тамара','Робертовна',false,'Мамедова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 January 1968',false,false,'Борис','Русланович',true,'Антонов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 March 1965',false,false,'Степанида','Леонидовна',false,'Прокофьева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 September 1978',false,false,'Елизавета','Павловна',false,'Новикова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 September 1970',false,false,'Раиса','Анатольевна',false,'Жукова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 March 1975',false,false,'Екатерина','Александровна',false,'Крылова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 May 1991',false,false,'Дмитрий','Федорович',true,'Леонтьев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 July 1969',false,false,'Жанна','Семеновна',false,'Соколова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 March 1987',false,false,'Валерий','Егорович',true,'Охота');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 July 1970',false,false,'Леокадия','Федоровна',false,'Титова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 June 1972',true,false,'Клавдия','Алексеевна',false,'Андреева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 April 1971',false,false,'Творимир','Романович',true,'Константинов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 May 1971',false,false,'Бонифаций','Семенович',true,'Власов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 June 1968',false,false,'Карл','Сергеевич',true,'Смирнов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 November 1990',false,false,'Мира','Яковлевна',false,'Данилова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 October 1991',false,false,'Виктор','Кириллович',true,'Виноградов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 May 1984',true,false,'Антонида','Семеновна',false,'Денисова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 June 1982',false,false,'Аглая','Федоровна',false,'Карпова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('11 October 1971',false,false,'Агата','Владиславовна',false,'Баженова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 July 1990',false,false,'Христофор','Иванович',true,'Гаврилов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 July 1981',false,false,'Елизавета','Григорьевна',false,'Вихирева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 May 1964',false,false,'Мирослава','Павловна',false,'Попова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 August 1992',false,false,'Филарет','Петрович',true,'Зайцев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 August 1971',true,false,'Ангелина','Вячеславовна',false,'Трифонова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 September 1964',true,false,'Леон','Вячеславович',true,'Миронов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 November 1968',false,false,'Мариетта','Тарасовна',false,'Абрамова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 December 1980',false,false,'Антон','Максимович',true,'Быков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 November 1971',false,false,'Прасковья','Александровна',false,'Виноградова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 August 1968',false,false,'Феоктист','Станиславович',true,'Никифоров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 May 1975',false,false,'Наталья','Васильевна',false,'Белозёрова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 October 1967',true,false,'Милана','Васильевна',false,'Тайская');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 April 1966',false,false,'Амос','Матвеевич',true,'Новиков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 April 1970',false,false,'Аггей','Валерьевич',true,'Фомов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 November 1987',false,false,'Антон','Вячеславович',true,'Комаров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 July 1980',true,false,'Розалия','Иосифовна',false,'Баженова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 November 1969',false,false,'Автандил','Федорович',true,'Гусев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 February 1995',true,false,'Илья','Дмитриевич',true,'Недашковский');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 October 1966',false,false,'Анастасия','Евгеньевна',false,'Михайлова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 July 1974',true,false,'Афанасий','Валентинович',true,'Матвеев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 April 1975',false,false,'Ратмир','Давидович',true,'Рощин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 February 1979',false,false,'Фёдор','Олегович',true,'Воробьёв');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 September 1977',true,false,'Алиса','Олеговна',false,'Титова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 May 1992',false,false,'Марк','Степанович',true,'Чаурин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 May 1969',false,false,'Ариадна','Львовна',false,'Тарская');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 December 1993',true,false,'Авксентий','Русланович',true,'Усачёв');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 May 1966',false,false,'Домна','Геннадиевна',false,'Федотова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 May 1976',false,false,'Афанасий','Борисович',true,'Гусев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 June 1971',true,false,'Антонида','Иосифовна',false,'Андреева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 March 1979',false,false,'Рената','Евгеньевна',false,'Арсеньева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 April 1967',false,false,'Анисья','Константиновна',false,'Григорьева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 September 1968',false,false,'Анна','Робертовна',false,'Маркова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 April 1986',true,false,'Жанна','Ивановна',false,'Игнатьева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 December 1968',false,false,'Капитолина','Львовна',false,'Сморчкова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 May 1977',false,false,'Конон','Ярославович',true,'Шалдыбин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 August 1976',false,false,'Агафон','Русланович',true,'Михайлов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 August 1970',false,false,'Олег','Аркадьевич',true,'Макаров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 October 1976',false,false,'Владислава','Яковлевна',false,'Тюрина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 September 1981',false,false,'Диана','Михайловна',false,'Яковлева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 January 1993',false,false,'Жанна','Аркадьевна',false,'Маркова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 April 1971',false,false,'Маргарита','Тимофеевна',false,'Игнатьева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 April 1988',true,false,'Януарий','Владимирович',true,'Чаурин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 May 1990',true,false,'Флорентина','Владиславовна',false,'Афанасьева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 November 1995',false,false,'Арий','Вячеславович',true,'Соколов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 March 1985',true,false,'Тамара','Евгеньевна',false,'Веселкова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 March 1982',true,false,'Антонин','Станиславович',true,'Ильин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 June 1966',true,false,'Катерина','Павловна',false,'Титова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 March 1993',false,false,'Христина','Ильинична ',false,'Холодкова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 February 1969',false,false,'Капитон','Владимирович',true,'Демьянов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 October 1974',true,false,'Виолетта','Ярославовна',false,'Лютова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 March 1968',true,false,'Мальвина','Ильинична ',false,'Андронова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 June 1991',false,false,'Пелагея','Игоревна',false,'Яковлева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 December 1994',true,false,'Валерьян','Юрьевич',true,'Денисов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 December 1988',true,false,'Иларион','Семенович',true,'Ушаков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 February 1976',true,false,'Парфен','Иванович',true,'Охота');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 February 1964',true,false,'Вадим','Иванович',true,'Прокофьев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 July 1983',false,false,'Мальвина','Матвеевна',false,'Соловьёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 October 1969',true,false,'Моисей','Вениаминович',true,'Чаурин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 August 1986',true,false,'Лилиана','Олеговна',false,'Белова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 April 1980',false,false,'Валерьян','Георгиевич',true,'Сергеев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 February 1989',false,false,'Ян','Миронович',true,'Яковлев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 February 1973',false,false,'Любава','Федоровна',false,'Алексеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 June 1983',false,false,'Розина','Романовна',false,'Герасимова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 November 1988',false,false,'Анжела','Виталиевна',false,'Морозова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 December 1990',false,false,'Неонила','Петровна',false,'Наумова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 February 1993',true,false,'Любомира','Артемовна',false,'Павлова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 August 1964',false,false,'Эрика','Михайловна',false,'Русина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 September 1990',true,false,'Мстислава','Ивановна',false,'Ичёткина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('11 June 1965',true,false,'Горислава','Федоровна',false,'Маркова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 July 1975',true,false,'Владлена','Владиславовна',false,'Дидиченко');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 January 1972',true,false,'Степан','Альбертович',true,'Конягин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 June 1963',true,false,'Елисей','Николаевич',true,'Шашков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 October 1983',true,false,'Никодим','Эдуардович',true,'Васютин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 September 1987',false,false,'Розина','Григорьевна',false,'Русова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 May 1974',false,false,'Инна','Валентиновна',false,'Ильина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 July 1991',true,false,'Леонид','Григорьевич',true,'Тайский');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 January 1980',true,false,'Ксения','Александровна',false,'Иванова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 April 1979',false,false,'Клара','Яковлевна',false,'Миронова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 July 1988',true,false,'Марк','Кириллович',true,'Городнов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 October 1964',true,false,'Станислав','Олегович',true,'Покровский');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 September 1983',false,false,'Евдокия','Ярославовна',false,'Леонова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 May 1966',true,false,'Алла','Сергеевна',false,'Гулевич');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('11 March 1975',true,false,'Изот','Артемович',true,'Васютин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 October 1967',true,false,'Фатина','Васильевна',false,'Никитина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 November 1963',true,false,'Владлен','Петрович',true,'Абрамов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 April 1963',true,false,'Людмила','Ярославовна',false,'Сергеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 June 1979',true,false,'Август','Миронович',true,'Семёнов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 June 1981',false,false,'Бажен','Григорьевич',true,'Холодков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 November 1970',false,false,'Ева','Евгеньевна',false,'Александрова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 November 1979',true,false,'Любомила','Валентиновна',false,'Чапко');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 July 1972',false,false,'Инесса','Геннадиевна',false,'Захарова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 March 1971',false,false,'Силантий','Егорович',true,'Богданов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 June 1987',true,false,'Амаяк','Тимурович',true,'Савельев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 July 1994',true,false,'Антонина','Аркадьевна',false,'Львова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 April 1990',false,false,'Лада','Павловна',false,'Тюрина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 February 1970',false,false,'Валентина','Романовна',false,'Новикова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 February 1981',true,false,'Людмила','Викторовна',false,'Чаурина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 November 1965',false,false,'Ладимир','Тимурович',true,'Дидиченко');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 February 1995',false,false,'Афанасий','Альбертович',true,'Константинов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 April 1995',false,false,'Валерьян','Петрович',true,'Назаров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 October 1994',false,false,'Диана','Эдуардовна',false,'Кравченко');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 September 1979',true,false,'Тамара','Сергеевна',false,'Романова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 March 1983',true,false,'Анатолий','Антонович',true,'Ерофеев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 October 1990',true,false,'Святополк','Филиппович',true,'Баландин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 March 1986',false,false,'Ярослав','Егорович',true,'Трифонов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 April 1968',true,false,'Клара','Андреевна',false,'Сидорова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 November 1963',true,false,'Аваз','Валерьевич',true,'Тимофеев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 May 1987',true,false,'Евгения','Робертовна',false,'Давыдова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 February 1989',true,false,'Эвелина','Дмитриевна',false,'Дмитриева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 August 1986',true,false,'Афанасий','Борисович',true,'Ушаков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 March 1977',true,false,'Велимир','Ильич',true,'Куколевский');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 June 1967',true,false,'Боголюб','Иванович',true,'Шершов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 September 1992',true,false,'Варфоломей','Федорович',true,'Сергеев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 February 1977',true,false,'Виталий','Владимирович',true,'Кудрявцев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 March 1995',true,false,'Вадим','Альбертович',true,'Егоров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 August 1992',true,false,'Викторина','Ивановна',false,'Остимчук');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 June 1982',true,false,'Анна','Даниловна',false,'Сергеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 January 1965',true,false,'Арон','Иванович',true,'Амбарцумян');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 February 1982',true,false,'Майя','Кирилловна',false,'Зеленова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 October 1973',true,false,'Фаина','Петровна',false,'Ефимова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 August 1966',true,false,'Аглая','Олеговна',false,'Тюрина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 August 1987',true,false,'Михаил','Константинович',true,'Дидиченко');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 August 1977',true,false,'Инесса','Владиславовна',false,'Герасимова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 April 1984',false,false,'Тимофей','Русланович',true,'Рзаев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 December 1975',true,false,'Владилена','Георгиевна',false,'Николаева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 May 1994',false,false,'Елисей','Алексеевич',true,'Васильев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 September 1966',false,false,'Зоя','Валерьевна',false,'Степанова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 October 1982',false,false,'Варфоломей','Алексеевич',true,'Матвеев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 July 1993',true,false,'Диана','Платоновна',false,'Недашковская');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 May 1977',true,false,'Виолетта','Викторовна',false,'Фомова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 October 1990',false,false,'Мирон','Альбертович',true,'Власов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 April 1974',true,false,'Аскольд','Миронович',true,'Ушаков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 November 1975',true,false,'Муза','Егоровна',false,'Охота');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 October 1990',true,false,'Елена','Анатольевна',false,'Баландина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 March 1978',true,false,'Бронислава','Павловна',false,'Фёдорова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 August 1964',false,false,'Семён','Семенович',true,'Петров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 November 1989',false,false,'Денис','Олегович',true,'Виноградов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 July 1993',true,false,'Рубен','Иванович',true,'Беляев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 December 1963',false,false,'Виктор','Вениаминович',true,'Скачков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 July 1968',false,false,'Ангелина','Валентиновна',false,'Осипова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 November 1987',false,false,'Регина','Даниловна',false,'Кудрявцева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 June 1977',true,false,'Милица','Сергеевна',false,'Павлова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 October 1985',false,false,'Мирослава','Павловна',false,'Богданова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 May 1985',true,false,'Ярослав','Вениаминович',true,'Никифоров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 September 1968',true,false,'Владислав','Тарасович',true,'Ефимов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 August 1991',false,false,'Данила','Антонович',true,'Рустамов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 December 1973',true,false,'Анна','Петровна',false,'Сысолятина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 April 1988',true,false,'Олег','Михайлович',true,'Голубев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 July 1979',false,false,'Александр','Семенович',true,'Ефимов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 December 1995',false,false,'Родион','Васильевич',true,'Пешнин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 April 1968',true,false,'Анжела','Игоревна',false,'Журавель');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 June 1993',false,false,'Полина','Антоновна',false,'Никифорова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 June 1983',false,false,'Евгеиня','Игоревна',false,'Воробьёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 April 1973',true,false,'Алла','Валерьевна',false,'Сморчкова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 July 1987',false,false,'Спиридон','Ильич',true,'Недашковский');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 July 1993',true,false,'Тимур','Матвеевич',true,'Соловьёв');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 December 1970',true,false,'Марианна','Игоревна',false,'Тарская');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 August 1967',true,false,'Август','Вадимович',true,'Секунов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 August 1981',false,false,'Тихон','Святославович',true,'Рзаев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('11 September 1979',true,false,'Герасим','Максимович',true,'Демьянов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 December 1973',false,false,'Регина','Георгиевна',false,'Матвеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 April 1983',false,false,'Евгения','Федоровна',false,'Матвеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 August 1992',true,false,'Дина','Ивановна',false,'Сморчкова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 September 1972',true,false,'Дина','Александровна',false,'Белова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 December 1969',false,false,'Людмила','Григорьевна',false,'Кузнецова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 December 1971',true,false,'Альбина','Тарасовна',false,'Муравьёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 May 1983',true,false,'Архип','Альбертович',true,'Титов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 July 1980',false,false,'Алёна','Федоровна',false,'Соловьёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 August 1984',true,false,'Дина','Богдановна',false,'Львова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 October 1986',false,false,'Мелитриса','Матвеевна',false,'Кочеткова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('11 November 1995',false,false,'Кирилл','Михайлович',true,'Зеленов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 July 1971',false,false,'Римма','Робертовна',false,'Тимофеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 June 1969',true,false,'Берта','Филипповна',false,'Воробьёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 November 1993',true,false,'Владлен','Валентинович',true,'Сидоров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 August 1988',true,false,'Доброслав','Эдуардович',true,'Герасимов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 May 1975',false,false,'Дмитрий','Федорович',true,'Фомов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 April 1981',true,false,'Гордей','Борисович',true,'Фомов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 May 1995',true,false,'Лидия','Дмитриевна',false,'Константинова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 October 1975',true,false,'Прокл','Михайлович',true,'Леонтьев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 October 1972',false,false,'Ярослав','Алексеевич',true,'Петров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 March 1977',false,false,'Филипп','Егорович',true,'Попов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 October 1991',false,false,'Инна','Кирилловна',false,'Шашкова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 November 1970',true,false,'Родион','Михайлович',true,'Сморчков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 September 1977',true,false,'Олимпий','Давидович',true,'Трофимов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 February 1978',false,false,'Амина','Тимофеевна',false,'Беляева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 June 1972',true,false,'Алина','Львовна',false,'Трифонова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 May 1984',true,false,'Пантелеймон','Давидович',true,'Крылов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 June 1974',false,false,'Фаина','Игоревна',false,'Демьянченко');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 August 1980',false,false,'Лариса','Олеговна',false,'Воронец');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 August 1977',true,false,'Аскольд','Владимирович',true,'Савельев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 October 1977',false,false,'Федот','Эльдарович',true,'Лютов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 January 1969',true,false,'Ананий','Павлович',true,'Матвеев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 August 1971',true,false,'Аглая','Иосифовна',false,'Соловьёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 December 1965',true,false,'Никита','Иванович',true,'Миронов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 March 1985',true,false,'Ия','Платоновна',false,'Кузнецова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 May 1966',false,false,'Гавриил','Данилович',true,'Смирнов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 December 1983',false,false,'Гордей','Юрьевич',true,'Фомин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 July 1965',false,false,'Эвелина','Евгеньевна',false,'Муравьёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 December 1986',false,false,'Надежда','Викторовна',false,'Гулевич');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 April 1993',true,false,'Богдан','Станиславович',true,'Киселёв');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 August 1974',false,false,'Татьяна','Богдановна',false,'Белозёрова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 June 1971',false,false,'Вероника','Романовна',false,'Тюрина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 November 1978',false,false,'Эльвира','Степановна',false,'Макарова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 January 1970',false,false,'Ульян','Геннадиевич',true,'Наумов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 October 1963',true,false,'Арефий','Павлович',true,'Пчёлкин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 June 1970',false,false,'Ангелина','Виталиевна',false,'Морозова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 August 1975',true,false,'Родион','Федорович',true,'Трофимов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 October 1969',false,false,'Селиван','Сергеевич',true,'Егоров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 August 1978',false,false,'Александра','Егоровна',false,'Комарова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 October 1976',false,false,'Федосий','Андреевич',true,'Петров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 May 1973',false,false,'Вероника','Тарасовна',false,'Тарская');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 August 1981',false,false,'Арнольд','Иванович',true,'Тарский');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 November 1984',false,false,'Нона','Даниловна',false,'Смирнова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 June 1975',true,false,'Анфиса','Петровна',false,'Рощина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 June 1993',true,false,'Гордей','Тарасович',true,'Кузьмин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 March 1972',true,false,'Арам','Денисович',true,'Васильев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 July 1984',false,false,'Тамара','Тимофеевна',false,'Козлова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 May 1983',false,false,'Любосмысл','Петрович',true,'Журавель');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 November 1988',true,false,'Евстафий','Константинович',true,'Макаров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 April 1989',true,false,'Татьяна','Платоновна',false,'Орлова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 July 1963',true,false,'Тимур','Тарасович',true,'Назаров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 January 1977',false,false,'Вероника','Тарасовна',false,'Щербакова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 April 1980',true,false,'Рената','Тарасовна',false,'Власова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 March 1990',false,false,'Ника','Тарасовна',false,'Миронова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 February 1978',true,false,'Будимир','Олегович',true,'Дмитриев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 July 1988',false,false,'Август','Семенович',true,'Ичёткин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 November 1992',false,false,'Феоктист','Андреевич',true,'Константинов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 February 1981',false,false,'Татьяна','Виталиевна',false,'Герасимова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 June 1985',false,false,'Степан','Геннадьевич',true,'Воронин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 July 1985',false,false,'Мстислава','Валентиновна',false,'Тимофеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 January 1974',false,false,'Инга','Эдуардовна',false,'Зайцева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 January 1976',true,false,'Бронислава','Станиславовна',false,'Михайлова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 February 1991',false,false,'Ферапонт','Данилович',true,'Зеленов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 May 1964',false,false,'Афанасий','Геннадиевич',true,'Соловьёв');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('11 January 1995',false,false,'Клавдия','Даниловна',false,'Журавлёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 October 1985',true,false,'Елизар','Максович',true,'Лапин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 January 1969',false,false,'Панкрат','Александрович',true,'Кузнецов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 December 1985',false,false,'Любовь','Богдановна',false,'Трифонова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 September 1995',false,false,'Макар','Тимофеевич',true,'Новиков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 May 1973',false,false,'Милана','Павловна',false,'Кузнецова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 November 1978',false,false,'Григорий','Альбертович',true,'Давыдов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 December 1974',true,false,'Никанор','Юрьевич',true,'Журавлёв');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 April 1989',false,false,'Софон','Богданович',true,'Воронин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 March 1965',false,false,'Гедеон','Тимофеевич',true,'Попов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 June 1964',false,false,'Ульяна','Тимофеевна',false,'Щербакова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 March 1989',false,false,'Тимур','Эльдарович',true,'Власов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 January 1975',false,false,'Вячеслав','Тимофеевич',true,'Комаров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 January 1975',true,false,'Аникей','Филиппович',true,'Лебедев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 January 1995',true,false,'Фаина','Аркадьевна',false,'Тарская');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 June 1970',true,false,'Василиса','Егоровна',false,'Тихомирова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 October 1964',false,false,'Аполлинарий','Данилович',true,'Мартынов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 October 1966',false,false,'Варфоломей','Павлович',true,'Кудрявцев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 September 1968',true,false,'Григорий','Николаевич',true,'Ушаков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 February 1964',false,false,'Творимир','Федорович',true,'Кузнецов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 February 1969',false,false,'Алиса','Георгиевна',false,'Лобанова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 May 1974',false,false,'Сила','Станиславович',true,'Игнатьев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 November 1968',false,false,'Семён','Борисович',true,'Миронов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 May 1989',false,false,'Дмитрий','Михайлович',true,'Яковлев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 May 1986',false,false,'Олимпиада','Аркадьевна',false,'Константинова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 June 1988',false,false,'Лилия','Вячеславовна',false,'Тимофеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 December 1966',true,false,'Тимофей','Тимофеевич',true,'Крылов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 October 1984',false,false,'Милован','Эльдарович',true,'Васютин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 August 1990',false,false,'Алёна','Степановна',false,'Дмитриева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 July 1980',false,false,'Виргиния','Кирилловна',false,'Никитина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 March 1971',false,false,'Селиван','Николаевич',true,'Городнов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 April 1979',false,false,'Розалия','Тимофеевна',false,'Максимова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 December 1992',false,false,'Амвросий','Филиппович',true,'Охота');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 March 1978',false,false,'Тихон','Егорович',true,'Городнов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 April 1967',false,false,'Лидия','Даниловна',false,'Кулагина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 February 1990',true,false,'Елисей','Александрович',true,'Трифонов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 July 1994',true,false,'Любомира','Федоровна',false,'Соколова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 May 1967',true,false,'Аким','Борисович',true,'Вирский');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 November 1964',true,false,'Карп','Павлович',true,'Секунов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 October 1981',true,false,'Эвелина','Матвеевна',false,'Герасимова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 December 1982',false,false,'Лада','Даниловна',false,'Мамедова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 February 1980',true,false,'Никон','Константинович',true,'Лукерин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 June 1978',false,false,'Владилена','Ефимовна',false,'Лапина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 July 1979',true,false,'Маргарита','Юрьевна',false,'Муравьёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 July 1978',true,false,'Самсон','Давидович',true,'Егоров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 June 1990',true,false,'Владимир','Станиславович',true,'Пешнин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 April 1995',false,false,'Анфиса','Ивановна',false,'Муравьёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 November 1986',false,false,'Алиса','Виталиевна',false,'Демьянова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 June 1965',false,false,'Андоим','Леонидович',true,'Щербаков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 May 1983',false,false,'Чеслав','Святославович',true,'Фомин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 February 1978',false,false,'Эмма','Викторовна',false,'Прокофьева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 February 1969',true,false,'Надежда','Борисовна',false,'Ичёткина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 November 1965',true,false,'Изольда','Антоновна',false,'Кулагина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 November 1976',true,false,'Лиана','Максимовна',false,'Шершова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 December 1984',false,false,'Казимир','Михайлович',true,'Русов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 December 1978',false,false,'Васса','Юрьевна',false,'Иванова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 January 1977',true,false,'Вероника','Вячеславовна',false,'Дмитриева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 January 1967',false,false,'Марфа','Олеговна',false,'Кондратьева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 February 1973',true,false,'Маргарита','Богдановна',false,'Беляева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 June 1963',false,false,'Маргарита','Артемовна',false,'Стручкова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 August 1993',true,false,'Ксения','Ефимовна',false,'Морозова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 November 1977',false,false,'Вадим','Давидович',true,'Афанасьев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 May 1988',false,false,'Артемий','Леонидович',true,'Романов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 January 1976',false,false,'Арефий','Богданович',true,'Вирский');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 July 1989',false,false,'Спиридон','Станиславович',true,'Воронин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('5 August 1993',false,false,'Нона','Олеговна',false,'Шершова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 August 1995',false,false,'Самуил','Миронович',true,'Вихирев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 October 1985',false,false,'Михей','Викторович',true,'Гаврилов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 November 1993',true,false,'Изабелла','Владимировна',false,'Демьянченко');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 November 1975',false,false,'Ермил','Тарасович',true,'Васютин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 July 1963',true,false,'Харитон','Сергеевич',true,'Журавель');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 September 1981',false,false,'Мелитриса','Степановна',false,'Титова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 November 1987',true,false,'Аполлинария','Леонидовна',false,'Крылова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 March 1977',true,false,'Галина','Станиславовна',false,'Данилова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 November 1978',false,false,'Агафон','Васильевич',true,'Прокофьев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 June 1963',false,false,'Екатерина','Алексеевна',false,'Фомина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 March 1987',true,false,'Ангелина','Кирилловна',false,'Павлова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 October 1963',true,false,'Исидор','Максович',true,'Соловьёв');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 June 1988',false,false,'Ратибор','Тимурович',true,'Муравьев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 December 1987',true,false,'Екатерина','Егоровна',false,'Тимофеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 January 1987',true,false,'Милован','Васильевич',true,'Чаурин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 April 1963',true,false,'Устина','Валентиновна',false,'Сморчкова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 May 1967',true,false,'Ксения','Филипповна',false,'Алексеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 July 1995',false,false,'Всеволод','Ильич',true,'Львов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 July 1981',false,false,'Ксения','Евгеньевна',false,'Охота');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 December 1963',true,false,'Харитина','Егоровна',false,'Смирнова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 July 1974',false,false,'Агнесса','Антоновна',false,'Соболева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 October 1968',true,false,'Мария','Олеговна',false,'Морозова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 June 1992',true,false,'Клавдия','Матвеевна',false,'Сергеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 December 1986',false,false,'Леонид','Павлович',true,'Фролов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 September 1965',false,false,'Даниил','Вениаминович',true,'Андронов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 April 1965',false,false,'Арнольд','Вячеславович',true,'Леонтьев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 July 1967',true,false,'Фатина','Даниловна',false,'Чаурина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 February 1971',true,false,'Лазарь','Кириллович',true,'Алексеев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 August 1967',true,false,'Милен','Максович',true,'Попов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 July 1970',true,false,'Нина','Даниловна',false,'Иванова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 May 1966',false,false,'Леокадия','Владимировна',false,'Конягина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 November 1966',true,false,'Розалия','Федоровна',false,'Кулагина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 September 1981',false,false,'Лариса','Тарасовна',false,'Дидиченко');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 December 1981',false,false,'Боян','Васильевич',true,'Баранов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 December 1976',true,false,'Конкордия','Робертовна',false,'Морозова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 November 1993',true,false,'Роза','Юрьевна',false,'Воробьёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 November 1991',false,false,'Антип','Тарасович',true,'Козырев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 October 1991',true,false,'Горислава','Борисовна',false,'Фролова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 November 1963',true,false,'Берта','Михайловна',false,'Литвина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 November 1978',true,false,'Филипп','Данилович',true,'Гаврилов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 June 1968',true,false,'Викентий','Денисович',true,'Скачков');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('12 December 1989',false,false,'Мартьян','Максович',true,'Шульц');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 August 1964',true,false,'Саломея','Егоровна',false,'Попова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 May 1965',true,false,'Карп','Тарасович',true,'Городнов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 September 1978',true,false,'Агния','Иосифовна',false,'Остимчук');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 December 1966',true,false,'Доминика','Львовна',false,'Захарова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 September 1983',false,false,'Анисим и Онисим','Константинович',true,'Сидоров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 July 1991',true,false,'Тереза','Ефимовна',false,'Фролова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 October 1968',false,false,'Сильвия','Григорьевна',false,'Киселёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 February 1987',false,false,'Клавдий','Антонович',true,'Рощин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 May 1968',false,false,'Бронислав','Георгиевич',true,'Назаров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('23 May 1990',false,false,'Флорентина','Валентиновна',false,'Арджеванидзе ');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 December 1994',false,false,'Болеслав','Валерьевич',true,'Власов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('2 November 1979',true,false,'Вячеслав','Богданович',true,'Сысолятин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('22 April 1971',false,false,'Никифор','Эльдарович',true,'Зайцев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('9 January 1988',false,false,'Клара','Станиславовна',false,'Гусева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 July 1968',true,false,'Святослав','Ильич',true,'Кравченко');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 May 1978',true,false,'Валерий','Филиппович',true,'Романов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 February 1995',true,false,'Дина','Семеновна',false,'Алексеева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 October 1980',false,false,'Екатерина','Михайловна',false,'Львова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('21 August 1987',true,false,'Борис','Валерьевич',true,'Осипов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 August 1995',true,false,'Прасковья','Ивановна',false,'Ичёткина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 February 1984',false,false,'Виссарион','Аркадьевич',true,'Игнатьев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 December 1964',true,false,'Прокофий','Евгеньевич',true,'Романов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 July 1990',false,false,'Анастасия','Степановна',false,'Иванова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 September 1995',false,false,'Эвелина','Валентиновна',false,'Сорокина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 June 1965',true,false,'Любомила','Виталиевна',false,'Арджеванидзе ');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 May 1967',true,false,'Анастасия','Тарасовна',false,'Чапко');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 June 1966',false,false,'Карп','Денисович',true,'Романов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 August 1967',true,false,'Анастасия','Анатольевна',false,'Веселкова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 April 1985',true,false,'Виргиния','Богдановна',false,'Воронина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('24 November 1980',true,false,'Всеслава','Иосифовна',false,'Васютина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 February 1969',false,false,'Сила','Тимофеевич',true,'Шульц');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 December 1971',false,false,'Артем','Олегович',true,'Леонтьев');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 December 1981',false,false,'Владислав','Михайлович',true,'Фролов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('4 December 1977',true,false,'Сильвия','Геннадиевна',false,'Зайцева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 August 1976',true,false,'Изяслав','Дмитриевич',true,'Ильин');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 June 1991',true,false,'Аграфена','Анатольевна',false,'Данилова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('3 November 1988',true,false,'Эвелина','Вячеславовна',false,'Попова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 April 1993',false,false,'Милена','Максимовна',false,'Ильина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('7 February 1990',true,false,'Милена','Викторовна',false,'Холодкова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('27 January 1986',true,false,'Елена','Матвеевна',false,'Савельева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 March 1979',true,false,'Станислав','Тарасович',true,'Морозов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 August 1973',false,false,'Валентин','Максович',true,'Смирнов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('8 March 1988',false,false,'Нестор','Владимирович',true,'Крылов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 June 1969',false,false,'Августа','Владиславовна',false,'Волкова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('26 November 1963',true,false,'Доминика','Романовна',false,'Попова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('13 January 1968',false,false,'Лиана','Яковлевна',false,'Кузнецова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 July 1993',true,false,'Любомир','Альбертович',true,'Андронов');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('25 November 1969',true,false,'Эльвира','Федоровна',false,'Гусева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('18 August 1982',true,false,'Тимур','Николаевич',true,'Шмидт');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('11 April 1995',false,false,'Архип','Георгиевич',true,'Петров');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('6 June 1986',false,false,'Валентина','Антоновна',false,'Воронец');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('1 April 1981',true,false,'Сильвия','Александровна',false,'Демьянченко');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('16 October 1975',true,false,'Олимпиада','Алексеевна',false,'Осипова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('17 January 1992',false,false,'Мирослава','Анатольевна',false,'Пономарёва');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('14 November 1974',true,false,'Розина','Евгеньевна',false,'Тюрина');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 November 1987',true,false,'Софья','Николаевна',false,'Ефимова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 October 1967',true,false,'Наталья','Ярославовна',false,'Андреева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('19 July 1984',true,false,'Элеонора','Андреевна',false,'Зеленова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('28 February 1978',true,false,'Агриппина','Виталиевна',false,'Степанова');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('10 June 1982',true,false,'Аскольд','Валентинович',true,'Усачёв');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('20 December 1988',false,false,'Василиса','Филипповна',false,'Яковлева');
insert into persons (born_date, is_criminal, is_fake, name, patronymic, sex, surname) values ('15 April 1975',true,false,'Петр','Павлович',true,'Воробьёв');

--Roles
insert into roles (role) values ('user');
insert into roles (role) values ('google');
insert into roles (role) values ('vk');

--Regions
insert into regions (city, country, continent, planet) values (null, null, null, 'Земля');
insert into regions (city, country, continent, planet) values (null, null, null, 'Луна');
----continents
insert into regions (city, country, continent, planet) values (null, null, 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, null, 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, null, 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, null, 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, null, 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, null, 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, null, 'Антарктида', 'Земля');

----Страны Австралии
insert into regions (city, country, continent, planet) values (null, 'Австралия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Соломоновы острова', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Фиджи', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Новая Зеландия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Маршалловы острова', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Новая Гвинея', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Палау', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Самоа', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Тонга', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Тувалу', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Науру', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Вануату', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Микронезия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Кирибати', 'Австралия', 'Земля');

----Страны Африки
insert into regions (city, country, continent, planet) values (null, 'Алжир', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Египет', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Камерун', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Кения', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Конго', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Маврикий', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Уганда', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Сомали', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Тунис', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Эфиопия', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'ЮАР', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Мадагаскар', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Нигер', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Чад', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Либерия', 'Африка', 'Земля');

----Страны Северной Америки
insert into regions (city, country, continent, planet) values (null, 'США', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Канада', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Куба', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Коста-Рика', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Белиз', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Мексика', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Панама', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Ямайка', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Сальвадор', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Никарагуа', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Гондурас', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Гватемала', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Гаити', 'Северная Америка', 'Земля');

----Страны Южной Америки
insert into regions (city, country, continent, planet) values (null, 'Аргентина', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Уругвай', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Чили', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Колумбия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Гайана', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Бразилия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Венесуэла', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Парагвай', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Перу', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Эквадор', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Суринам', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Боливия', 'Южная Америка', 'Земля');

----Страны Европы
insert into regions (city, country, continent, planet) values (null, 'Австрия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Белоруссия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Бельгия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Болгария', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Словакия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Венгрия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Германия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Греция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Дания', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Исландия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Испания', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Италия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Польша', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Португалия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Украина', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Финляндия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Франция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Хорватия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Чехия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Швейцария', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Швеция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Россия', 'Европа', 'Земля');

----Страны Азии
insert into regions (city, country, continent, planet) values (null, 'Азербайджан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Армения', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Афганистан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Вьетнам', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Грузия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Израиль', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Индия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Индонезия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Ирак', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Иран', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Казахстан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Кипр', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Китай', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Северная Корея', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Южная Корея', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'ОАЭ', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Монголия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Филиппины', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Япония', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Турция', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Узбекистан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values (null, 'Шри-Ланка', 'Азия', 'Земля');

----Города Австралии
insert into regions (city, country, continent, planet) values ('Аделаида', 'Австралия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Брисбен', 'Австралия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Перт', 'Австралия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Сидней', 'Австралия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Канберра', 'Австралия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Мельбурн', 'Австралия', 'Австралия', 'Земля');

insert into regions (city, country, continent, planet) values ('Хониара', 'Соломоновы острова', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Ауки', 'Соломоновы острова', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Буала', 'Соломоновы острова', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Норо', 'Соломоновы острова', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Мунда', 'Соломоновы острова', 'Австралия', 'Земля');

insert into regions (city, country, continent, planet) values ('Сува', 'Фиджи', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Нанди', 'Фиджи', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Лаутока', 'Фиджи', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Ламбаса', 'Фиджи', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Наусори', 'Фиджи', 'Австралия', 'Земля');

insert into regions (city, country, continent, planet) values ('Окленд', 'Новая Зеландия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Веллингтон', 'Новая Зеландия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Данидин', 'Новая Зеландия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Крайстчерч', 'Новая Зеландия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Гимильтон', 'Новая Зеландия', 'Австралия', 'Земля');

insert into regions (city, country, continent, planet) values ('Южная Тарава', 'Кирибати', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Табурао', 'Кирибати', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Бонрики', 'Кирибати', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Буарики', 'Кирибати', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Темарая', 'Кирибати', 'Австралия', 'Земля');

insert into regions (city, country, continent, planet) values ('Лаэ', 'Новая Гвинея', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Горока', 'Новая Гвинея', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Маданг', 'Новая Гвинея', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Менди', 'Новая Гвинея', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Тари', 'Новая Гвинея', 'Австралия', 'Земля');

insert into regions (city, country, continent, planet) values ('Клоулклабед', 'Палау', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Корор', 'Палау', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Хатохобеи', 'Палау', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Мелекеок', 'Палау', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Мейнгс', 'Палау', 'Австралия', 'Земля');

insert into regions (city, country, continent, planet) values ('Апиа', 'Самоа', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Афега', 'Самоа', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Вайусу', 'Самоа', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Солосоло', 'Самоа', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Леулумоега', 'Самоа', 'Австралия', 'Земля');

insert into regions (city, country, continent, planet) values ('Неиафу', 'Тонга', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Пангаи', 'Тонга', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Вайни', 'Тонга', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Муа', 'Тонга', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Коловаи', 'Тонга', 'Австралия', 'Земля');

insert into regions (city, country, continent, planet) values ('Тонга', 'Тувалу', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Ваиаку', 'Тувалу', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Фонгафале', 'Тувалу', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Фунафути', 'Тувалу', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Тавита', 'Тувалу', 'Австралия', 'Земля');

insert into regions (city, country, continent, planet) values ('Анабар', 'Науру', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Анибар', 'Науру', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Ярен', 'Науру', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Баити', 'Науру', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Арубо', 'Науру', 'Австралия', 'Земля');

insert into regions (city, country, continent, planet) values ('Порт-Вила', 'Вануату', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Исангел', 'Вануату', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Сола', 'Вануату', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Люганвиль', 'Вануату', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Лакаторо', 'Вануату', 'Австралия', 'Земля');

insert into regions (city, country, continent, planet) values ('Паликир', 'Микронезия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Колониа', 'Микронезия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Тофол', 'Микронезия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Вено', 'Микронезия', 'Австралия', 'Земля');
insert into regions (city, country, continent, planet) values ('Румунг', 'Микронезия', 'Австралия', 'Земля');

----Города Африки
insert into regions (city, country, continent, planet) values ('Алжир', 'Алжир', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Таманрассет', 'Алжир', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Тлемсен', 'Алжир', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Батна', 'Алжир', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Тимга', 'Алжир', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Каир', 'Египет', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Хургада', 'Египет', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Луксор', 'Египет', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Шарм-эль-Шейх', 'Египет', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Дахаб', 'Египет', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Дуала', 'Камерун', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Гаруа', 'Камерун', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Криби', 'Камерун', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Яунде', 'Камерун', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Буэа', 'Камерун', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Найроби', 'Кения', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Момбаса', 'Кения', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Малинди', 'Кения', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Накуру', 'Кения', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Кисуму', 'Кения', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Киншаса', 'Конго', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Браззавиль', 'Конго', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Бома', 'Конго', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Матади', 'Конго', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Букаву', 'Конго', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Порт-Луи', 'Маврикий', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Гран Бэ', 'Маврикий', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Кюрпип', 'Маврикий', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Роз-Хилл', 'Маврикий', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Маэбур', 'Маврикий', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Кампала', 'Уганда', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Энтеббе', 'Уганда', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Джинджа', 'Уганда', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Мбале', 'Уганда', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Гулу', 'Уганда', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Магадишо', 'Сомали', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Кисмайо', 'Сомали', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Босасо', 'Сомали', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Байдабо', 'Сомали', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Буръо', 'Сомали', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Тунис', 'Тунис', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Сус', 'Тунис', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Монастир', 'Тунис', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Хаммамет', 'Тунис', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Кайруан', 'Тунис', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Аддис-Абеба', 'Эфиопия', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Гондэр', 'Эфиопия', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Бахр-Дар', 'Эфиопия', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Харар', 'Эфиопия', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Дире Дауа', 'Эфиопия', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Кейптаун', 'ЮАР', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Дурбан', 'ЮАР', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Претория', 'ЮАР', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Кимберли', 'ЮАР', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Найсна', 'ЮАР', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Антананариву', 'Мадагаскар', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Мурундава', 'Мадагаскар', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Туамасина', 'Мадагаскар', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Махадзанга', 'Мадагаскар', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Тулеар', 'Мадагаскар', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Ниабей', 'Нигер', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Зиндер', 'Нигер', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Арлит', 'Нигер', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Агадес', 'Нигер', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Тахуа', 'Нигер', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Нджамена', 'Чад', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Абеше', 'Чад', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Мунду', 'Чад', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Пала', 'Чад', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Сарх', 'Чад', 'Африка', 'Земля');

insert into regions (city, country, continent, planet) values ('Монровия', 'Либерия', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Харпер', 'Либерия', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Бьюкенен', 'Либерия', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Гринвилл', 'Либерия', 'Африка', 'Земля');
insert into regions (city, country, continent, planet) values ('Воинджама', 'Либерия', 'Африка', 'Земля');

----Города Северной Америки
insert into regions (city, country, continent, planet) values ('Майами', 'США', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Нью-Йорк', 'США', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Вашингтон', 'США', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Чикаго', 'США', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Лас-Вегас', 'США', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Лос-Анджелес', 'США', 'Северная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Торонто', 'Канада', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Монреаль', 'Канада', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Ванкувер', 'Канада', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Калгари', 'Канада', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Оттава', 'Канада', 'Северная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Гавана', 'Куба', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Варадеро', 'Куба', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Сантьяго де Куба', 'Куба', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Ольгин', 'Куба', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Тринидад', 'Куба', 'Северная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Сан-Хосе', 'Коста-Рика', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Лимон', 'Коста-Рика', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Картаго', 'Коста-Рика', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Хако', 'Коста-Рика', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Тамариндо', 'Коста-Рика', 'Северная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Белиз', 'Белиз', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Бельмопан', 'Белиз', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Сан Педро', 'Белиз', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Дангрига', 'Белиз', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Сан-Игнасио', 'Белиз', 'Северная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Мехико', 'Мексика', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Канкун', 'Мексика', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Акапулько', 'Мексика', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Меридо', 'Мексика', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Гвадалахара', 'Мексика', 'Северная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Панама', 'Панама', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Токумен', 'Панама', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Колон', 'Панама', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Панама-Сити', 'Панама', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Читре', 'Панама', 'Северная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Кингстон', 'Ямайка', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Око Риос', 'Ямайка', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Негрил', 'Ямайка', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Монтего-Бей', 'Ямайка', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Порт-Антонио', 'Ямайка', 'Северная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Сан-Сальвадор', 'Сальвадор', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Сан-Мигель', 'Сальвадор', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Санта-Текла', 'Сальвадор', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Дельгадо', 'Сальвадор', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Илопанго', 'Сальвадор', 'Северная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Манагуа', 'Никарагуа', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Гранада', 'Никарагуа', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Масая', 'Никарагуа', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Блуфилдс', 'Никарагуа', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Эстели', 'Никарагуа', 'Северная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Тегусигальпа', 'Гондурас', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Ла-Сейба', 'Гондурас', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Сан-Педро-Сула', 'Гондурас', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Комаягуа', 'Гондурас', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Чолутека', 'Гондурас', 'Северная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Гватемала', 'Гватемала', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Антигуа', 'Гватемала', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Петен', 'Гватемала', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Кобан', 'Гватемала', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Кесальтенанго', 'Гватемала', 'Северная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Ле Гонаив', 'Гаити', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Кап-Аитьен', 'Гаити', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Порт-о-Пренс', 'Гаити', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Аррондисман де Жакмель', 'Гаити', 'Северная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Ле-Ке', 'Гаити', 'Северная Америка', 'Земля');


----Города Южной Америки
insert into regions (city, country, continent, planet) values ('Буэнос-Айрес', 'Аргентина', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Сальта', 'Аргентина', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Росарио', 'Аргентина', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Ушуая', 'Аргентина', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Мар-дель-Плата', 'Аргентина', 'Южная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Монтевидео', 'Уругвай', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Сальто', 'Уругвай', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Пириаполис', 'Уругвай', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Лас-Пьедрас', 'Уругвай', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Минас', 'Уругвай', 'Южная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Сантьяго', 'Чили', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Икике', 'Чили', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Вальпараисо', 'Чили', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Консепсьон', 'Чили', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Арика', 'Чили', 'Южная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Богота', 'Колумбия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Кали', 'Колумбия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Медельин', 'Колумбия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Картахена', 'Колумбия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Санта-Марта', 'Колумбия', 'Южная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Линден', 'Гайана', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Джорджтаун', 'Гайана', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Бартика', 'Гайана', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Летем', 'Гайана', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Нью Амстердам', 'Гайана', 'Южная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Бразилиа', 'Бразилия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Рио-де-Жанейро', 'Бразилия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Сальвадор', 'Бразилия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Манаус', 'Бразилия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Ресифи', 'Бразилия', 'Южная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Каракас', 'Венесуэла', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Коро', 'Венесуэла', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Маракайбо', 'Венесуэла', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Валенсия', 'Венесуэла', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Баркисимето', 'Венесуэла', 'Южная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Асунсьон', 'Парагвай', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Итаугу', 'Парагвай', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Энкарнасьон', 'Парагвай', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Сьюдад-дель-Эсте', 'Парагвай', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Луке', 'Парагвай', 'Южная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Лима', 'Перу', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Куско', 'Перу', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Икитос', 'Перу', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Арекипа', 'Перу', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Пуно', 'Перу', 'Южная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Кито', 'Эквадор', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Манта', 'Эквадор', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Баньос', 'Эквадор', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Куэнка', 'Эквадор', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Гуаякиль', 'Эквадор', 'Южная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Лелидорп', 'Суринам', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Парамарибо', 'Суринам', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Ньив-Неккери', 'Суринам', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Албина', 'Суринам', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Мунго', 'Суринам', 'Южная Америка', 'Земля');

insert into regions (city, country, continent, planet) values ('Ла-Пас', 'Боливия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Сукре', 'Боливия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Потоси', 'Боливия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Кочабамба', 'Боливия', 'Южная Америка', 'Земля');
insert into regions (city, country, continent, planet) values ('Оруро', 'Боливия', 'Южная Америка', 'Земля');

----Города Европы
insert into regions (city, country, continent, planet) values ('Вена', 'Австрия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Грац', 'Австрия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Линц', 'Австрия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Зальцбург', 'Австрия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Баден', 'Австрия', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Минск', 'Белоруссия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Брест', 'Белоруссия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Гомель', 'Белоруссия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Могилев', 'Белоруссия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Витебск', 'Белоруссия', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Брюссель', 'Бельгия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Гент', 'Бельгия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Лювен', 'Бельгия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Брюгге', 'Бельгия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Антверпен', 'Бельгия', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Варна', 'Болгария', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('София', 'Болгария', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Пловдив', 'Болгария', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Несебыр', 'Болгария', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Бургас', 'Болгария', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Братислава', 'Словакия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Кошице', 'Словакия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Попрад', 'Словакия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Прешов', 'Словакия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Нитра', 'Словакия', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Будапешт', 'Венгрия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Дебрецен', 'Венгрия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Печ', 'Венгрия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Эгер', 'Венгрия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Хевиз', 'Венгрия', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Берлин', 'Германия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Мюнхен', 'Германия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Гамбург', 'Германия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Дюссельдорф', 'Германия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Кёльн', 'Германия', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Афины', 'Греция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Коринф', 'Греция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Ираклион', 'Греция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Салоники', 'Греция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Ретимно', 'Греция', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Копенгаген', 'Дания', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Оденсе', 'Дания', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Орхус', 'Дания', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Ольбург', 'Дания', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Роскилле', 'Дания', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Рейкьявик', 'Исландия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Акурейри', 'Исландия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Сельфосс', 'Исландия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Акранес', 'Исландия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Исафьордюр', 'Исландия', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Барселона', 'Испания', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Мадрид', 'Испания', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Севилья', 'Испания', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Пальма', 'Испания', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Гранада', 'Испания', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Рим', 'Италия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Флоренция', 'Италия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Венеция', 'Италия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Милан', 'Италия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Неаполь', 'Италия', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Варшава', 'Польша', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Краков', 'Польша', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Гданьск', 'Польша', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Врослав', 'Польша', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Познань', 'Польша', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Лиссабон', 'Португалия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Порту', 'Португалия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Синтра', 'Португалия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Коимбра', 'Португалия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Эвора', 'Португалия', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Киев', 'Украина', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Львов', 'Украина', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Харьков', 'Украина', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Одесса', 'Украина', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Чернигов', 'Украина', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Хельсинки', 'Финляндия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Турку', 'Финляндия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Тампере', 'Финляндия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Иматра', 'Финляндия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Порвоо', 'Финляндия', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Париж', 'Франция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Марсель', 'Франция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Ницца', 'Франция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Канны', 'Франция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Тулуза', 'Франция', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Загреб', 'Хорватия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Пула', 'Хорватия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Пореч', 'Хорватия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Сплит', 'Хорватия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Дубровник', 'Хорватия', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Прага', 'Чехия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Брно', 'Чехия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Пльзень', 'Чехия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Острава', 'Чехия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Либерец', 'Чехия', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Цюрих', 'Швейцария', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Женева', 'Швейцария', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Базель', 'Швейцария', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Лозанна', 'Швейцария', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Лугано', 'Швейцария', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Стокгольм', 'Швеция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Мальмё', 'Швеция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Гётеборг', 'Швеция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Уппсала', 'Швеция', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Лунд', 'Швеция', 'Европа', 'Земля');

insert into regions (city, country, continent, planet) values ('Москва', 'Россия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Санкт-Петербург', 'Россия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Самара', 'Россия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Казань', 'Россия', 'Европа', 'Земля');
insert into regions (city, country, continent, planet) values ('Екатеринбург', 'Россия', 'Европа', 'Земля');

----Города Азии
insert into regions (city, country, continent, planet) values ('Баку', 'Азербайджан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Гянджа', 'Азербайджан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Шеки', 'Азербайджан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Сумгаит', 'Азербайджан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Нахичевань', 'Азербайджан', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Ереван', 'Армения', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Гюмри', 'Армения', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Джермук', 'Армения', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Ванадзор', 'Армения', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Джермук', 'Армения', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Кабул', 'Афганистан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Герат', 'Афганистан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Кандагар', 'Афганистан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Джелалабад', 'Афганистан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Газни', 'Афганистан', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Ханой', 'Вьетнам', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Нячанг', 'Вьетнам', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Хошимин', 'Вьетнам', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Дананг', 'Вьетнам', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Хюэ', 'Вьетнам', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Тбилиси', 'Грузия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Батуми', 'Грузия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Кутаиси', 'Грузия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Мцхета', 'Грузия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Боржоми', 'Грузия', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Иерусалим', 'Израиль', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Тель-Авив', 'Израиль', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Хайфа', 'Израиль', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Эйлат', 'Израиль', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Нетания', 'Израиль', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Мумбаи', 'Индия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Агра', 'Индия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Кулькутта', 'Индия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Джайпур', 'Индия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Варанаси', 'Индия', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Джакарта', 'Индонезия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Сурабая', 'Индонезия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Бандунг', 'Индонезия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Денпасар', 'Индонезия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Кута', 'Индонезия', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Багдад', 'Ирак', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Мосул', 'Ирак', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Басра', 'Ирак', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Киркук', 'Ирак', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Эрбиль', 'Ирак', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Тегеран', 'Иран', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Шираз', 'Иран', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Йезд', 'Иран', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Мешхед', 'Иран', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Эсфахан', 'Иран', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Астана', 'Казахстан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Алматы', 'Казахстан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Караганда', 'Казахстан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Павлодар', 'Казахстан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Шымкент', 'Казахстан', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Пафос', 'Кипр', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Никоссия', 'Кипр', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Ларнака', 'Кипр', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Лимассол', 'Кипр', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Полис', 'Кипр', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Пекин', 'Китай', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Шанхай', 'Китай', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Тяньжин', 'Китай', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Гуанчжоу', 'Китай', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Сиань', 'Китай', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Пхеньян', 'Северная Корея', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Кэсон', 'Северная Корея', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Вонсан', 'Северная Корея', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Раджин', 'Северная Корея', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Хамхын', 'Северная Корея', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Сеул', 'Южная Корея', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Дэгу', 'Южная Корея', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Бусан', 'Южная Корея', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Инчон', 'Южная Корея', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Кёнджу', 'Южная Корея', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Дубай', 'ОАЭ', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Абу-Даби', 'ОАЭ', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Шарджа', 'ОАЭ', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Аджман', 'ОАЭ', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Эль-Айн', 'ОАЭ', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Улан-Батор', 'Монголия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Дархан', 'Монголия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Ховд', 'Монголия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Эрдэнэт', 'Монголия', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Хархорин', 'Монголия', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Манила', 'Филиппины', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Себу', 'Филиппины', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Давао', 'Филиппины', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Макати', 'Филиппины', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Багио', 'Филиппины', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Токио', 'Япония', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Осака', 'Япония', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Киото', 'Япония', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Саппоро', 'Япония', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Хиросима', 'Япония', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Стумбул', 'Турция', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Сиде', 'Турция', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Аланья', 'Турция', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Анталья', 'Турция', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Анкара', 'Турция', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Ташкент', 'Узбекистан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Бухара', 'Узбекистан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Хива', 'Узбекистан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Фергана', 'Узбекистан', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Самарканд', 'Узбекистан', 'Азия', 'Земля');

insert into regions (city, country, continent, planet) values ('Коломбо', 'Шри-Ланка', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Канди', 'Шри-Ланка', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Галле', 'Шри-Ланка', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Шри-Джаяварденепура-Котте', 'Шри-Ланка', 'Азия', 'Земля');
insert into regions (city, country, continent, planet) values ('Негомбо', 'Шри-Ланка', 'Азия', 'Земля');
