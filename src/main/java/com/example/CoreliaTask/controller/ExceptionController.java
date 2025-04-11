package com.example.CoreliaTask.controller;

import com.example.CoreliaTask.dto.RespnseMessage;
import com.example.CoreliaTask.exception.BadRequestException;
import com.example.CoreliaTask.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    ResponseEntity<RespnseMessage> handelException(NotFoundException notFoundException){
        RespnseMessage errorMessage=new RespnseMessage();
        errorMessage.setMessage(notFoundException.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<RespnseMessage> handelException(BadRequestException badRequestException){
        RespnseMessage errorMessage=new RespnseMessage();
        errorMessage.setMessage(badRequestException.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> myMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> response = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(err -> {
            String fieldName = ((FieldError) err).getField();
            String message = err.getDefaultMessage();
            response.put(fieldName, message);
        });
        return new ResponseEntity<Map<String, String>>(response,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<RespnseMessage> handelException(RuntimeException e){
        RespnseMessage errorMessage=new RespnseMessage();
        errorMessage.setMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }



}
