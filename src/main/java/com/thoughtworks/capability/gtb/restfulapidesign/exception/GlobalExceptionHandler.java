package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentsNotExistException.class)
    public ResponseEntity<ErrorResult> handle(StudentsNotExistException ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.badRequest().body(errorResult);
    }

    @ExceptionHandler(TeamNotExistException.class)
    public ResponseEntity<ErrorResult> handleTeam(TeamNotExistException ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.badRequest().body(errorResult);
    }

    @ExceptionHandler(TeamNameIsExistException.class)
    public ResponseEntity<ErrorResult> handleTeamName(TeamNameIsExistException ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.ok().body(errorResult);
    }
}
