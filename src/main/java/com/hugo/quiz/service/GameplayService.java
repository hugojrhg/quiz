package com.hugo.quiz.service;

import com.hugo.quiz.builder.AlternativeMapper;
import com.hugo.quiz.builder.PlayerMapper;
import com.hugo.quiz.builder.QuestionMapper;
import com.hugo.quiz.dto.PlayerDTO;
import com.hugo.quiz.dto.QuizDTO;
import com.hugo.quiz.dto.UserDTO;
import com.hugo.quiz.model.GameplaySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameplayService {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AlternativeMapper alternativeMapper;

    private GameplaySession gameplaySession = new GameplaySession();

    public PlayerDTO startQuizGameplay(String nickName,UserDTO userDTO , QuizDTO quizDTO) {
        PlayerDTO playerDTO = new PlayerDTO(nickName, userDTO);

        quizDTO.addPlayerInQuiz(playerDTO);
        quizDTO.setQuestions(questionService.findByTheme(quizDTO.getTheme()));

        return playerDTO;
    }

    public GameplaySession getCurrentSession(){
        return gameplaySession;
    }

}
