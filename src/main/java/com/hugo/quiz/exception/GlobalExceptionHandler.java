package com.hugo.quiz.exception;

import com.hugo.quiz.exception.alternative.AlternativeNotFoundException;
import com.hugo.quiz.exception.player.PlayerAlreadyExistsException;
import com.hugo.quiz.exception.player.PlayerNotFoundException;
import com.hugo.quiz.exception.question.QuestionNotFoundException;
import com.hugo.quiz.exception.quiz.QuizNotFoundException;
import com.hugo.quiz.exception.user.UserAlreadyExistsException;
import com.hugo.quiz.exception.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public GlobalExceptionHandler(){
        super();
    }

    private ApiError message(final HttpStatus httpStatus, final Exception ex) {

        final String devMessage = ex.getClass().getSimpleName();
        final String message;

        if (ex.getMessage() == null) {
            message = ex.getClass().getSimpleName();
        } else {
            message = ex.getMessage();
        }

        return new ApiError(httpStatus.value(), message, devMessage);

    }

    @ExceptionHandler
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {

        ApiError apiError = message(HttpStatus.NOT_FOUND, ex);

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());

    }

    @ExceptionHandler
    public ResponseEntity<Object> handleQuizNotFoundException(QuizNotFoundException ex, WebRequest request) {

        ApiError apiError = message(HttpStatus.NOT_FOUND, ex);

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());

    }

    @ExceptionHandler
    public ResponseEntity<Object> handleQuestionNotFoundException(QuestionNotFoundException ex, WebRequest request) {

        ApiError apiError = message(HttpStatus.NOT_FOUND, ex);

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());

    }

    @ExceptionHandler
    public ResponseEntity<Object> handlePlayerNotFoundException(PlayerNotFoundException ex, WebRequest request) {

        ApiError apiError = message(HttpStatus.NOT_FOUND, ex);

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());

    }

    @ExceptionHandler
    public ResponseEntity<Object> handleAlternativeNotFoundException(AlternativeNotFoundException ex, WebRequest request) {

        ApiError apiError = message(HttpStatus.NOT_FOUND, ex);

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());

    }

    @ExceptionHandler()
    public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException ex, WebRequest request) {

        ApiError apiError = message(HttpStatus.BAD_REQUEST, ex);

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());

    }

    @ExceptionHandler()
    public ResponseEntity<Object> handlePlayerAlreadyExistsException(PlayerAlreadyExistsException ex, WebRequest request) {

        ApiError apiError = message(HttpStatus.BAD_REQUEST, ex);

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());

    }

}
