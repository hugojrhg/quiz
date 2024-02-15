package com.hugo.quiz.exception.quiz;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class QuizNotFoundException extends ResponseStatusException {

    public QuizNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Not exist a quiz with this id.");
    }

    public QuizNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

}
