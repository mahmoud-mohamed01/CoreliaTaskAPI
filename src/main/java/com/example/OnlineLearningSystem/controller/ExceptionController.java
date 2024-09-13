package com.example.OnlineLearningSystem.controller;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.exception.BadRequestException;
import com.example.OnlineLearningSystem.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

}
