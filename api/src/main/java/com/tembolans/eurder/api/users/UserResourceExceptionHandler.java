package com.tembolans.eurder.api.users;

import com.tembolans.eurder.domain.users.exceptions.AlreadyUsedException;
import com.tembolans.eurder.domain.users.exceptions.InvalidEmailException;
import com.tembolans.eurder.domain.users.exceptions.InvalidPhoneNumberException;
import com.tembolans.eurder.domain.users.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class UserResourceExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(InvalidEmailException.class)
    protected void invalidEmailException(InvalidEmailException exception, HttpServletResponse response) throws IOException {
        LOGGER.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(InvalidPhoneNumberException.class)
    protected void invalidPhoneNumberException(InvalidEmailException exception, HttpServletResponse response) throws IOException {
        LOGGER.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    protected void userNotFoundException(UserNotFoundException exception, HttpServletResponse response) throws IOException {
        LOGGER.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(AlreadyUsedException.class)
    protected void userNotFoundException(AlreadyUsedException exception, HttpServletResponse response) throws IOException {
        LOGGER.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

}
