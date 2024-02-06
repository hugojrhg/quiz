package com.hugo.quiz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class QuestionNotFoundException extends ResponseStatusException {

    public QuestionNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

}
