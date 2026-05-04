package com.turkcell.kutuphane_cqrs.exception;

import com.turkcell.kutuphane_cqrs.dto.ErrorResponse;
import com.turkcell.kutuphane_cqrs.dto.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBusinessException(BusinessException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    // ValidationErrorResponse için de benzer @ExceptionHandler ekleyebilirsin
}