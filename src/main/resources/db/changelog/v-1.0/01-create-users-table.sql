CREATE TABLE my_resume_db.users (
                                    id INTEGER NOT NULL AUTO_INCREMENT,
                                    username VARCHAR (255) NOT NULL,
                                    password VARCHAR (255) NOT NULL,
                                    PRIMARY KEY (id)
)

GO

INSERT INTO my_resume_db.users(username, password)
    VALUE ('Volod878', '$2a$10$gtuKrN0hgG9x3BCtZaMxjuDUdBkGWRp0U2lTR9uidpl/SnFClrZzS')

GO