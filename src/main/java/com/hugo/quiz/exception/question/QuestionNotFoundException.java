package com.hugo.quiz.exception.question;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class QuestionNotFoundException extends ResponseStatusException {

    public QuestionNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Not exist a question with this id.");
    }

    public QuestionNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

}
