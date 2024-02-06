package com.hugo.quiz.controller;

import com.hugo.quiz.dto.GameplaySessionDTO;
import com.hugo.quiz.dto.PlayerDTO;
import com.hugo.quiz.service.GameplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameplay")
public class GameplayController {

    @Autowired
    private GameplayService gameplayService;

    @PostMapping("/start")
    public PlayerDTO startGameplay(@RequestBody GameplaySessionDTO gameplayDTO) {
        System.out.println("pause start gameplay");
        return gameplayService.startQuizGameplay(gameplayDTO.getPlayerInSession().getNickName(), gameplayDTO.getPlayerInSession().getUserDTO(), gameplayDTO.getQuizDTO());
    }

}
