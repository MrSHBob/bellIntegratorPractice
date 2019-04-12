CREATE TABLE IF NOT EXISTS docs (
    id                  BIGINT                  COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    code                INTEGER NOT NULL        COMMENT 'Kод документа',
    version             INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    name                VARCHAR(200)            COMMENT 'Название документа',
);

CREATE TABLE IF NOT EXISTS user_docs (
    id                  BIGINT                  COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    version             INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    user_id             BIGINT                  COMMENT 'Владелец документа',
    name                VARCHAR(200)            COMMENT 'Название документа',
    doc_code            INTEGER                 COMMENT 'Код документа',
    doc_number          VARCHAR(15)             COMMENT 'Серия и номер',
    doc_date            DATE                    COMMENT 'Выдан',
    is_identified       BIT                     COMMENT 'Документ подтвержден'
);

CREATE TABLE IF NOT EXISTS countries (
    id                  BIGINT                  COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    code                INTEGER NOT NULL        COMMENT 'Код страны',
    version             INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    name                VARCHAR(200)            COMMENT 'Название документа',
);

CREATE TABLE IF NOT EXISTS organization (
    id                  BIGINT                  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    name                VARCHAR(50)             COMMENT 'Название организации',
    full_name           VARCHAR(200)            COMMENT 'Полное название организации',
    inn                 VARCHAR(20)             COMMENT 'ИНН организации',
    kpp                 CHAR(9)                 COMMENT 'Код причины постановки на учет',
    address             VARCHAR(100)            COMMENT 'Адрес организации',
    phone               VARCHAR(15)             COMMENT 'Телефон организации',
    is_active           BIT                     COMMENT 'Показатель активности'
);
COMMENT ON TABLE organization IS 'Организация';

CREATE TABLE IF NOT EXISTS office (
    id                  BIGINT                  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    org_id              BIGINT NOT NULL         COMMENT 'идентификатор организации',
    name                VARCHAR(50)             COMMENT 'Название офиса',
    address             VARCHAR(100)            COMMENT 'Адрес офиса',
    phone               VARCHAR(15)             COMMENT 'Телефон офиса',
    is_active           BIT                     COMMENT 'Показатель активности'

);
COMMENT ON TABLE office IS 'Офис';

CREATE TABLE IF NOT EXISTS user (
    id                  BIGINT                  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    office_id           BIGINT NOT NULL         COMMENT 'Идентификатор офиса',
    first_name          VARCHAR(30) NOT NULL    COMMENT 'Имя',
    second_name         VARCHAR(30)             COMMENT 'Фамилия',
    middle_name         VARCHAR(30)             COMMENT 'Отчество',
    position            VARCHAR(50) NOT NULL    COMMENT 'Должность',
    phone               VARCHAR(15)             COMMENT 'Телефон юзера',
    citizenship_code    INTEGER                 COMMENT 'Гражданство - код'
);
COMMENT ON TABLE user IS 'Юзер';

CREATE INDEX IX_office_id ON office (org_id);
ALTER TABLE office ADD FOREIGN KEY (org_id) REFERENCES organization(id);

CREATE INDEX IX_user_docs ON user_docs (user_id);
ALTER TABLE user ADD FOREIGN KEY (user_id) REFERENCES user(id);

CREATE INDEX IX_user_office_id ON user (office_id);
ALTER TABLE user ADD FOREIGN KEY (office_id) REFERENCES office(id);
CREATE INDEX IX_user_citizenship_code ON user (citizenship_code);
ALTER TABLE user ADD FOREIGN KEY (citizenship_code) REFERENCES countries(code);
