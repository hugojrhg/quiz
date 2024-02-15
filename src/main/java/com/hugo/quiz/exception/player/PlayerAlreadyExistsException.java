package com.hugo.quiz.exception.player;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PlayerAlreadyExistsException extends ResponseStatusException {

    public PlayerAlreadyExistsException(){
        super(HttpStatus.BAD_REQUEST, "Already exists a player whit the given nickname");
    }

    public PlayerAlreadyExistsException(String message){
        super(HttpStatus.BAD_REQUEST, message);
    }

}
