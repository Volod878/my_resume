package ru.volod878.my_resume.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.volod878.my_resume.exception_handling.exception.NoSuchUserException;

/**
 * Класс-advice для управления исключениями
 */
@ControllerAdvice
public class UserGlobalExceptionHandler {

    /**
     * Если код валюты не корректный. Выбрасывается исключение NoSuchExchangeRatesException
     * и срабатывает этот метод.
     * @param exception который был выброшен
     * @return информационное сообщение об исключении
     */
    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handleException(NoSuchUserException exception) {

        UserIncorrectData data = new UserIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
