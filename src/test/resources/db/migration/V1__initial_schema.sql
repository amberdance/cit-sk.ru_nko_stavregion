DROP TABLE IF EXISTS organizations;
DROP TABLE IF EXISTS support_forms;

CREATE TABLE organization
(
    id                    SERIAL PRIMARY KEY,
    register_date         DATE         NOT NULL,
    name                  VARCHAR(256) NOT NULL,
    address               VARCHAR(256) NOT NULL,
    ogrn                  VARCHAR(16)  NOT NULL,
    inn                   VARCHAR(16)  NOT NULL,
    okvd                  VARCHAR(16)  NOT NULL,
    violation_information VARCHAR(1024)
);

CREATE TABLE support_form
(
    organization INTEGER PRIMARY KEY REFERENCES organization (id),
    support_date DATE         NOT NULL,
    name         VARCHAR(256) NOT NULL,
    size         VARCHAR(32)  NOT NULL,
    target       VARCHAR(256) NOT NULL,
    period       VARCHAR(32)
);
