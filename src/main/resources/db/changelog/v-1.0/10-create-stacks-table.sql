CREATE TABLE my_resume_db.stacks (
                             id BIGINT NOT NULL AUTO_INCREMENT,
                             name VARCHAR (255) NOT NULL,
                             level VARCHAR (10) NOT NULL,
                             user_id BIGINT NOT NULL,
                             PRIMARY KEY (id),
                             FOREIGN KEY (user_id) REFERENCES my_resume_db.users(id)
)

GO

INSERT INTO my_resume_db.stacks(name, level, user_id)
    VALUES
    ('Java Core', 'high', 1),
    ('Spring', 'high', 1),
    ('ООП', 'high', 1),
    ('MySQL', 'high', 1),
    ('PostgreSQL', 'high', 1),
    ('Git', 'high', 1),
    ('GitHub', 'high', 1),
    ('Maven', 'high', 1),
    ('Gradle', 'high', 1),
    ('HTML, CSS', 'high', 1),
    ('JSON', 'high', 1),
    ('JSP', 'high', 1),
    ('JUnit', 'high', 1),
    ('JExcel API', 'high', 1),
    ('SpringBoot', 'low', 1),
    ('Flyway', 'low', 1),
    ('Liquibase', 'low', 1),
    ('Docker', 'low', 1),
    ('Android', 'low', 1),
    ('Jsoup', 'low', 1)

GO
