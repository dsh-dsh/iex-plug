package com.example.iexplug.controller;

import com.example.iexplug.dto.ErrorResponseDTO;
import com.example.iexplug.exception.WrongTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WrongTokenException.class)
    protected ResponseEntity<ErrorResponseDTO> handleBadRequestException(WrongTokenException ex) {
        return new ResponseEntity<>(new ErrorResponseDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
