package com.hugo.quiz.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserAlreadyExistsException extends ResponseStatusException {

    public UserAlreadyExistsException(){
        super(HttpStatus.BAD_REQUEST, "Already exists a user whit the given email");
    }

    public UserAlreadyExistsException(String message){
        super(HttpStatus.BAD_REQUEST, message);
    }

}
