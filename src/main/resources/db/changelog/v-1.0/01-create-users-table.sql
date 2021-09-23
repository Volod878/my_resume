CREATE TABLE my_resume_db.users (
                                    id BIGINT NOT NULL AUTO_INCREMENT,
                                    username VARCHAR (255) NOT NULL,
                                    password VARCHAR (255) NOT NULL,
                                    real_name VARCHAR (255),
                                    full_text VARCHAR (5000),
                                    PRIMARY KEY (id)
)

GO

INSERT INTO my_resume_db.users(username, password, real_name, full_text)
    VALUE ('Volod878', '$2a$10$gtuKrN0hgG9x3BCtZaMxjuDUdBkGWRp0U2lTR9uidpl/SnFClrZzS', 'Владимир',
    '<p>Изучал Java на JavaRush. <a href="https://javarush.ru/users/2317229">Мой профиль</a></p>
<p><a href="https://github.com/Volod878?tab=repositories">Мой GitHub репозиторий</a></p>
<br>
<h4>Мои проекты</h4>
<ul>
    <li>
        <a href="https://t.me/Volod878_bot">Телеграм-бот</a>
        <p>Бот может подписаться на <a href="https://javarush.ru/groups/all">статьи</a>
            сообщества JavaRush.
            После этого все новые статьи будут приходить в телеграм. Исходный код на Телеграм-бота на
            <a href="https://github.com/Volod878/volod_telegrambot">GitHub</a></p>
    </li>
    <li>
        <p>Конструктор модульных зданий <br>
            Проект в стадии разработки: Программа для автоматизированного расчета модульных зданий.
            Данная программа должна из заданных параметров определять все необходимые материалы для
            производства и общую стоимость по текущим расценкам</p>
    </li>
</ul>')

GO