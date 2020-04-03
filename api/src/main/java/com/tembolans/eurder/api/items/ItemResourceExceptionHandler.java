package com.tembolans.eurder.api.items;

import com.tembolans.eurder.domain.items.exceptions.InvalidPriceException;
import com.tembolans.eurder.domain.items.exceptions.SameItemNameException;
import com.tembolans.eurder.domain.users.exceptions.InvalidEmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ItemResourceExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(InvalidPriceException.class)
    protected void invalidEmailException(InvalidPriceException exception, HttpServletResponse response) throws IOException {
        LOGGER.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(SameItemNameException.class)
    protected void invalidEmailException(SameItemNameException exception, HttpServletResponse response) throws IOException {
        LOGGER.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }


}
