package com.hugo.quiz.service;

import com.hugo.quiz.builder.PlayerMapper;
import com.hugo.quiz.builder.QuestionMapper;
import com.hugo.quiz.builder.QuizMapper;
import com.hugo.quiz.dto.QuizDTO;
import com.hugo.quiz.exception.quiz.QuizNotFoundException;
import com.hugo.quiz.model.Quiz;
import com.hugo.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuizMapper quizMapper;
    @Autowired
    PlayerMapper playerMapper;
    @Autowired
    QuestionMapper questionMapper;

    public QuizDTO getQuizById(Long id) {
        return quizMapper.toDTO(quizRepository.findById(id).orElseThrow(QuizNotFoundException::new));
    }

    public List<QuizDTO> getAllQuizzes() {
        return quizMapper.toListDTO(quizRepository.findAll());
    }

    public QuizDTO saveQuiz(QuizDTO quizDTO) {
        Quiz quiz = new Quiz();
        quiz.setQuestions(questionMapper.toList(quizDTO.getQuestions()));
        quiz.setName(quizDTO.getName());
        quiz.setTheme(quizDTO.getTheme());
        quiz.setPlayers(playerMapper.toList(quizDTO.getPlayers()));

        Quiz savedQuiz = quizRepository.save(quiz);
        return quizMapper.toDTO(savedQuiz);
    }

    public void deleteQuizById(long id) {
        quizRepository.deleteById(id);
    }

    public QuizDTO updateQuiz(QuizDTO newQuiz, Long id) {
        Quiz quiz = quizMapper.toEntity(getQuizById(id));
        quiz.setQuestions(questionMapper.toList(newQuiz.getQuestions()));
        quiz.setName(newQuiz.getName());
        quiz.setTheme(newQuiz.getTheme());
        quiz.setPlayers(playerMapper.toList(newQuiz.getPlayers()));

        Quiz savedQuiz = quizRepository.save(quiz);
        return quizMapper.toDTO(savedQuiz);
    }

}
