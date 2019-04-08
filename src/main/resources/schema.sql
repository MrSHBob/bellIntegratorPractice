CREATE TABLE IF NOT EXISTS docs (
    code                INTEGER NOT NULL        COMMENT 'Уникальный идентификатор + код документа' PRIMARY KEY,
    version             INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    name                VARCHAR(200)            COMMENT 'Название документа',
);

CREATE TABLE IF NOT EXISTS countries (
    code                INTEGER NOT NULL        COMMENT 'Уникальный идентификатор + код документа' PRIMARY KEY,
    version             INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    name                VARCHAR(200)            COMMENT 'Название документа',
);

CREATE TABLE IF NOT EXISTS organization (
    id                  INTEGER                 COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    name                VARCHAR(50)             COMMENT 'Название организации',
    full_name           VARCHAR(200)            COMMENT 'Полное название организации',
    inn                 BIGINT                  COMMENT 'ИНН организации',
    kpp                 CHAR(9)                 COMMENT 'Код причины постановки на учет',
    address             VARCHAR(100)            COMMENT 'Адрес организации',
    phone               BIGINT                  COMMENT 'Телефон организации',
    is_active           BIT                     COMMENT 'Показатель активности'
);
COMMENT ON TABLE organization IS 'Организация';

CREATE TABLE IF NOT EXISTS office (
    id                  INTEGER                 COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    org_id              INTEGER NOT NULL        COMMENT 'идентификатор организации',
    name                VARCHAR(50)             COMMENT 'Название офиса',
    address             VARCHAR(100)            COMMENT 'Адрес офиса',
    phone               BIGINT                  COMMENT 'Телефон офиса',
    is_active           BIT                     COMMENT 'Показатель активности'

);
COMMENT ON TABLE office IS 'Офис';

CREATE TABLE IF NOT EXISTS user (
    id                  INTEGER                 COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    office_id           INTEGER NOT NULL        COMMENT 'Идентификатор офиса',
    first_name          VARCHAR(30) NOT NULL    COMMENT 'Имя',
    second_name         VARCHAR(30)             COMMENT 'Фамилия',
    middle_name         VARCHAR(30)             COMMENT 'Отчество',
    position            VARCHAR(50) NOT NULL    COMMENT 'Должность',
    phone               BIGINT                  COMMENT 'Телефон юзера',
    doc_code            INTEGER                 COMMENT 'Код документа',
    doc_number          BIGINT                  COMMENT 'Серия и номер',
    doc_date            DATE                    COMMENT 'Выдан',
    citizenship_code    INTEGER                 COMMENT 'Гражданство - код',
    is_identified       BIT                     COMMENT 'Идентифицированность. BIT {0, 1, null}'
);
COMMENT ON TABLE user IS 'Юзер';

ALTER TABLE office ADD FOREIGN KEY (org_id) REFERENCES organization(id);

ALTER TABLE user ADD FOREIGN KEY (office_id) REFERENCES office(id);
ALTER TABLE user ADD FOREIGN KEY (doc_code) REFERENCES docs(code);
ALTER TABLE user ADD FOREIGN KEY (citizenship_code) REFERENCES countries(code);
