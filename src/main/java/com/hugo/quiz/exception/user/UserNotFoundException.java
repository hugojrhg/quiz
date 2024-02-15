package com.hugo.quiz.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {

    public UserNotFoundException(){
        super(HttpStatus.NOT_FOUND, "Not exist a user with this id.");
    }

    public UserNotFoundException(String message){
        super(HttpStatus.NOT_FOUND, message);
    }

}
