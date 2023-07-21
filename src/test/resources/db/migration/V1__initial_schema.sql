DROP TABLE IF EXISTS organizations;
DROP TABLE IF EXISTS support_forms;

CREATE TABLE organization
(
    id                    SERIAL PRIMARY KEY,
    name                  VARCHAR(256),
    address               VARCHAR(256),
    ogrn                  VARCHAR(16),
    inn                   VARCHAR(16),
    okvd                  VARCHAR(16),
    violation_information VARCHAR(1024)
);

CREATE TABLE support_form
(
    organization INTEGER PRIMARY KEY REFERENCES organization (id),
    name          VARCHAR(256),
    size          VARCHAR(32),
    period        VARCHAR(32),
    target        VARCHAR(256)
);
