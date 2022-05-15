INSERT INTO public.author (birth_day, description, first_name, last_name, patronymic) VALUES (null, null, 'Михаил', 'Булгаков', 'Афанасьевич');
INSERT INTO public.author (birth_day, description, first_name, last_name, patronymic) VALUES (null, null, 'Николай', 'Гоголь', 'Васильевич');
INSERT INTO public.author (birth_day, description, first_name, last_name, patronymic) VALUES (null, null, 'Федор', 'Достоевский', 'Михайлович');
INSERT INTO public.author (birth_day, description, first_name, last_name, patronymic) VALUES (null, null, 'Лев', 'Толстой', 'Николаевич');

INSERT INTO public.book (description, name) VALUES (null, 'Мастер и Маргарита');
INSERT INTO public.book (description, name) VALUES (null, 'Собачье сердце');
INSERT INTO public.book (description, name) VALUES (null, 'Мёртвые души');
INSERT INTO public.book (description, name) VALUES (null, 'Ревизор');
INSERT INTO public.book (description, name) VALUES (null, 'Тарас Бульба');
INSERT INTO public.book (description, name) VALUES (null, 'Преступление и наказание');
INSERT INTO public.book (description, name) VALUES (null, 'Война и мир');
INSERT INTO public.book (description, name) VALUES (null, 'Анна Каренина');


INSERT INTO public.book_author (book_id, authors_id) VALUES (1, 1);
INSERT INTO public.book_author (book_id, authors_id) VALUES (2, 1);
INSERT INTO public.book_author (book_id, authors_id) VALUES (3, 2);
INSERT INTO public.book_author (book_id, authors_id) VALUES (4, 2);
INSERT INTO public.book_author (book_id, authors_id) VALUES (5, 2);
INSERT INTO public.book_author (book_id, authors_id) VALUES (6, 3);
INSERT INTO public.book_author (book_id, authors_id) VALUES (7, 4);
INSERT INTO public.book_author (book_id, authors_id) VALUES (8, 4);

INSERT INTO public.genre (name) VALUES ('рассказ');
INSERT INTO public.genre (name) VALUES ('поэма');
INSERT INTO public.genre (name) VALUES ('роман');
INSERT INTO public.genre (name) VALUES ('приключения');
