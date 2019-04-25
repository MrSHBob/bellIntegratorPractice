/*
INSERT INTO docs (code, version, name) VALUES (21, 0, 'Паспорт гражданина Российской Федерации');
INSERT INTO docs (code, version, name) VALUES (23, 0, 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');
INSERT INTO docs (code, version, name) VALUES (3, 0, 'Свидетельство о рождении');
INSERT INTO docs (code, version, name) VALUES (10, 0, 'Паспорт иностранного гражданина');

INSERT INTO countrie (code, version, name) VALUES (643, 0, 'Россия');
INSERT INTO countrie (code, version, name) VALUES (840, 0, 'США');
INSERT INTO countrie (code, version, name) VALUES (276, 0, 'Германия');
INSERT INTO countrie (code, version, name) VALUES (826, 0, 'Соединенное королевство');

INSERT INTO organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES (1, 0, 'Некая организация 1', 'организация ООО"Некая организация 1"', 1234567890, '1234AZ01', 'ул.Цюрупы, 16', 555555, 1);

INSERT INTO office (id, version, org_id, name, address, phone, is_active)
VALUES (1, 0, 1, 'офис 1', 'ул.Лунина, 7', 555555, 1);

INSERT INTO office (id, version, org_id, name, address, phone, is_active)
VALUES (2, 0, 1, 'офис 2', 'ул.Некоторая, 12', 666666, 1);

INSERT INTO user (
id, version, office_id, first_name, second_name, middle_name, position, phone, citizenship_id, is_identified
) VALUES (
1, 0, 1, 'Иван', 'Иванов', 'Иванович', 'менеджер', 9871231212, 1, 1);
INSERT INTO user (
id, version, office_id, first_name, second_name, middle_name, position, phone, citizenship_id, is_identified
) VALUES (
2, 0, 1, 'Петр', 'Петров', 'Петрович', 'менеджер', 9871234545, 1, 1);

INSERT INTO user_doc (
id, version, user_id, doc_id, doc_number, doc_date
) VALUES (
1, 0, 1, 1, '6303123123', DATE '2006-10-11'
);
INSERT INTO user_doc (
id, version, user_id, doc_id, doc_number, doc_date
) VALUES (
2, 0, 2, 1, '6303321321', DATE '2001-01-01'
);
*/
