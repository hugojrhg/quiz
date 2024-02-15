package com.hugo.quiz.exception.alternative;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AlternativeNotFoundException extends ResponseStatusException {

    public AlternativeNotFoundException(){
        super(HttpStatus.NOT_FOUND, "Not exist a alternative with this id.");
    }

    public AlternativeNotFoundException(String message){
        super(HttpStatus.NOT_FOUND, message);
    }

}
