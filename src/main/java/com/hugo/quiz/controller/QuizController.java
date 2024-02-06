package com.hugo.quiz.controller;

import com.hugo.quiz.dto.PlayerDTO;
import com.hugo.quiz.dto.QuizDTO;
import com.hugo.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping
    public ResponseEntity<List<QuizDTO>> getAllQuizzes() {
        List<QuizDTO> quizDTOList = quizService.getAllQuizzes();
        return new ResponseEntity<>(quizDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable Long id) {
        return new ResponseEntity<>(quizService.getQuizById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<QuizDTO> saveQuiz(@RequestBody QuizDTO quizDTO) {
        return new ResponseEntity<>(quizService.saveQuiz(quizDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<QuizDTO> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuizById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<QuizDTO> updateQuiz(@RequestBody QuizDTO quizDTO, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(quizService.updateQuiz(quizDTO, id), HttpStatus.OK);
    }

    @PutMapping("/insert-player/{id}")
    public ResponseEntity<QuizDTO> insertPlayerInQuiz(@RequestBody PlayerDTO playerToAdd, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(quizService.insertPlayerInQuiz(playerToAdd, id), HttpStatus.OK);
    }

}
