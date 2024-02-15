package com.hugo.quiz.exception.player;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PlayerNotFoundException extends ResponseStatusException {

    public PlayerNotFoundException(){
        super(HttpStatus.NOT_FOUND, "Not exist a player with this id.");
    }

    public PlayerNotFoundException(String message){
        super(HttpStatus.NOT_FOUND, message);
    }

}
