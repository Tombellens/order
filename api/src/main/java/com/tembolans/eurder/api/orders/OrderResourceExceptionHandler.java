package com.tembolans.eurder.api.orders;

import com.tembolans.eurder.domain.orders.exceptions.ItemNotFoundException;
import com.tembolans.eurder.domain.users.exceptions.InvalidEmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class OrderResourceExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(ItemNotFoundException.class)
    protected void invalidEmailException(ItemNotFoundException exception, HttpServletResponse response) throws IOException {
        LOGGER.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }
}
